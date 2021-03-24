package web.requester.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import service.groupServices.ProjectGroupCreatorService;
import web.dto.ProjectGroupDto;
import web.utils.WebMappers;

@Controller
public class ProjectGroupCreatorController {
    private final ProjectGroupCreatorService projectGroupCreatorService;

    @Autowired
    public ProjectGroupCreatorController(ProjectGroupCreatorService projectGroupCreatorService) {
        this.projectGroupCreatorService = projectGroupCreatorService;
    }

    @PostMapping("api/groups")
    public ResponseEntity<?> createNewGroup(@RequestBody ProjectGroupDto projectGroupDto){
        projectGroupCreatorService.createNewProjectGroup(WebMappers.getProjectGroupFromDto(projectGroupDto));
        return ResponseEntity.ok("OK");
    }
}
