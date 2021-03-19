package storage.projectsStorage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import storage.entity.ProjectEntity;

@Component
public interface ProjectRepository extends CrudRepository<ProjectEntity, String> {
}
