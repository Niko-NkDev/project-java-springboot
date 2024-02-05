package com.nikonkdev.MySchoolAPP.controllers;

import com.nikonkdev.MySchoolAPP.entities.Course;
import com.nikonkdev.MySchoolAPP.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Se realiza el controlador para realizar un CRUD de la entidad Curso
 */
@RestController
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/course-list") public List<Course> findAll(){
        List<Course> courses = courseRepository.findAll();

        return courses;
    }

    @PostMapping("/create-course") public Course create(@RequestBody Course course){
        Course coursesResponse = courseRepository.save(course);

        return  coursesResponse;
    }

    @PutMapping("/update-course") public Course update(@RequestBody Course course){
        Course courseResponse = courseRepository.save(course);

        return courseResponse;
    }

    @DeleteMapping("/delete-course/{id}") public String delete(@PathVariable Long id){
        courseRepository.deleteById(id);

        return "Se elimino el curso con el id: " + id;
    }
}
