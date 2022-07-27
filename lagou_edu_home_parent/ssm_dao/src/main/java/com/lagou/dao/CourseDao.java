package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;

import java.util.List;

public interface CourseDao {

    public List<Course> findCourseByConditioin(CourseVO courseVO);

    // 新增课程信息
    public void saveCourse(Course course);

    // 新增讲师信息
    public void saveTeacher(Teacher teacher);
}
