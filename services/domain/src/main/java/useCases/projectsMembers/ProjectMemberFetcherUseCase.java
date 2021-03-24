package useCases.projectsMembers;

import model.members.ProjectMember;
import storage.member.MemberFetcherStorage;

import java.util.List;
import java.util.Optional;

public class ProjectMemberFetcherUseCase {
    private MemberFetcherStorage memberFetcherStorage;

    public ProjectMemberFetcherUseCase(MemberFetcherStorage memberFetcherStorage){
        this.memberFetcherStorage = memberFetcherStorage;
    }

    public List<ProjectMember> getAllProjectMembers(){
        return memberFetcherStorage.getAllMembers();
    }

    public Optional<ProjectMember> getProjectMemberWithIdOf(String id){
        return memberFetcherStorage.getProjectMemberWithIdOf(id);
    }
}
