package storage.coursesStorage;

import org.springframework.data.jpa.repository.JpaRepository;
import storage.entity.newentities.Course;

public interface CourseRepository extends JpaRepository<Course, String> {
}
