package storage.groupStorage;

import org.springframework.data.jpa.repository.JpaRepository;
import storage.entity.newentities.Group;

public interface GroupRepository extends JpaRepository<Group, String> {
}
