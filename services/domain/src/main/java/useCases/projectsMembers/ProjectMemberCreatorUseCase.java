package useCases.projectsMembers;

import model.members.ProjectMember;
import storage.member.MemberAdditorStorage;

public class ProjectMemberCreatorUseCase {
    private MemberAdditorStorage memberAdditorStorage;

    public ProjectMemberCreatorUseCase(MemberAdditorStorage memberAdditorStorage){
        this.memberAdditorStorage = memberAdditorStorage;
    }

    public void createNewMember(ProjectMember projectMember){
        memberAdditorStorage.addNewMember(projectMember);
    }
}
