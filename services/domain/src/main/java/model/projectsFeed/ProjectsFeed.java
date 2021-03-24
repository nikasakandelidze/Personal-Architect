package model.projectsFeed;

import model.project.Project;
import storage.project.ProjectsAdditorStorage;
import storage.project.ProjectsFetcherStorage;

import java.util.List;
import java.util.Optional;

public class ProjectsFeed {
    private final ProjectsAdditorStorage projectsAdditorStorage;
    private final ProjectsFetcherStorage projectsFetcherStorage;

    public ProjectsFeed(ProjectsAdditorStorage projectsAdditorStorage, ProjectsFetcherStorage projectsFetcherStorage) {
        this.projectsAdditorStorage = projectsAdditorStorage;
        this.projectsFetcherStorage = projectsFetcherStorage;
    }

    public void addNewProject(Project project, String authorId) {
        projectsAdditorStorage.createNewProject(project, authorId);
    }

    public Optional<Project> getProjectWithIdOf(String projectId) {
        return projectsFetcherStorage.getProjectWithIdOf(projectId);
    }

    public List<Project> getAllProjects() {
        return projectsFetcherStorage.getAllProjects();
    }
}
