package storage.member;

import model.members.ProjectMember;

import java.util.List;
import java.util.Optional;

public interface MemberFetcherStorage {
    List<ProjectMember> getAllMembers();
    List<ProjectMember> getAllMembersOfProjectWithId(String projectId);
    Optional<ProjectMember> getProjectMemberWithIdOf(String projectMemberId);
}
