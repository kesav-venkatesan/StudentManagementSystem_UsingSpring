package com.studentDB.demo.Repository;

import com.studentDB.demo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
