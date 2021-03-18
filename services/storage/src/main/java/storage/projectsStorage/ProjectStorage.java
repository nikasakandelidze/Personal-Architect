package storage.projectsStorage;

import org.springframework.data.repository.CrudRepository;
import storage.entity.ProjectEntity;

public interface ProjectStorage extends CrudRepository<ProjectEntity, String> {
}
