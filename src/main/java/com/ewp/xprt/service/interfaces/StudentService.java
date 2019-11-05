package com.ewp.xprt.service.interfaces;

import com.ewp.xprt.model.Student;

public interface StudentService extends CommonService<Student> {

    Student getStudentByCvId(String cvId);
}
