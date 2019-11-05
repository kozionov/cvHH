package com.ewp.xprt.service.interfaces;

import com.ewp.xprt.model.Course;

public interface CourseService extends CommonService<Course> {
    Course getByName(String name);
}
