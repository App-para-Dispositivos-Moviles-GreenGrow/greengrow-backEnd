package com.greengrow.backend.service;

import com.greengrow.backend.model.Course;

import java.util.List;

/**
 * Service interface for managing Course entities in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
public interface CourseService {

    /**
     * Creates a new course.
     *
     * @param course The course to be created.
     * @return The created course.
     */
    Course createCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    List<Course> getCoursesByUserId(Long userId);
    void deleteCourseById(Long id);
}