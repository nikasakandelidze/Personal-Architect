package storage.coursesStorage;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import storage.entity.newentities.Course;
import storage.entity.newentities.UserCourseAssosiation;
import storage.userCourseAssociationStorage.UserCourseAssociationDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CourseDao {
    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final UserCourseAssociationDao userCourseAssociationDao;

    public void addCourseWithUserAsAuthor(Course course, String authorId) {
        courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseWithIdOf(String id) {
        return courseRepository.findById(id);
    }

    public List<Course> getAllCoursesForUserWithIdOf(String id) {
        return userCourseAssociationDao.getAssociationsWithUserIdOf(id)
                .stream()
                .map(UserCourseAssosiation::getCourse)
                .collect(Collectors.toList());
    }
}
