package web.requester.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.projectsServices.projectGroupMemberAdditorService.ProjectGroupMemberAdditorService;
import web.dto.ProjectMemberDto;
import web.utils.MappingUtils;

@RestController
public class ProjectGroupMemberAdditorController {
    private final ProjectGroupMemberAdditorService projectGroupMemberAdditorService;

    @Autowired
    public ProjectGroupMemberAdditorController(ProjectGroupMemberAdditorService projectGroupMemberAdditorService) {
        this.projectGroupMemberAdditorService = projectGroupMemberAdditorService;
    }

    //todo signature of the method doesn't show true meaning of the func
    @PostMapping("api/projects/{projectId}/group/members")
    public ResponseEntity<?> addNewMemberToProjectWithId(@PathVariable String projectId, @RequestBody ProjectMemberDto projectMemberDto){
        projectGroupMemberAdditorService.addProjectMemberIntoProjectGroup(MappingUtils.projectMemberFromDto(projectMemberDto), projectId);
        return ResponseEntity.ok("Added");
    }

}
