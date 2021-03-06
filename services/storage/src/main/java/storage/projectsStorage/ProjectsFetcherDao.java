package storage.projectsStorage;

import model.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import storage.project.ProjectsFetcherStorage;
import storage.entity.ProjectEntity;
import storage.projectsStorage.repositories.ProjectRepository;
import storage.utils.StorageMappers;

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
        Project project= StorageMappers.domainProjectFromEntity(byId.get());
        return Optional.of(project);
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> result = new ArrayList<Project>();
        Iterable<ProjectEntity> all = projectRepository.findAll();
        System.out.println("iteration");
        all.forEach(projectEntity -> {
            result.add(StorageMappers.domainProjectFromEntity(projectEntity));
        });
        return result;
    }
}
