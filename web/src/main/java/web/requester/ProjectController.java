package web.requester;


import ProjectsService.ProjectFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.dto.ProjectsDto;

@RestController
public class ProjectController {
    private final ProjectFeedService projectFeedService;

    @Autowired
    public ProjectController(ProjectFeedService projectFeedService) {
        this.projectFeedService = projectFeedService;
    }

    @GetMapping("/api/projects")
    public ResponseEntity<ProjectsDto> getProjects(){
        return ResponseEntity.ok(new ProjectsDto(projectFeedService.getAllProjects()));
    }
}
