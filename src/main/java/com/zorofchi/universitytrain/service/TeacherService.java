package com.zorofchi.universitytrain.service;

import com.zorofchi.universitytrain.model.Teacher;
import com.zorofchi.universitytrain.repositoy.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher update( int id ,Teacher teacherReguest) {

        Teacher teacherData = teacherRepository.findById(id).get();
        if (teacherReguest.getFirstname() != null)
            teacherData.setFirstname(teacherReguest.getFirstname());
        if (teacherReguest.getLastname() != null)
            teacherData.setLastname(teacherReguest.getLastname());
        if (teacherReguest.getAge() != 0)
            teacherData.setAge(teacherReguest.getAge());
        if (teacherReguest.getGender() != null)
            teacherData.setGender(teacherReguest.getGender());
        if (teacherReguest.getAddress() != null)
            teacherData.setAddress(teacherReguest.getAddress());
        return teacherRepository.save(teacherData);

    }
}
