package com.zorofchi.universitytrain.repositoy;

import com.zorofchi.universitytrain.model.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailRepository extends JpaRepository<StudentDetail , Integer> {
}
