package storage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "groups")
@NoArgsConstructor
@Data
public class Group {
    @Id
    private long id;

    @Column(name = "group_name")
    private String groupName;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
