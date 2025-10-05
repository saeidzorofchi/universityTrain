package com.zorofchi.universitytrain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class  Student extends Person {


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                    CascadeType.MERGE})
    @JoinTable(name = "student_course",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private Set<Course> courses = new HashSet<>();



    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student-detail-id")
    private StudentDetail studentDetail;

    public void addCourse(Course course){
        courses.add(course);
    }


}
