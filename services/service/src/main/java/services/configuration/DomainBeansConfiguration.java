package services.configuration;

import model.projects.ProjectsFeed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import useCases.projectGroups.ProjectGroupFetcherUseCase;
import useCases.projectGroups.ProjectGroupMemberAdditorUseCase;
import useCases.projectsFeed.ProjectsFeedAdditorUseCase;
import useCases.projectsFeed.ProjectsFeedFetcherUseCase;
import useCases.projectsFeed.helper.Projectsfilter.ConcreteProjectFilterer;
import useCases.projectsFeed.helper.Projectsfilter.ProjectFilterer;

@Configuration
public class DomainBeansConfiguration {

    @Bean
    public ProjectsFeed projectsFeed(){
        return new ProjectsFeed();
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
