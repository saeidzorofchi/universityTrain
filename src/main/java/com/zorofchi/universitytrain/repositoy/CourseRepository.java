package com.zorofchi.universitytrain.repositoy;

import com.zorofchi.universitytrain.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository< Course ,Integer > {
}


