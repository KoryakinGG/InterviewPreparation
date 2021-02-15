
/**
 * Задача про кинотеатр.
 * У фильма, который идет в кинотеатре, есть название, длительность (пусть будет 60, 90 или 120 минут),
 * цена билета (в разное время и дни может быть разной), время начала сеанса (один фильм может быть показан
 * несколько раз в разное время и с разной ценой билета).
 * Есть информация о купленных билетах (номер билета, на какой сеанс).
 */



public class Sql {
    /**
     * Составить грамотную нормализованную схему хранения этих данных в БД.
     * Внести в нее 4–5 фильмов, расписание на один день и несколько проданных билетов.
     */

    CREATE TABLE public.film_tbl (
            film_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name_of_movie_fld character varying(255) COLLATE pg_catalog."default" NOT NULL,
    duration_fld smallint NOT NULL,
    CONSTRAINT name_of_the_movie_pkey PRIMARY KEY (film_id)
)

    TABLESPACE pg_default;

    ALTER TABLE public.film_tbl
    OWNER to postgres;

//    -------------------*******************---------------------*******************---------------------

    CREATE TABLE public.session_tbl(
            film_id integer NOT NULL,
            start_time_film_fld time without time zone NOT NULL,
            price_id integer,
            id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    tickets_sold_fld smallint,
    CONSTRAINT session_tbl_pkey PRIMARY KEY (id),
    CONSTRAINT film_id FOREIGN KEY (film_id)
    REFERENCES public.film_tbl (film_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID,
    CONSTRAINT price_id FOREIGN KEY (price_id)
    REFERENCES public.ticket_price_tbl (price_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID
)

    TABLESPACE pg_default;

    ALTER TABLE public.session_tbl
    OWNER to postgres;

//    -------------------*******************---------------------*******************---------------------

    CREATE TABLE public.ticket_price_tbl(
            price_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    price_fld double precision,
    CONSTRAINT ticket_price_tbl_pkey PRIMARY KEY (price_id)
)

    TABLESPACE pg_default;

    ALTER TABLE public.ticket_price_tbl
    OWNER to postgres;

    /**
     * Сделать запросы, считающие и выводящие в понятном виде:
     * ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени.
     * Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;
     */

    SELECT  x.film_name_1,
    x.start_time_film_1,
    x.film_1_duration,
    y.film_name_2,
    y.start_time_film_2,
    y.film_2_duration

    FROM ( SELECT	x.name_of_movie_fld AS film_name_1,
           x.duration_fld AS film_1_duration,
           y.start_time_film_fld AS start_time_film_1,
           y.start_time_film_fld  + x.duration_fld * INTERVAL '1' MINUTE AS finish_time_film_1
                   FROM film_tbl AS x LEFT JOIN session_tbl AS y USING (film_id)
	   ) x,
            (
    SELECT	x.name_of_movie_fld AS film_name_2,
    x.duration_fld AS film_2_duration,
    y.start_time_film_fld AS start_time_film_2,
    y.start_time_film_fld  + x.duration_fld * INTERVAL '1' MINUTE AS finish_time_film_2
    FROM film_tbl AS x LEFT JOIN session_tbl AS y USING (film_id)
	   ) y
    WHERE x.film_name_1 != y.film_name_2  AND x.start_time_film_1 < y.finish_time_film_2
    AND x.start_time_film_1 > y.start_time_film_2
    ORDER BY x.start_time_film_1;


    /**
     * перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
     * Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;
     */

    SELECT   x.film_name_1,
    x.start_time_film_1,
    x.film_1_duration,
    y.start_time_film_2,
    y.start_time_film_2 - x.finish_time_film_1 + INTERVAL '30' MINUTE as duration_of_the_break

    FROM ( SELECT	x.name_of_movie_fld AS film_name_1,
           x.duration_fld AS film_1_duration,
           y.start_time_film_fld AS start_time_film_1,
           y.start_time_film_fld  + x.duration_fld * INTERVAL '1' MINUTE AS finish_time_film_1
                   FROM film_tbl AS x LEFT JOIN session_tbl AS y USING (film_id)
	   ) x,
            (
    SELECT	x.name_of_movie_fld AS film_name_2,
    x.duration_fld AS film_2_duration,
    y.start_time_film_fld AS start_time_film_2,
    y.start_time_film_fld  + x.duration_fld * INTERVAL '1' MINUTE AS finish_time_film_2
    FROM film_tbl AS x LEFT JOIN session_tbl AS y USING (film_id)
	   ) y

    WHERE (y.start_time_film_2 - x.finish_time_film_1 + INTERVAL '30' MINUTE) > '00:00:01'
    ORDER BY duration_of_the_break DESC;


    /**
     * список фильмов, для каждого — с указанием общего числа посетителей за все время,
     * среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли).
     * Внизу таблицы должна быть строчка «итого», содержащая данные по всем фильмам сразу;
     * @return
     */

    SELECT COALESCE(title, 'Итого: ') as "Название фильма",
    sum(M.visitors)            as "Всего посетителей",
    avg(M.visitors)::int       as "Ср.число за сеанс",
    sum(M.visitors * M.price)  as "Общий сбор по фильму"
    from (
            select x.name_of_movie_fld as title,
            y.tickets_sold_fld as visitors,
            y.price_id as price
                    from   film_tbl as x
                    join session_tbl as y using (film_id)
     ) M
    group by grouping sets ( title, ())
    order by "Общий сбор по фильму";
