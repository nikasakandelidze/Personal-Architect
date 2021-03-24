package service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import storage.member.MemberAdditorStorage;
import storage.member.MemberFetcherStorage;
import useCases.projectsMembers.ProjectMemberCreatorUseCase;

@Configuration
@Import({storage.membersStorage.MemberAdditorDao.class, storage.membersStorage.MemberFetcherDao.class})
public class MemberDomainBeansConfiguration {
    @Autowired private MemberFetcherStorage memberFetcherDao;
    @Autowired private MemberAdditorStorage memberAdditorDao;

    @Bean
    public ProjectMemberCreatorUseCase projectMemberCreatorUseCase(){
        return new ProjectMemberCreatorUseCase(memberAdditorDao);
    }
}
