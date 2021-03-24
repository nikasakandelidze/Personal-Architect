package storage.project;

import model.project.Project;

public interface ProjectsAdditorStorage {
    void createNewProject(Project project, String authorId);
}
