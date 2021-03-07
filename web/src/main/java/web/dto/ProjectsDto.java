package web.dto;

import model.projects.Project;

import java.util.List;

public class ProjectsDto {
    private List<Project> projects;

    public ProjectsDto(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
