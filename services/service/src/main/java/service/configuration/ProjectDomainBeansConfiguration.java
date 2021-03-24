package service.configuration;

import model.projectsFeed.ProjectsFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import storage.member.MemberAdditorStorage;
import storage.member.MemberFetcherStorage;
import storage.project.ProjectsAdditorStorage;
import storage.project.ProjectsFetcherStorage;
import useCases.projectGroups.ProjectGroupFetcherUseCase;
import useCases.projectGroups.ProjectGroupMemberAdditorUseCase;
import useCases.projectsFeed.ProjectsFeedAdditorUseCase;
import useCases.projectsFeed.ProjectsFeedFetcherUseCase;
import useCases.projectsFeed.helper.Projectsfilter.ConcreteProjectFilterer;
import useCases.projectsFeed.helper.Projectsfilter.ProjectFilterer;
import useCases.projectsMembers.ProjectMemberFetcherUseCase;

@Configuration
@Import({storage.projectsStorage.ProjectAdditorDao.class, storage.projectsStorage.ProjectsFetcherDao.class, storage.membersStorage.MemberFetcherDao.class, storage.membersStorage.MemberAdditorDao.class})
public class ProjectDomainBeansConfiguration {

    @Autowired private ProjectsAdditorStorage projectsAdditorStorage;
    @Autowired private ProjectsFetcherStorage projectsFetcherStorage;

    @Bean
    public ProjectsFeed projectsFeed(){
        return new ProjectsFeed(projectsAdditorStorage, projectsFetcherStorage);
    }

    @Bean
    public ProjectFilterer projectFilterer(){
        return new ConcreteProjectFilterer();
    }

    @Bean
    public ProjectsFeedFetcherUseCase projectsFeedFetcherUseCase(){
        return new ProjectsFeedFetcherUseCase(projectsFeed(), projectFilterer());
    }

    @Bean
    public ProjectsFeedAdditorUseCase projectsFeedAdditorUseCase(){
        return new ProjectsFeedAdditorUseCase(projectsFeed());
    }

    @Bean
    public ProjectGroupMemberAdditorUseCase memberAdditorUseCase(){
        return new ProjectGroupMemberAdditorUseCase(projectsFeed());
    }

    @Bean
    public ProjectGroupFetcherUseCase memberFetcherUseCase(){
        return new ProjectGroupFetcherUseCase(projectsFeed());
    }
}
