package web.requester;

import model.projectGroup.ProjectGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import services.projectsServices.projectGroupFetcherService.ProjectGroupFetcherService;
import web.dto.ProjectGroupDto;
import web.responses.ResponseProjectGroups;
import web.utils.MappingUtils;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProjectGroupFetcherController {
    private final ProjectGroupFetcherService projectGroupFetcherService;

    @Autowired
    public ProjectGroupFetcherController(ProjectGroupFetcherService projectGroupFetcherService) {
        this.projectGroupFetcherService = projectGroupFetcherService;
    }

    @GetMapping("/api/projects/groups")
    public ResponseEntity<ResponseProjectGroups> getAllProjectGroups(){
        final List<ProjectGroupDto> collect = projectGroupFetcherService.getAllProjectGroups().stream()
                .map(MappingUtils::projectGroupToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ResponseProjectGroups(collect));
    }

    @GetMapping("/api/projects/groups/{projectId}")
    public ResponseEntity<ProjectGroupDto> getProjectGroupWithIdOf(@PathVariable String projectId){
        final ProjectGroup projectGroupWithProjectIdOf = projectGroupFetcherService.getProjectGroupWithProjectIdOf(projectId);
        return ResponseEntity.ok(MappingUtils.projectGroupToDto(projectGroupWithProjectIdOf));
    }
}
