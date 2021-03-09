package web.utils;

import model.projects.Project;
import web.dto.ProjectDto;

public class MappingUtils {
    //private so noone can instantiate MappingUtils object
    private MappingUtils() {
    }

    public static ProjectDto projectDtoFromProject(Project project) {
        return new ProjectDto(project.getProjectId(), project.getProjectType(), project.getDescription(), project.getLinkToResource(), project.getAuthor(), project.getProjectGroup(), project.getProjectCategory());
    }
}
