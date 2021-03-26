package web.requester.member;

import model.members.ProjectMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import service.memberServices.ProjectMemberFetcherService;
import web.responses.ResponseProjectMembersDto;
import web.utils.WebMappers;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProjectMemberFetcherController {
    private final ProjectMemberFetcherService projectMemberFetcherService;

    @Autowired
    public ProjectMemberFetcherController(ProjectMemberFetcherService projectMemberFetcherService) {
        this.projectMemberFetcherService = projectMemberFetcherService;
    }

    @GetMapping("/api/members/{projectId}")
    public ResponseEntity<ResponseProjectMembersDto> getMembersOfProjectWithIdOf(@PathVariable("projectId") String projectId){
        List<ProjectMember> projectMembersOfProjectWithIdOf = projectMemberFetcherService.getProjectMembersOfProjectWithIdOf(projectId);
        ResponseProjectMembersDto body = new ResponseProjectMembersDto(projectMembersOfProjectWithIdOf.stream().map(WebMappers::projectMemberDtoFromProjectMember).collect(Collectors.toList()));
        return ResponseEntity.ok(body);
    }
}
