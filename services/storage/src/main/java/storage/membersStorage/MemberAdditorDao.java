package storage.membersStorage;

import model.members.ProjectMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import storage.entity.ProjectMemberEntity;
import storage.member.MemberAdditorStorage;
import storage.membersStorage.repositories.MembersRepository;
import storage.utils.StorageMappers;

@Repository
public class MemberAdditorDao implements MemberAdditorStorage {
    @Autowired
    private MembersRepository membersRepository;

    @Override
    public void addNewMember(ProjectMember projectMember) {
        ProjectMemberEntity from = StorageMappers.from(projectMember);
        membersRepository.save(from);
    }
}
