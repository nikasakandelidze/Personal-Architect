package service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import storage.group.ProjectGroupCreatorStorage;
import useCases.projectGroups.ProjectGroupCreatorUseCase;

@Configuration
@Import({storage.groupStorage.ProjectgroupCreatorDao.class})
public class ProjectGroupDomainBeansConfiguration {
    @Autowired private ProjectGroupCreatorStorage projectGroupCreatorStorage;

    @Bean
    public ProjectGroupCreatorUseCase projectGroupCreatorUseCase(){
        return new ProjectGroupCreatorUseCase(projectGroupCreatorStorage);
    }

}
