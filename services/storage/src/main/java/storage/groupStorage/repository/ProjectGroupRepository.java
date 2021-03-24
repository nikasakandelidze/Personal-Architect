package storage.groupStorage.repository;

import org.springframework.data.repository.CrudRepository;
import storage.entity.ProjectgroupEntity;

public interface ProjectGroupRepository extends CrudRepository<ProjectgroupEntity, String> {
}
