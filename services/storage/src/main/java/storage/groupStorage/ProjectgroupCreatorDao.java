package storage.groupStorage;

import model.projectGroup.ProjectGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import storage.entity.ProjectEntity;
import storage.entity.ProjectgroupEntity;
import storage.group.ProjectGroupCreatorStorage;
import storage.groupStorage.repository.ProjectGroupRepository;
import storage.projectsStorage.repositories.ProjectRepository;
import storage.utils.Mappers;

import java.util.Optional;

@Repository
public class ProjectgroupCreatorDao implements ProjectGroupCreatorStorage{
    @Autowired
    private ProjectGroupRepository projectGroupRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void createNewProjectGroup(ProjectGroup projectGroup) {
        Optional<ProjectEntity> byId = projectRepository.findById(projectGroup.getProjectId());
        ProjectgroupEntity entity = Mappers.projectGroupEntityFromDomain(projectGroup);
        entity.setProjectEntity(byId.get());
        projectGroupRepository.save(entity);
    }
}
