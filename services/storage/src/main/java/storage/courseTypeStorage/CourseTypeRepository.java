package storage.courseTypeStorage;

import org.springframework.data.jpa.repository.JpaRepository;
import storage.entity.newentities.CourseType;

public interface CourseTypeRepository extends JpaRepository<CourseType, String> {
}
