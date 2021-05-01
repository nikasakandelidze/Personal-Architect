package storage.entity.newentities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "groups")
@NoArgsConstructor
@Data
public class Group {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "group_name")
    private String groupName;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "course_id")
    private Course course;
}
