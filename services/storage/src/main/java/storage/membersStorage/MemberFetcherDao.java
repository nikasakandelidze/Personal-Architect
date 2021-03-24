package storage.membersStorage;

import model.members.ProjectMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import storage.entity.ProjectMemberEntity;
import storage.member.MemberFetcherStorage;
import storage.membersStorage.repositories.MembersRepository;
import storage.utils.StorageMappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberFetcherDao implements MemberFetcherStorage {
    @Autowired
    private MembersRepository membersRepository;

    @Override
    public List<ProjectMember> getAllMembers() {
        List<ProjectMember> projectMembers = new ArrayList<>();
        Iterable<ProjectMemberEntity> all = membersRepository.findAll();
        all.forEach(e->{
            projectMembers.add(StorageMappers.projectMemberFromEntity(e));
        });
        return projectMembers;
    }

    @Override
    public List<ProjectMember> getAllMembersOfProjectWithId(String projectId) {
        return null;
    }



    @Override
    public Optional<ProjectMember> getProjectMemberWithIdOf(String projectMemberId) {
        return Optional.empty();
    }
}
