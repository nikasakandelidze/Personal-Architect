package web.requester.projectMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import service.memberServices.ProjectMemberCreatorService;
import web.dto.ProjectMemberDto;
import web.utils.MappingUtils;

@Controller
public class ProjectMemberCreatorController {
    private final ProjectMemberCreatorService projectMemberCreatorService;

    @Autowired
    public ProjectMemberCreatorController(ProjectMemberCreatorService projectMemberCreatorService) {
        this.projectMemberCreatorService = projectMemberCreatorService;
    }

    @PostMapping("/api/projectMembers")
    public ResponseEntity<?> createNewProjectMember(@RequestBody ProjectMemberDto projectMemberDto){
        projectMemberCreatorService.createNewMember(MappingUtils.projectMemberFromDto(projectMemberDto));
        return ResponseEntity.ok("OK");
    }

}
