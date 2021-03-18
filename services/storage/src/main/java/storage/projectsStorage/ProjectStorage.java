package storage.projectsStorage;

import storage.entity.ProjectEntity;

import java.util.List;

public interface ProjectStorage {
    void persistProject(ProjectEntity projectEntity);
    List<ProjectEntity> getAllProjects();
    ProjectEntity getProjectEntitybyId(String projectId);

}
