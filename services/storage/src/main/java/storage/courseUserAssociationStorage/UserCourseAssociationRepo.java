package storage.courseUserAssociationStorage;

import org.springframework.data.jpa.repository.JpaRepository;
import storage.entity.newentities.UserCourseAssosiation;
import storage.entity.newentities.UserCourseCompositeId;

public interface UserCourseAssociationRepo extends JpaRepository<UserCourseAssosiation, UserCourseCompositeId> {
}
