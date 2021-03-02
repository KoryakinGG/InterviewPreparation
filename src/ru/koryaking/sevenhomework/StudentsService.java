package ru.koryaking.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class StudentsService {

    private StudentsRepository studentsRepository;

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository){
        this.studentsRepository = studentsRepository;
    }

    public void saveOrUpdate(Student student) {
        studentsRepository.save(student);
    }

    public Optional<Student> findById(Long id) {
        return studentsRepository.findById(id);
    }

    public void deleteById(Long id) {
        studentsRepository.deleteById(id);
    }

    public List<Student> findAll() {
        return studentsRepository.findAll();
    }




}
