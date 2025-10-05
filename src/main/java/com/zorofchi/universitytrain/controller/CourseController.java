package com.zorofchi.universitytrain.controller;


import com.zorofchi.universitytrain.model.Course;
import com.zorofchi.universitytrain.model.auth.EnumRole;
import com.zorofchi.universitytrain.repositoy.CourseRepository;
import com.zorofchi.universitytrain.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseService courseService;


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Course> courses() {
        return courseRepository.findAll();
    }


    @GetMapping("{id}")
    public Course course(@PathVariable("id") int id) {
        return courseRepository.findById(id).get();
    }


    @PostMapping
    public Course save(@RequestBody Course courseReguest) {
        return courseRepository.save(courseReguest);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) {
        courseRepository.deleteById(id);
    }


    @PutMapping("{id}")
    public Course update(@PathVariable int id, @RequestBody Course courseRequest) {
        return courseService.update(id,courseRequest);
    }

}
