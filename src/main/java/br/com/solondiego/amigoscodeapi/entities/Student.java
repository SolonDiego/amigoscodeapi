package br.com.solondiego.amigoscodeapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private long id;
    private String name;
    private String email;
    private LocalDate dob;
    private int age;
}
