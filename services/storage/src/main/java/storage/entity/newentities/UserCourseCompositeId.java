package storage.entity.newentities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserCourseCompositeId implements Serializable {
    private String userId;
    private String courseId;
}
