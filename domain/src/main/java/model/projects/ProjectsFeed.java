package model.projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectsFeed {
    private List<Project> projects;

    public ProjectsFeed(List<Project> projects) {
        this.projects = projects;
    }

    public ProjectsFeed() {
        projects = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void addNewProject(Project project) {
        this.projects.add(project);
    }

    public Optional<Project> getProjectWithIdOf(String projectId) {
        return projects.stream().filter(e -> e.getProjectId().equals(projectId)).findFirst();
    }

    public List<Project> getAllProjects() {
        return this.projects;
    }
}
