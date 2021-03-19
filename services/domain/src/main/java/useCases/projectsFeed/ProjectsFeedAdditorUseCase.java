package useCases.projectsFeed;

import model.project.Project;
import model.projectsFeed.ProjectsFeed;

public class ProjectsFeedAdditorUseCase {
    private final ProjectsFeed projectsFeed;

    public ProjectsFeedAdditorUseCase(ProjectsFeed projectsFeed) {
        this.projectsFeed = projectsFeed;
    }

    public void addNewProject(Project project) {
        projectsFeed.addNewProject(project);
    }
}
