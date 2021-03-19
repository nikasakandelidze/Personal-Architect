package service.projectsServices.projectsFeedAdditorService;

import model.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.exceptions.CouldntAddProjectException;
import useCases.projectsFeed.ProjectsFeedAdditorUseCase;

@Service
public class ProjectFeedAdditorServiceImpl implements ProjectFeedAdditorService{
    private final ProjectsFeedAdditorUseCase projectsFeedAdditorUseCase;

    @Autowired
    public ProjectFeedAdditorServiceImpl(ProjectsFeedAdditorUseCase additorUseCase) {
        this.projectsFeedAdditorUseCase = additorUseCase;
    }

    @Override
    public void addProject(Project project) {
        try{
            projectsFeedAdditorUseCase.addNewProject(project);
        }catch (Exception e){
            throw new CouldntAddProjectException(String.format("Couldn't add project with properties of: %s; Error message %s", project.toString(), e.getMessage()));
        }
    }
}
