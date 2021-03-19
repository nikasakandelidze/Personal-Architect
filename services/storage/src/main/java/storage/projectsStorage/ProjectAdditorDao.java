package storage.projectsStorage;

import model.project.Project;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;
import storage.ProjectsAdditorStorage;
import storage.projectsStorage.repositories.ProjectRepository;
import storage.utils.Mappers;

@Repository
@Import({storage.projectsStorage.repositories.ProjectRepository.class})
public class ProjectAdditorDao implements ProjectsAdditorStorage {
    private final ProjectRepository projectRepository;

    public ProjectAdditorDao(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void addProject(Project project) {
        projectRepository.save(Mappers.projectEntityFromDomain(project));
    }
}
