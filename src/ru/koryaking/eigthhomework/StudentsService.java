package ru.koryaking.eigthhomework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {
    private StudentsRepository studentsRepository;

    @Autowired
    public void setStudentsRepository (StudentsRepository studentsRepository){
        this.studentsRepository = studentsRepository;
    }

    // вызываем метод findAll у репозитория JPARepository
    public List<Student> getAll () {
        return studentsRepository.findAll();
    }

    public Student saveOrUpdate (Student student){
        return studentsRepository.save(student);
    }

    public Student findById (Long id) {
        return studentsRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Can't find this id: " + id));
    }

}
