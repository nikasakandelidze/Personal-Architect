package useCases.projectGroups;

import exceptions.ProjectNotFoundException;
import model.members.ProjectMember;
import model.projects.Project;
import model.projects.ProjectsFeed;

import java.util.UUID;

public class ProjectGroupMemberAdditorUseCase {
    private final ProjectsFeed projectsFeed;

    public ProjectGroupMemberAdditorUseCase(ProjectsFeed projectsFeed) {
        this.projectsFeed = projectsFeed;
    }

    public void addProjectMemberIntoProjectGroup(ProjectMember newMember, String projectId) {
        final Project project = projectsFeed.getProjects().stream()
                .filter(e -> e.getProjectId().equals(projectId))
                .findFirst()
                .orElseThrow(() -> new ProjectNotFoundException(String.format("Project with id: %s not found.", projectId)));
        project.getProjectGroup().addNewMember(newMember);
    }
}
