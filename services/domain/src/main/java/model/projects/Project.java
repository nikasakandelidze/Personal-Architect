package model.projects;

import model.members.ProjectMember;
import model.projectGroup.ProjectGroup;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectType, project.projectType) && Objects.equals(description, project.description) && Objects.equals(linkToResource, project.linkToResource) && Objects.equals(author, project.author) && Objects.equals(projectGroup, project.projectGroup) && Objects.equals(projectCategory, project.projectCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectType, description, linkToResource, author, projectGroup, projectCategory);
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", projectType='" + projectType + '\'' +
                ", description='" + description + '\'' +
                ", linkToResource='" + linkToResource + '\'' +
                ", author=" + author +
                ", projectGroup=" + projectGroup +
                ", projectCategory='" + projectCategory + '\'' +
                '}';
    }
}
