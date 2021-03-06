package service.projectsServices.projcetsFeedFetcherService;

import org.springframework.beans.factory.annotation.Autowired;
import service.exceptions.CouldntGetProjectWithIdException;
import service.exceptions.ProjectNotFoundException;
import service.helpers.ProjectsFilterServiceData;
import model.project.Project;
import org.springframework.stereotype.Service;
import useCases.projectsFeed.ProjectsFeedFetcherUseCase;

import java.util.List;

@Service
public class ProjectFeedFetcherServiceImpl implements ProjectFeedFetcherService {
    private final ProjectsFeedFetcherUseCase projectsFeedFetcherUseCase;

    @Autowired
    public ProjectFeedFetcherServiceImpl(ProjectsFeedFetcherUseCase projectsFeedFetcherUseCase){
        this.projectsFeedFetcherUseCase = projectsFeedFetcherUseCase;
    }

    @Override
    public Project getProjectWithId(String projectId) {
        try{
            return projectsFeedFetcherUseCase.getProjectWithId(projectId).orElseThrow(()->new ProjectNotFoundException(String.format("Couldn't find project with projectId: %s", projectId)));
        }catch (Exception e){
            throw new CouldntGetProjectWithIdException(e.getMessage());
        }
    }

    @Override
    public List<Project> getAllProjects() {
        return projectsFeedFetcherUseCase.getAllProjects();
    }

    @Override
    public List<Project> filterProjects(ProjectsFilterServiceData projectFiltererData) {
        return projectsFeedFetcherUseCase.filterProjects(ProjectsFilterServiceData.from(projectFiltererData));
    }
}
