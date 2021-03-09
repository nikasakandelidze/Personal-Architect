package services.configuration;

import model.projects.ProjectsFeed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import useCases.project.ProjectsFeedAdditorUseCase;
import useCases.project.ProjectsFeedFetcherUseCase;
import useCases.project.helper.Projectsfilter.ConcreteProjectFilterer;
import useCases.project.helper.Projectsfilter.ProjectFilterer;

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
    public ProjectsFeedFetcherUseCase fetcherUseCase(){
        return new ProjectsFeedFetcherUseCase(projectsFeed(), projectFilterer());
    }

    @Bean
    public ProjectsFeedAdditorUseCase additorUseCase(){
        return new ProjectsFeedAdditorUseCase(projectsFeed());
    }
}
