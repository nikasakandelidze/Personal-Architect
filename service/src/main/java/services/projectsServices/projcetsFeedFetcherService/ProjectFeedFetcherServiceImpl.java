package services.projectsServices.projcetsFeedFetcherService;

import services.exceptions.ProjectNotFoundException;
import services.helpers.ProjectsFilterServiceData;
import model.projects.Project;
import model.projects.ProjectsFeed;
import org.springframework.stereotype.Service;
import useCases.project.ProjectsFeedUseCase;
import useCases.project.helper.Projectsfilter.ConcreteProjectFilterer;

import java.util.List;

@Service
public class ProjectFeedFetcherServiceImpl implements ProjectFeedFetcherService {
    private ProjectsFeedUseCase projectsFeedUseCase;

    public ProjectFeedFetcherServiceImpl(){
        this.projectsFeedUseCase = new ProjectsFeedUseCase(new ProjectsFeed(), new ConcreteProjectFilterer());
    }

    @Override
    public Project getProjectWithId(String projectId) {
        return projectsFeedUseCase.getProjectWithId(projectId).orElseThrow(()->new ProjectNotFoundException(String.format("Couldn't find project with projectId: %s", projectId)));
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
