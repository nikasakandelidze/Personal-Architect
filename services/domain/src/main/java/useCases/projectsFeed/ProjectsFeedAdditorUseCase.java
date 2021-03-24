package useCases.projectsFeed;

import model.members.ProjectMember;
import model.project.Project;
import model.projectsFeed.ProjectsFeed;
import useCases.projectsMembers.ProjectMemberFetcherUseCase;

import java.util.Optional;

public class ProjectsFeedAdditorUseCase {
    private final ProjectsFeed projectsFeed;
    private final ProjectMemberFetcherUseCase projectMemberFetcherUseCase;

    public ProjectsFeedAdditorUseCase(ProjectsFeed projectsFeed, ProjectMemberFetcherUseCase projectMemberFetcherUseCase) {
        this.projectsFeed = projectsFeed;
        this.projectMemberFetcherUseCase = projectMemberFetcherUseCase;
    }

    public void addNewProject(Project project, String authorId) {
        Optional<ProjectMember> projectMemberWithIdOf = projectMemberFetcherUseCase.getProjectMemberWithIdOf(authorId);
        ProjectMember projectMember = projectMemberWithIdOf.get();
        project.setAuthor(projectMember);
        projectsFeed.addNewProject(project, authorId);
    }
}
