package com.zorofchi.universitytrain.repositoy;

import com.zorofchi.universitytrain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student ,Integer > {
}
