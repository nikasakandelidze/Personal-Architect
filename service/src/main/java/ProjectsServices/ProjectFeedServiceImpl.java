package ProjectsService;

import ProjectsService.helpers.ProjectsFilterServiceData;
import model.projects.Project;
import useCases.project.ProjectsFeedUseCase;

import java.util.List;
import java.util.Optional;

public class ProjectFeedServiceImpl implements ProjectFeedService{
    private ProjectsFeedUseCase projectsFeedUseCase;

    public ProjectFeedServiceImpl(ProjectsFeedUseCase projectsFeedUseCase) {
        this.projectsFeedUseCase = projectsFeedUseCase;
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
