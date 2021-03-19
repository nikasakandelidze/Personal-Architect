package useCases.projectsFeed;

import model.project.Project;
import model.projectsFeed.ProjectsFeed;
import useCases.projectsFeed.helper.Projectsfilter.ProjectFilterer;
import useCases.projectsFeed.helper.Projectsfilter.ProjectFiltererData;

import java.util.List;
import java.util.Optional;

public class ProjectsFeedFetcherUseCase {
    private final ProjectsFeed projectsFeed;
    private final ProjectFilterer projectFilterer;

    public ProjectsFeedFetcherUseCase(ProjectsFeed projectsFeed, ProjectFilterer filterer) {
        this.projectFilterer = filterer;
        this.projectsFeed = projectsFeed;
    }

    public Optional<Project> getProjectWithId(String projectId) {
        return projectsFeed.getProjectWithIdOf(projectId);
    }

    public List<Project> getAllProjects() {
        return projectsFeed.getAllProjects();
    }

    public List<Project> filterProjects(ProjectFiltererData projectFiltererData){
            return projectFilterer.filter(projectsFeed.getAllProjects(), projectFiltererData);
    }
}
