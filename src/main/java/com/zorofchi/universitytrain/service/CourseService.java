package com.zorofchi.universitytrain.service;

import com.zorofchi.universitytrain.model.Course;
import com.zorofchi.universitytrain.repositoy.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course update(int id, Course courseRequest) {
        Course courseData = courseRepository.findById(id).get();

        if (courseRequest.getTitle() != null)
            courseData.setTitle(courseRequest.getTitle());
        if (courseRequest.getUnit() != 0)
            courseData.setUnit(courseRequest.getUnit());
        if (courseRequest.getDescription() != null)
            courseData.setDescription(courseRequest.getDescription());
        return courseRepository.save(courseData);

    }

}
