BEGIN;

DROP TABLE IF EXISTS homework5 CASCADE;
CREATE TABLE homework5 (id bigserial PRIMARY KEY, name VARCHAR(255), mark VARCHAR(255));
INSERT INTO homework5 (name, mark) VALUES
('Alexander', "1"),
('Bob', "2"),
('John', "1");

COMMIT;