package web.dto;

import model.project.Project;
import web.utils.MappingUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectsDto {
    private List<ProjectDto> projects;

    public ProjectsDto(List<Project> projects) {
        this.projects = projects.stream().map(MappingUtils::projectDtoFromProject).collect(Collectors.toList());
    }

    public List<ProjectDto> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDto> projects) {
        this.projects = projects;
    }
}
