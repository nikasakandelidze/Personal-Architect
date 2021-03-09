package web.requester;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import web.dto.ProjectDto;

@RestController
public class ProjectsAdditorController {

    @PostMapping("/api/projects")
    public void addNewProject(@RequestBody ProjectDto projectDto){
        
    }
}
