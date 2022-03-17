package br.com.solondiego.amigoscodeapi.controllers;

import br.com.solondiego.amigoscodeapi.entities.Student;
import br.com.solondiego.amigoscodeapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/get")
    public List<Student> getStudents(){

        return studentService.getStudents();
    }

    @PostMapping("/save")
    public @ResponseBody Student savedStudent(Student student){
        studentService.saveStudent(student);
        return student;
    }
}
