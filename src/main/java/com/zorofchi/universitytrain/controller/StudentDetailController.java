package com.zorofchi.universitytrain.controller;

import com.zorofchi.universitytrain.model.Student;
import com.zorofchi.universitytrain.model.StudentDetail;
import com.zorofchi.universitytrain.repositoy.StudentDetailRepository;
import com.zorofchi.universitytrain.repositoy.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student-detail")
public class StudentDetailController {
    @Autowired
    private StudentDetailRepository studentDetailRepository;
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/{studentId},/studentDetail")
    public StudentDetail save(@PathVariable("studentId") int studentId, @RequestBody StudentDetail studentDetailRequest) {
        Student studentData = studentRepository.findById(studentId).get();
        studentDetailRequest.setStudent(studentData);
        return studentDetailRepository.save(studentDetailRequest);
    }

    @GetMapping
    public List<StudentDetail> studentDetails() {
        return studentDetailRepository.findAll();
    }

    @GetMapping("{student-detail-id}")
    public StudentDetail studentDetail(@PathVariable("student-detail-id") int id) {
        return studentDetailRepository.findById(id).get();
    }

//    @PutMapping(("/{student-id},/student-detail"))
//    public StudentDetail update(@PathVariable("student-id") int studentId,
//                                @RequestBody StudentDetail studentDetailRequest){
//        Student studentData = studentRepository.findById(studentId).get();
//
//
//
//    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) {
        studentDetailRepository.deleteById(id);
    }
}


