package com.tecrib.lesson;

import com.tecrib.courseapi.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping("/topics/{id}/courses")
    public List<Lesson> getAllLessons(@PathVariable String id){
        return lessonService.getAllLessons(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Lesson getLesson(@PathVariable String id){
        return lessonService.getLesson(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/courses/{courseId}/courses")
    public void addLesson(@RequestBody Lesson lesson, @PathVariable String courseId){
        lesson.setCourse(new Course(courseId, "", ""));
        lessonService.addLesson(lesson);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{courseId}/courses/{id}")
    public void updateTopic(@RequestBody Lesson lesson, @PathVariable String courseId, @PathVariable String id){
        lesson.setCourse(new Course(courseId, "", ""));
        lessonService.updateLesson(lesson);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteLesson(@PathVariable String id){
        lessonService.deleteLesson(id);
    }
}
