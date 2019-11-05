package com.ewp.xprt.repository.interfaces;

import com.ewp.xprt.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student getStudentByCvId (String cvId);
}
