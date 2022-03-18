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
@RequestMapping("/api/student")
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

    @PostMapping("/add")
    public @ResponseBody void  registerNewStudent(Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping("remove/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        studentService.removeStudent(id);
    }

    @PutMapping("/update/{id}")
    public void updateStudent(@PathVariable("id") Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        studentService.updateStudent(id, name, email);
    }
}
