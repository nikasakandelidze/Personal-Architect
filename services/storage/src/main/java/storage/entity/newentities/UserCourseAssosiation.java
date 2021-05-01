package storage.entity.newentities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user_course_association")
@IdClass(UserCourseCompositeId.class)
@Data
@NoArgsConstructor
public class UserCourseAssosiation {
    @Id
//    @Column(name = "user_id")
    private String userId;
    @Id
//    @Column(name = "course_id")
    private String courseId;

    @Column(name = "is_author")
    private boolean is_author;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "courseId", referencedColumnName = "courseId")
    private Course course;
}
