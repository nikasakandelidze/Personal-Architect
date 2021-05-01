package storage.entity.newentities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String courseId;

    @Column(name = "name")
    private String courseName;

    @Column(name = "description")
    private String description;

    @Column(name = "materials_link")
    private String materialsLink;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<UserCourseAssosiation> userCourseAssosiationEntities;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private Group group;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_type_id")
    private CourseType courseType;
}
