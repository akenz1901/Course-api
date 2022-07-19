package com.tecrib.lesson;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, String> {

    List<Lesson> findByCourseId(String courseId);
}
