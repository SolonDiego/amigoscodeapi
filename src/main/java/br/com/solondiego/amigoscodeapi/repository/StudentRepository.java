package br.com.solondiego.amigoscodeapi.repository;

import br.com.solondiego.amigoscodeapi.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
