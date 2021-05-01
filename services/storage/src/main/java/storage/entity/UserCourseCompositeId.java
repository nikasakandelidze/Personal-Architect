package storage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserCourseCompositeId implements Serializable {
    private long userId;
    private long courseId;
}
