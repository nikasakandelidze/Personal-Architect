package storage.courseUserAssociationStorage;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import storage.entity.newentities.UserCourseAssosiation;

@Repository
@RequiredArgsConstructor
public class UserCourseDao {
    @Autowired
    private final UserCourseAssociationRepo userCourseAssociationRepo;

    public UserCourseAssosiation addNewAssociation(UserCourseAssosiation userCourseAssosiation) {
        return userCourseAssociationRepo.save(userCourseAssosiation);
    }
}
