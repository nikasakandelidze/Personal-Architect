package web.utils;

import model.projects.Project;
import web.dto.ProjectDto;

import java.util.UUID;

public class MappingUtils {
    //private so noone can instantiate MappingUtils object
    private MappingUtils() {
    }

    public static ProjectDto projectDtoFromProject(Project project) {
        return new ProjectDto(project.getProjectId(), project.getProjectType(), project.getDescription(), project.getLinkToResource(), project.getAuthor(), project.getProjectGroup(), project.getProjectCategory());
    }

    public static Project projectFromProjectDto(ProjectDto projectDto){
        final String id = projectDto.getProjectId() == null ? UUID.randomUUID().toString() : projectDto.getProjectId();
        var project = new Project(id);
        project.setProjectGroup(projectDto.getProjectGroup());
        project.setProjectType(projectDto.getProjectType());
        project.setProjectCategory(projectDto.getProjectCategory());
        project.setAuthor(projectDto.getAuthor());
        project.setDescription(projectDto.getDescription());
        return project;
    }
}
