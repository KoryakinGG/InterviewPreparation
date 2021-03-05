package ru.koryaking.eigthhomework;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//наследуемся от спрингового репозитория указываем ему с какой сущностью он работает и какой тип id у него
@Repository
public interface StudentsRepository extends JpaRepository <Student, Long>{

}
