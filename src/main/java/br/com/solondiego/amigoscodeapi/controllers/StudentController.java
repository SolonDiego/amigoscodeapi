package br.com.solondiego.amigoscodeapi.controllers;

import br.com.solondiego.amigoscodeapi.entities.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api/v1/estudantes")
public class StudentController {

    @GetMapping
    public List<Student> getStudents(){
        return List.of(new Student(1,"SolonDiego", "solondiego@gmail.com", LocalDate.of(1985, Month.MARCH,1),37));

    }
}
