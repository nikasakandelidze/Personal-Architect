package storage.projectsStorage;

import model.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import storage.project.ProjectsFetcherStorage;
import storage.entity.ProjectEntity;
import storage.projectsStorage.repositories.ProjectRepository;
import storage.utils.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectsFetcherDao implements ProjectsFetcherStorage {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Optional<Project> getProjectWithIdOf(String projectId) {
        Optional<ProjectEntity> byId = projectRepository.findById(projectId);
        Project project= Mappers.domainProjectFromEntity(byId.get());
        return Optional.of(project);
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> result = new ArrayList<Project>();
        Iterable<ProjectEntity> all = projectRepository.findAll();
        all.forEach(projectEntity -> {
            result.add(Mappers.domainProjectFromEntity(projectEntity));
        });
        return result;
    }
}
