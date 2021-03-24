package web.dto;

import model.projectGroup.ProjectGroup;
import model.members.ProjectMember;

public class ProjectDto {
    private String projectId;
    private String projectType;
    private String description;
    private String linkToResource;
    private ProjectMember author;
    private ProjectGroup projectGroup;
    private String projectCategory;

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

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLinkToResource(String linkToResource) {
        this.linkToResource = linkToResource;
    }

    public void setAuthor(ProjectMember author) {
        this.author = author;
    }

    public void setProjectGroup(ProjectGroup projectGroup) {
        this.projectGroup = projectGroup;
    }

    public void setProjectCategory(String projectCategory) {
        this.projectCategory = projectCategory;
    }
}
