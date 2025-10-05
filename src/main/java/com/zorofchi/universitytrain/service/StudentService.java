package com.zorofchi.universitytrain.service;


import com.zorofchi.universitytrain.model.Student;
import com.zorofchi.universitytrain.repositoy.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public Student update(int id , Student studentRequest){
        Student studentData = studentRepository.findById(id).get();
        if (studentRequest.getFirstname() != null)
            studentData.setFirstname(studentRequest.getFirstname());
        if (studentRequest.getLastname() != null)
            studentData.setLastname(studentRequest.getLastname());
        if (studentRequest.getAge() != 0)
            studentData.setAge(studentRequest.getAge());
        if (studentRequest.getGender() != null)
            studentData.setGender(studentRequest.getGender());
        if (studentRequest.getAddress() != null)
            studentData.setAddress(studentRequest.getAddress());
        return studentRepository.save(studentData);
    }



}
