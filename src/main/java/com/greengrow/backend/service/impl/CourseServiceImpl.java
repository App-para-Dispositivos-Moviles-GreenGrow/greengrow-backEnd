package com.greengrow.backend.service.impl;

import com.greengrow.backend.exception.ResourceNotFoundException;
import com.greengrow.backend.model.Course;
import com.greengrow.backend.repository.CourseRepository;
import com.greengrow.backend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the CourseService interface that interacts with the CourseRepository.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
    }


    @Override
    public List<Course> getCoursesByUserId(Long userId) {
        return courseRepository.findByUserId(userId);
    }

    @Override
    public void deleteCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
        courseRepository.delete(course);
    }
}
