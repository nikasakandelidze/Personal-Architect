package storage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "course_types")
@Data
@NoArgsConstructor
public class CourseType {
    @Id
    private long id;

    private String courseType;

    private String description;

    @OneToMany(mappedBy = "courseType")
    private List<Course> courses;
}
