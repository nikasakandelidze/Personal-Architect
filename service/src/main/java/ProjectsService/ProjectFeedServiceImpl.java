package ProjectsService;

import ProjectsService.helpers.ProjectsFilterServiceData;
import model.projects.Project;
import model.projects.ProjectsFeed;
import org.springframework.stereotype.Service;
import useCases.project.ProjectsFeedUseCase;
import useCases.project.helper.Projectsfilter.ConcreteProjectFilterer;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectFeedServiceImpl implements ProjectFeedService{
    private ProjectsFeedUseCase projectsFeedUseCase;

    public ProjectFeedServiceImpl(){
        this.projectsFeedUseCase = new ProjectsFeedUseCase(new ProjectsFeed(), new ConcreteProjectFilterer());
    }

    @Override
    public Optional<Project> getProjectWithId(String projectId) {
        return projectsFeedUseCase.getProjectWithId(projectId);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectsFeedUseCase.getAllProjects();
    }

    @Override
    public List<Project> filterProjects(ProjectsFilterServiceData projectFiltererData) {
        return projectsFeedUseCase.filterProjects(ProjectsFilterServiceData.from(projectFiltererData));
    }
}
