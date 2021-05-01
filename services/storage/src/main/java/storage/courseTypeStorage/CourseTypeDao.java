package storage.courseTypeStorage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import storage.entity.newentities.CourseType;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CourseTypeDao {
    private final CourseTypeRepository courseTypeRepository;

    public void addCourseType(CourseType courseType) {
        courseTypeRepository.save(courseType);
    }

    public List<CourseType> getAllCourseTypes() {
        return courseTypeRepository.findAll();
    }

    public Optional<CourseType> getCourseTypeWithIdOf(String id) {
        return courseTypeRepository.findById(id);
    }
}
