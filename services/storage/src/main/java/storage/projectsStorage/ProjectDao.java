package storage.projectsStorage;

import storage.entity.ProjectEntity;

import java.util.List;
import java.util.Optional;

public interface ProjectDao {
    void persistProject(ProjectEntity projectEntity);
    List<ProjectEntity> getAllProjects();
    Optional<ProjectEntity> getProjectbyId(String projectId);
}
