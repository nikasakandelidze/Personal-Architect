package model.projectsFeed;

import model.project.Project;
import storage.ProjectsAdditorStorage;
import storage.ProjectsFetcherStorage;

import java.util.List;
import java.util.Optional;

public class ProjectsFeed {
    private final ProjectsAdditorStorage projectsAdditorStorage;
    private final ProjectsFetcherStorage projectsFetcherStorage;

    public ProjectsFeed(ProjectsAdditorStorage projectsAdditorStorage, ProjectsFetcherStorage projectsFetcherStorage) {
        this.projectsAdditorStorage = projectsAdditorStorage;
        this.projectsFetcherStorage = projectsFetcherStorage;
    }

    public void addNewProject(Project project) {
        projectsAdditorStorage.addProject(project);
    }

    public Optional<Project> getProjectWithIdOf(String projectId) {
        return projectsFetcherStorage.getProjectWithIdOf(projectId);
    }

    public List<Project> getAllProjects() {
        return projectsFetcherStorage.getAllProjects();
    }
}