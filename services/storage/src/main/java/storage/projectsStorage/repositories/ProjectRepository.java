package storage.projectsStorage.repositories;

import org.springframework.data.repository.CrudRepository;
import storage.entity.ProjectEntity;

public interface ProjectRepository extends CrudRepository<ProjectEntity, String> {
}
