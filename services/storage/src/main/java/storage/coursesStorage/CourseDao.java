package storage.coursesStorage;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import storage.entity.newentities.Course;
import storage.userStorage.UserDao;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CourseDao {
    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final UserDao userDao;

    public Course addCourseWithUserAsAuthor(Course course, String authorId) {
        return courseRepository.save(course);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseWithIdOf(String id) {
        return courseRepository.findById(id);
    }

    public void flush(){
        courseRepository.flush();
    }

}
