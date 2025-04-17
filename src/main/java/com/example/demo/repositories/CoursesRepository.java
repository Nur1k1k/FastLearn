package com.example.demo.repositories;

import com.example.demo.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
}
