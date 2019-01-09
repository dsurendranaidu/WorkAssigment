package com.university.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.student.model.Student;

@Repository
public interface UniversityRepository extends JpaRepository<Student, Long> {

}
