package br.com.solondiego.amigoscodeapi.service;

import br.com.solondiego.amigoscodeapi.entities.Student;
import br.com.solondiego.amigoscodeapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    public final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email já cadastrado");
        }
        studentRepository.save(student);
    }

    public void removeStudent(Long id){
        boolean exists = studentRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Estudante com o id " + id + " não existe");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email){
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Estudante com id " + studentId + " não existe"));
        if(name != null && name.length()>0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }
        if(email != null && email.length()>0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email não existe");
            }
            student.setEmail(email);
        }
    }
}
