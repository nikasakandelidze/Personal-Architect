package storage.groupStorage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import storage.entity.newentities.Group;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GroupDao {
    private final GroupRepository groupRepository;

    public Group addNewGroup(Group group) {
        return groupRepository.save(group);
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Optional<Group> getGroupWithidOf(String id) {
        return groupRepository.findById(id);
    }
}
