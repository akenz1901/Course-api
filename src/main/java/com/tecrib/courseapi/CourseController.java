package com.tecrib.courseapi;

import com.tecrib.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/courses/{id}/lessons")
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/courses/{courseId}/lessons/{id}")
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/courses/{topicId}/lessons")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/lessons/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
