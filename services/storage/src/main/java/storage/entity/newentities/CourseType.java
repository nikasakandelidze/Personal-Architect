package storage.entity.newentities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course_types")
@Data
@NoArgsConstructor
public class CourseType {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String courseType;

    private String description;

    @OneToMany(mappedBy = "courseType", cascade=CascadeType.ALL)
    private List<Course> course;
}
