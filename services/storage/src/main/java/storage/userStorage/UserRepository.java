package storage.userStorage;

import org.springframework.data.jpa.repository.JpaRepository;
import storage.entity.newentities.User;

public interface UserRepository extends JpaRepository<User, String> {
}
