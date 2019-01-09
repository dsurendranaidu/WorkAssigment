package com.university.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.university.student.exception.ResourceNotFoundException;
import com.university.student.model.Student;
import com.university.student.repository.UniversityRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
    UniversityRepository universityRepository;
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
	    return universityRepository.findAll();
	}
	
	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student student) {
	    return universityRepository.save(student);
	}
	
	@GetMapping("/students/{id}")
	public Student getNoteById(@PathVariable(value = "id") Long student_id) {
	    return universityRepository.findById(student_id)
	            .orElseThrow(() -> new ResourceNotFoundException("Student", "id", student_id));
	}
	
	@PutMapping("/students/{id}")
	public Student updateStudent(@PathVariable(value = "id") Long student_id,
	                                        @Valid @RequestBody Student studentDetails) {

		Student student = universityRepository.findById(student_id)
	            .orElseThrow(() -> new ResourceNotFoundException("Student", "id", student_id));

	    student.setStudent_name(studentDetails.getStudent_name());
	    student.setStudent_age(studentDetails.getStudent_age());
	    student.setDepartment(studentDetails.getDepartment());
	    student.setCourse(studentDetails.getCourse());

	    Student updateStudent = universityRepository.save(student);
	    return updateStudent;
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long student_id) {
		Student student = universityRepository.findById(student_id)
	            .orElseThrow(() -> new ResourceNotFoundException("Student", "id", student_id));

	    universityRepository.delete(student);

	    return ResponseEntity.ok().build();
	}

}
