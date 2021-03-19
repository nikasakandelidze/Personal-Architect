package storage;

import model.project.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectsFetcherStorage {
    Optional<Project> getProjectWithIdOf(String projectId);
    List<Project> getAllProjects();
}
