package com.lagou.service.impl;

import com.lagou.dao.CourseDao;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> findCourseByConditioin(CourseVO courseVO) {
        List<Course> list = courseDao.findCourseByConditioin(courseVO);
        return list;
    }

    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {

        Course course = new Course();

        //apache的BeanUtils.copyProperties    与 spring的BeanUtils.copyProperties
        //    将后者拷贝给前者                            将前者拷贝给后者
        BeanUtils.copyProperties(course,courseVO);

        // 补全信息
        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);

        // 保存课程信息
        courseDao.saveCourse(course);

        // 获取插入数据的id
        int id = course.getId();

        // 补权信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVO);

        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        teacher.setCourseId(id);

        // 保存教师信息
        courseDao.saveTeacher(teacher);

    }
}
