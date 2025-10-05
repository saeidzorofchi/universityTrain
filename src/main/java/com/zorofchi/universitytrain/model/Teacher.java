package com.zorofchi.universitytrain.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Teacher extends Person{

    @ManyToMany(fetch = FetchType.LAZY ,
            cascade = {
                CascadeType.PERSIST,
                    CascadeType.MERGE})
    @JoinTable(name = "teacher_course" ,
            joinColumns = {@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private Set<Course> courses = new HashSet<>();

}
