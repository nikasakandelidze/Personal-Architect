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
    @Column(name = "id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "name")
    private String courseName;

    @Column(name = "description")
    private String description;

    @Column(name = "materials_link")
    private String materialsLink;

    @OneToMany(mappedBy = "course")
    @Column(insertable = false)
    private List<UserCourseAssosiation> userCourseAssosiationEntities;

    @OneToOne(mappedBy = "course")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "course_type_id")
    private CourseType courseType;
}
