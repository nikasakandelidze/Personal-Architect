package storage.userCourseAssociationStorage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import storage.entity.newentities.UserCourseAssosiation;
import storage.entity.newentities.UserCourseCompositeId;

import java.util.List;

public interface UserCourseRepository extends JpaRepository<UserCourseAssosiation, UserCourseCompositeId> {
    @Query("select e from UserCourseAssosiation e where e.userId=?1")
    List<UserCourseAssosiation> getAssociationWithUserIdOf(String userId);

    @Query("select e from UserCourseAssosiation e where e.courseId=?1")
    List<UserCourseAssosiation> getAssociationWithCourseIdOf(String courseId);
}
