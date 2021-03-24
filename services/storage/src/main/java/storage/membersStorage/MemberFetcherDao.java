package storage.membersStorage;

import model.members.ProjectMember;
import org.springframework.stereotype.Repository;
import storage.member.MemberFetcherStorage;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberFetcherDao implements MemberFetcherStorage {
    @Override
    public List<ProjectMember> getAllMembersOfProjectWithId(String projectId) {
        return null;
    }

    @Override
    public Optional<ProjectMember> getProjectMemberWithIdOf(String projectMemberId) {
        return Optional.empty();
    }
}
