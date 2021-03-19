package useCases.projectGroups;

import exceptions.ProjectNotFoundException;
import model.members.ProjectMember;
import model.project.Project;
import model.projectsFeed.ProjectsFeed;

public class ProjectGroupMemberAdditorUseCase {
    private final ProjectsFeed projectsFeed;

    public ProjectGroupMemberAdditorUseCase(ProjectsFeed projectsFeed) {
        this.projectsFeed = projectsFeed;
    }

    public void addProjectMemberIntoProjectGroup(ProjectMember newMember, String projectId) {
        final Project project = projectsFeed.getAllProjects().stream()
                .filter(e -> e.getProjectId().equals(projectId))
                .findFirst()
                .orElseThrow(() -> new ProjectNotFoundException(String.format("Project with id: %s not found.", projectId)));
        project.getProjectGroup().addNewMember(newMember);
    }
}
