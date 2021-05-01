package storage.entity.newentities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_course_association")
@IdClass(UserCourseCompositeId.class)
@Data
@NoArgsConstructor
public class UserCourseAssosiation {
    @Id
    @Column(name = "user_id", insertable = false, updatable = false)
    private String userId;
    @Id
    @Column(name = "course_id", insertable = false, updatable = false)
    private String courseId;
    @Column(name = "is_author", insertable = false, updatable = false)
    private boolean is_author;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "courseId", referencedColumnName = "id")
    private Course course;
}
