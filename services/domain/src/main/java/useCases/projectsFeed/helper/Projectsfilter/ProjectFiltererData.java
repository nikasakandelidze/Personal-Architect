package useCases.projectsFeed.helper.Projectsfilter;

import model.projectGroup.ProjectGroup;
import model.members.ProjectMember;

public class ProjectFiltererData {
    private final String name;
    private final String id;
    private final ProjectMember author;
    private final ProjectGroup projectGroup;
    private final String projectCategory;

    public ProjectFiltererData(String name, String id, ProjectMember author, ProjectGroup projectGroup, String projectCategory) {
        this.name = name;
        this.id = id;
        this.author = author;
        this.projectGroup = projectGroup;
        this.projectCategory = projectCategory;
    }

    public static ProjectFiltererData nameLike(String name){
        return new ProjectFiltererData(name, null, null,null,null);
    }

    public static ProjectFiltererData withId(String id){
        return new ProjectFiltererData(null, id, null, null, null);
    }

    public static ProjectFiltererData withAuthor(ProjectMember projectMember){
        return new ProjectFiltererData(null, null, projectMember,null,null);
    }

    public static ProjectFiltererData withAuthor(ProjectGroup projectGroup){
        return new ProjectFiltererData(null, null, null,projectGroup,null);
    }

    public static ProjectFiltererData withAuthor(String projectCategory){
        return new ProjectFiltererData(null, null, null, null,projectCategory);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
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
