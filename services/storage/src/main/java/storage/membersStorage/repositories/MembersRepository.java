package storage.membersStorage.repositories;

import org.springframework.data.repository.CrudRepository;
import storage.entity.ProjectMemberEntity;

public interface MembersRepository extends CrudRepository<ProjectMemberEntity, String> {
}
