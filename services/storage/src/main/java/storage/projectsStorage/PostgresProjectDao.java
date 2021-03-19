package storage.projectsStorage;

import org.springframework.stereotype.Repository;
import storage.entity.ProjectEntity;
import storage.projectsStorage.repositories.ProjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostgresProjectDao implements ProjectDao{
    private final ProjectRepository projectRepository;

    public PostgresProjectDao(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void persistProject(ProjectEntity projectEntity) {
        projectRepository.save(projectEntity);
    }

    @Override
    public List<ProjectEntity> getAllProjects() {
        var list = new ArrayList<ProjectEntity>();
        projectRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<ProjectEntity> getProjectbyId(String projectId) {
        return projectRepository.findById(projectId);
    }
}
