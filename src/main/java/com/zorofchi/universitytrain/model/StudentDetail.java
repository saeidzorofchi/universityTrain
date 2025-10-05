package com.zorofchi.universitytrain.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class StudentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fatherName;
    private boolean maritalStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;


}
