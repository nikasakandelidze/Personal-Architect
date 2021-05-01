package storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import storage.courseUserAssociationStorage.UserCourseDao;
import storage.coursesStorage.CourseDao;
import storage.entity.newentities.Course;
import storage.entity.newentities.Group;
import storage.entity.newentities.User;
import storage.entity.newentities.UserCourseAssosiation;
import storage.groupStorage.GroupDao;
import storage.userStorage.UserDao;

import java.util.ArrayList;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    CourseDao courseDao;

    @Autowired
    UserDao userDao;

    @Autowired
    GroupDao groupDao;

    @Autowired
    UserCourseDao userCourseDao;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUserName("nikasakana");
        user.setFirstName("nika");
        user.setLastName("sakandelidze");
        user.setEmail("nikasakana@gmail.com");
        Course course = new Course();
        course.setMaterialsLink("some link");
        course.setCourseName("IOS");
        course.setDescription("good IOS course");
        course.setGroup(getGroup("IOS", course));
        User user1 = userDao.addNewUser(user);
        Course course1 = courseDao.addCourse(course);
        UserCourseAssosiation assosiation = new UserCourseAssosiation();
        assosiation.setUser(user1);
        assosiation.setCourse(course);
        assosiation.setUserId(user1.getUserId());
        assosiation.setCourseId(course1.getCourseId());
        assosiation.set_author(true);
        user1.setUserCourseAssosiationEntities(List.of(assosiation));
        course1.setUserCourseAssosiationEntities(List.of(assosiation));
        userCourseDao.addNewAssociation(assosiation);
    }

    Group getGroup(String groupName, Course course) {
        Group group = new Group();
        group.setGroupName(groupName);
        group.setCourse(course);
        return groupDao.addNewGroup(group);
    }
}
