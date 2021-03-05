package useCases.project;

import model.projects.member.ProjectMember;

import java.util.UUID;

public class ProjectMemberUseCase {
    public ProjectMember createNewProjectMemberWithGeneratedId() {
        return new ProjectMember(UUID.randomUUID().toString());
    }
}
