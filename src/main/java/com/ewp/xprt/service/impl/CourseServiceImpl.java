package com.ewp.xprt.service.impl;

import com.ewp.xprt.model.Course;
import com.ewp.xprt.repository.interfaces.CourseRepository;
import com.ewp.xprt.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course get(Long id) {
        return courseRepository.getOne(id);
    }

    @Override
    public Course add(Course entity) {
        return courseRepository.saveAndFlush(entity);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public void update(Course entity) {
        courseRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void delete(Course entity) {
        courseRepository.delete(entity);
    }

    @Override
    public Course getByName(String name) {
        return courseRepository.findByName(name);
    }
}
