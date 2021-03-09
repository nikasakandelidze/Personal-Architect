package web.dto;

import model.projects.ProjectGroup;
import model.projects.member.ProjectMember;

public class ProjectDto {
    private final String projectId;
    private final String projectType;
    private final String description;
    private final String linkToResource;
    private final ProjectMember author;
    private final ProjectGroup projectGroup;
    private final String projectCategory;

    public ProjectDto(String projectId, String projectType, String description, String linkToResource, ProjectMember author, ProjectGroup projectGroup, String projectCategory) {
        this.projectId = projectId;
        this.projectType = projectType;
        this.description = description;
        this.linkToResource = linkToResource;
        this.author = author;
        this.projectGroup = projectGroup;
        this.projectCategory = projectCategory;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectType() {
        return projectType;
    }

    public String getDescription() {
        return description;
    }

    public String getLinkToResource() {
        return linkToResource;
    }

    public ProjectMember getAuthor() {
        return author;
    }

    public ProjectGroup getProjectGroup() {
        return projectGroup;
    }

    public String getProjectCategory() {
        return projectCategory;
    }
}
