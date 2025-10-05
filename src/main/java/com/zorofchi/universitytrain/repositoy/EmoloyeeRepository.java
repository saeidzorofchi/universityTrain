package com.zorofchi.universitytrain.repositoy;


import com.zorofchi.universitytrain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmoloyeeRepository extends JpaRepository<Employee,Integer> {
}
