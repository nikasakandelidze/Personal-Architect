package storage.projectsStorage;

import model.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import storage.ProjectsAdditorStorage;
import storage.projectsStorage.repositories.ProjectRepository;
import storage.utils.Mappers;

@Repository
public class ProjectAdditorDao implements ProjectsAdditorStorage {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void addProject(Project project) {
        projectRepository.save(Mappers.projectEntityFromDomain(project));
    }
}
