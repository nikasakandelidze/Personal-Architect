package model.projects;

import model.projects.member.ProjectMember;

public class Project {
    private final String projectId;
    private String projectType;
    private String description;
    private String linkToResource;
    private ProjectMember author;
    private ProjectGroup projectGroup;
    private String projectCategory;

    public Project(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkToResource() {
        return linkToResource;
    }

    public void setLinkToResource(String linkToResource) {
        this.linkToResource = linkToResource;
    }

    public ProjectMember getAuthor() {
        return author;
    }

    public void setAuthor(ProjectMember author) {
        this.author = author;
    }

    public ProjectGroup getProjectGroup() {
        return projectGroup;
    }

    public void setProjectGroup(ProjectGroup projectGroup) {
        this.projectGroup = projectGroup;
    }

    public String getProjectCategory() {
        return projectCategory;
    }

    public void setProjectCategory(String projectCategory) {
        this.projectCategory = projectCategory;
    }
}
