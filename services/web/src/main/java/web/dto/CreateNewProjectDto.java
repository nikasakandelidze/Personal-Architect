package web.dto;

public class CreateNewProjectDto {
    private final String projectType;
    private final String description;
    private final String linkToResource;
    private final String authorId;
    private final String projectCategory;

    public CreateNewProjectDto(String projectType, String description, String linkToResource, String authorId, String projectCategory) {
        this.projectType = projectType;
        this.description = description;
        this.linkToResource = linkToResource;
        this.authorId = authorId;
        this.projectCategory = projectCategory;
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

    public String getAuthorId() {
        return authorId;
    }

    public String getProjectCategory() {
        return projectCategory;
    }
}
