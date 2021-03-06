package br.com.solondiego.amigoscodeapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "student")
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "id_student")
    private long id;
    private String name;
    private String email;
    private LocalDate dob;
    private int age;

    public void setDob(String dob) {
        LocalDate localDate = LocalDate.parse(dob);
        this.dob = localDate;
    }

//    public Integer getAge(){
//        return Period.between(this.dob, LocalDate.now()).getYears();
//    }
}
