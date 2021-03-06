package storage.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class ProjectEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String projectId;
    private String projectType;
    private String description;
    private String linkToResource;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "memberId")
    private ProjectMemberEntity author;
    @OneToOne(mappedBy = "projectEntity", cascade = {CascadeType.ALL})
    private ProjectgroupEntity projectGroup;
    private String projectCategory;

    public ProjectEntity(){}

    public ProjectEntity(String projectId) {
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

    public ProjectMemberEntity getAuthor() {
        return author;
    }

    public void setAuthor(ProjectMemberEntity author) {
        this.author = author;
    }

    public ProjectgroupEntity getProjectGroup() {
        return projectGroup;
    }

    public void setProjectGroup(ProjectgroupEntity projectGroup) {
        this.projectGroup = projectGroup;
    }

    public String getProjectCategory() {
        return projectCategory;
    }

    public void setProjectCategory(String projectCategory) {
        this.projectCategory = projectCategory;
    }
}
