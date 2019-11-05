package com.ewp.xprt.controller.rest;

import com.ewp.xprt.model.Student;
import com.ewp.xprt.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "rest/student")
//@PreAuthorize("hasAnyAuthority('ADMIN')")
public class StudentRestController {
    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity getAllStudents() {
        List<Student> list = studentService.getAll();
        return ResponseEntity.ok(list);
    }

}
