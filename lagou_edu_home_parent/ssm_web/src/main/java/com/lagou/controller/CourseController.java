package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findCourseByConditioin")
    public ResponseResult findCourseByConditioin(@RequestBody CourseVO courseVO){

        List<Course> list = courseService.findCourseByConditioin(courseVO);
        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",list);
        System.out.println(responseResult);
        return responseResult;
    }

    @RequestMapping("/saveCourseOrTeacher")
    public ResponseResult saveCourseOrTeacher(@RequestBody CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {

        courseService.saveCourseOrTeacher(courseVO);

        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",null);
        return responseResult;
    }
}
