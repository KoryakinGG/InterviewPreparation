package ru.koryaking.eigthhomework;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentsController {
    private StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping
    public String showAllStudents(Model model) {
        List<Student> students = studentsService.getAll();
        model.addAttribute("students", students);
        return "all_students";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add_student_form";
    }

    @PostMapping("/add")
    public String saveNewStudent(@ModelAttribute Student newStudent) {
        studentsService.saveOrUpdate(newStudent);
        return "redirect:/students/";
    }

    @GetMapping ("/edit/{id}")
    public String showEditForm (@PathVariable Long id, Model model){
        model.addAttribute("student", studentsService.findById(id));
        return "edit_student_form";
    }

    @PostMapping ("/edit")
    public String modifyStudent (@ModelAttribute Student modifiedStudent) {
        studentsService.saveOrUpdate(modifiedStudent);
        return "redirect:/students";
    }
}
