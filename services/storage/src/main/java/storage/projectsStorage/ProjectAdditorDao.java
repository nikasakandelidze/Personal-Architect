package storage.projectsStorage;

import model.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;
import storage.entity.ProjectEntity;
import storage.entity.ProjectMemberEntity;
import storage.membersStorage.repositories.MembersRepository;
import storage.project.ProjectsAdditorStorage;
import storage.projectsStorage.repositories.ProjectRepository;
import storage.utils.Mappers;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectAdditorDao implements ProjectsAdditorStorage{
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private MembersRepository membersRepository;

    @Override
    @Transactional
    public void createNewProject(Project project, String authorId) {
        Optional<ProjectMemberEntity> author = membersRepository.findById(authorId);
        ProjectEntity entity = Mappers.projectEntityFromDomain(project);
        entity.setAuthor(author.get());
        projectRepository.save(entity);
    }
}
