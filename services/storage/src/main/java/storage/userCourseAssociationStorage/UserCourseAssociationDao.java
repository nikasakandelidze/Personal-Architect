package storage.userCourseAssociationStorage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import storage.entity.newentities.UserCourseAssosiation;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserCourseAssociationDao {
    private final UserCourseRepository userCourseRepository;

    public void addNewUserCourseAssociation(UserCourseAssosiation userCourseAssosiation) {
        userCourseRepository.save(userCourseAssosiation);
    }

    public List<UserCourseAssosiation> getAssociations() {
        return userCourseRepository.findAll();
    }

    public List<UserCourseAssosiation> getAssociationsWithUserIdOf(String userId) {
        return userCourseRepository.getAssociationWithUserIdOf(userId);
    }

    public List<UserCourseAssosiation> getAssociationsWithCourseIdOf(String courseId) {
        return userCourseRepository.getAssociationWithCourseIdOf(courseId);
    }

}
