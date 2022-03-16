package br.com.solondiego.amigoscodeapi.service;

import br.com.solondiego.amigoscodeapi.entities.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(new Student(1,"SolonDiego", "solondiego@gmail.com", LocalDate.of(1985, Month.MARCH,1),37));

    }
}
