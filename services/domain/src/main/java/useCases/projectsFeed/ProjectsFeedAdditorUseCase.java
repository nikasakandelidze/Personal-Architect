package useCases.projectsFeed;

import model.members.ProjectMember;
import model.project.Project;
import model.projectsFeed.ProjectsFeed;
import useCases.projectsMembers.ProjectMemberFetcherUseCase;

import java.util.Optional;

public class ProjectsFeedAdditorUseCase {
    private final ProjectsFeed projectsFeed;

    public ProjectsFeedAdditorUseCase(ProjectsFeed projectsFeed) {
        this.projectsFeed = projectsFeed;
    }

    public void addNewProject(Project project, String authorId) {
        projectsFeed.addNewProject(project, authorId);
    }
}
