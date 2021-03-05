package businessLogic;

import model.projects.Project;
import model.projects.ProjectsFeed;

import java.util.List;
import java.util.Optional;

public class ProjectsFeedBusinessLogic {
    private ProjectsFeed projectsFeed;

    public ProjectsFeedBusinessLogic(ProjectsFeed projectsFeed) {
        this.projectsFeed = projectsFeed;
    }

    public void addNewProject(Project project) {
        projectsFeed.addNewProject(project);
    }

    public Optional<Project> getProjectWithId(String projectId) {
        return projectsFeed.getProjectWithIdOf(projectId);
    }

    public List<Project> getAllProjects() {
        return projectsFeed.getAllProjects();
    }
}
