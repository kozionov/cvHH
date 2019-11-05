package com.ewp.xprt.service.impl;

import com.ewp.xprt.model.Student;
import com.ewp.xprt.repository.interfaces.StudentRepository;
import com.ewp.xprt.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student get(Long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public Student add(Student entity) {
        return studentRepository.saveAndFlush(entity);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public void update(Student entity) {
        studentRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void delete(Student entity) {
        studentRepository.delete(entity);
    }

    @Override
    public Student getStudentByCvId(String cvId) {
        return studentRepository.getStudentByCvId(cvId);
    }
}
