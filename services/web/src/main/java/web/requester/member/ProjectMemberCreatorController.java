package web.requester.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import service.memberServices.ProjectMemberCreatorService;
import web.dto.ProjectMemberDto;
import web.utils.WebMappers;

@Controller
public class ProjectMemberCreatorController {
    private final ProjectMemberCreatorService projectMemberCreatorService;

    @Autowired
    public ProjectMemberCreatorController(ProjectMemberCreatorService projectMemberCreatorService) {
        this.projectMemberCreatorService = projectMemberCreatorService;
    }

    @PostMapping("/api/members")
    public ResponseEntity<?> createNewProjectMember(@RequestBody ProjectMemberDto projectMemberDto){
        projectMemberCreatorService.createNewMember(WebMappers.projectMemberFromDto(projectMemberDto));
        return ResponseEntity.ok("OK");
    }

}
