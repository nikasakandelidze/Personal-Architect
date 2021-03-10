package services.projectsServices.projectGroupFetcherService;

import model.projectGroup.ProjectGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.exceptions.ProjectNotFoundException;
import useCases.projectGroups.ProjectGroupFetcherUseCase;

import java.util.List;
@Service
public class ProjectGroupFetcherServiceImpl implements ProjectGroupFetcherService{
    private final ProjectGroupFetcherUseCase projectGroupFetcherUseCase;

    @Autowired
    public ProjectGroupFetcherServiceImpl(ProjectGroupFetcherUseCase projectGroupFetcherUseCase) {
        this.projectGroupFetcherUseCase = projectGroupFetcherUseCase;
    }

    @Override
    public ProjectGroup getProjectGroupWithProjectIdOf(String projectId) {
        try{
            return projectGroupFetcherUseCase.getProjectGroupOfProjectWithIdOf(projectId);
        }catch (Exception e){
            throw new ProjectNotFoundException(e.getMessage());
        }
    }

    @Override
    public List<ProjectGroup> getAllProjectGroups() {
        return projectGroupFetcherUseCase.getAllProjectGroups();
    }
}
