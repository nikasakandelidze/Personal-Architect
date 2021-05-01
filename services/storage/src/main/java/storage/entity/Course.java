package storage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
public class Course {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String courseName;

    @Column(name = "description")
    private String description;

    @Column(name = "materials_link")
    private String materialsLink;

    @OneToMany(mappedBy = "course")
    private List<UserCourseAssosiation> userCourseAssosiations;

    @OneToOne(mappedBy = "course")
    private Group group;
}
