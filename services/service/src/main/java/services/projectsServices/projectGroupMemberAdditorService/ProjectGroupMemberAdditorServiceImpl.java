package services.projectsServices.projectGroupMemberAdditorService;

import model.members.ProjectMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.exceptions.ProjectNotFoundException;
import useCases.projectGroups.ProjectGroupMemberAdditorUseCase;

@Service
public class ProjectGroupMemberAdditorServiceImpl implements ProjectGroupMemberAdditorService{
    private final ProjectGroupMemberAdditorUseCase projectGroupMemberAdditorUseCase;

    @Autowired
    public ProjectGroupMemberAdditorServiceImpl(ProjectGroupMemberAdditorUseCase projectGroupMemberAdditorUseCase) {
        this.projectGroupMemberAdditorUseCase = projectGroupMemberAdditorUseCase;
    }

    @Override
    public void addProjectMemberIntoProjectGroup(ProjectMember newMember, String projectId) {
        try{
            projectGroupMemberAdditorUseCase.addProjectMemberIntoProjectGroup(newMember, projectId);
        }catch (Exception e){
            throw new ProjectNotFoundException(e.getMessage());
        }
    }
}
