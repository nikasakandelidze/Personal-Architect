package useCases.project;

import model.projects.Project;
import model.projects.ProjectsFeed;

public class ProjectsFeedAdditorUseCase {
    private final ProjectsFeed projectsFeed;

    public ProjectsFeedAdditorUseCase(ProjectsFeed projectsFeed) {
        this.projectsFeed = projectsFeed;
    }

    public void addNewProject(Project project) {
        projectsFeed.addNewProject(project);
    }
}
