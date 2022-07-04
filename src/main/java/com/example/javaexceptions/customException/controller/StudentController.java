package com.example.javaexceptions.customException.controller;

import com.example.javaexceptions.customException.ApiRequestException;
import com.example.javaexceptions.customException.entity.Student;
import com.example.javaexceptions.customException.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    
    private final StudentService studentService;
    
    @GetMapping
    public List<Student> getStudents() {
        throw new ApiRequestException("Oops cannot get all students with custom exception");
//        throw new IllegalStateException("Oops cannot get all students");
//        return studentService.getStudents();
    }
}
