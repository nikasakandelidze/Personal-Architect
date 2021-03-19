package web.requester;


import service.projectsServices.projcetsFeedFetcherService.ProjectFeedFetcherService;
import model.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import web.dto.ProjectDto;
import web.dto.ProjectsDto;
import web.utils.MappingUtils;

@RestController
public class ProjectsFetcherController {
    private final ProjectFeedFetcherService projectFeedService;

    @Autowired
    public ProjectsFetcherController(ProjectFeedFetcherService projectFeedService) {
        this.projectFeedService = projectFeedService;
    }

    @GetMapping("/api/projects")
    public ResponseEntity<ProjectsDto> getProjects(){
        return ResponseEntity.ok(new ProjectsDto(projectFeedService.getAllProjects()));
    }

    @GetMapping("/api/projects/{projectId}")
    public ResponseEntity<ProjectDto> getProjectWithId(@PathVariable("projectId")String projectId){
        final Project projectWithId = projectFeedService.getProjectWithId(projectId);
        return ResponseEntity.ok(MappingUtils.projectDtoFromProject(projectWithId));
    }
}
