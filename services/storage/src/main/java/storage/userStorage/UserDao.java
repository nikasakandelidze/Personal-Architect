package storage.userStorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import storage.entity.newentities.User;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {
    @Autowired
    private UserRepository userRepository;

    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserWithIdOf(String id) {
        return userRepository.findById(id);
    }

    public void flush() {
        userRepository.flush();
    }
}
