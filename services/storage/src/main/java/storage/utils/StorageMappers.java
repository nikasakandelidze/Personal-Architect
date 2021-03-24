package storage.utils;

import model.members.ProjectMember;
import model.project.Project;
import model.projectGroup.ProjectGroup;
import storage.entity.ProjectEntity;
import storage.entity.ProjectMemberEntity;
import storage.entity.ProjectgroupEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StorageMappers {
    private StorageMappers() {
    } //so that no-one can instantiate Utils class.

    public static ProjectMemberEntity projectMemberEntityFromDomain(ProjectMember projectMember){
        ProjectMemberEntity projectMemberEntity = new ProjectMemberEntity(projectMember.getMemberId());
        projectMemberEntity.setEmail(projectMember.getEmail());
        projectMemberEntity.setFirstName(projectMember.getFirstName());
        projectMemberEntity.setLastName(projectMember.getLastName());
        projectMemberEntity.setProjectsInterestedIn(projectMember.getProjectsInterestedIn().stream().map(StorageMappers::projectEntityFromDomain).collect(Collectors.toList()));
        return projectMemberEntity;
    }

    public static ProjectgroupEntity projectGroupEntityFromDomain(ProjectGroup projectGroup) {
        List<ProjectMember> members = projectGroup.getMembers()==null ? new ArrayList<>() : projectGroup.getMembers();
        List<ProjectMemberEntity> collect = members.stream().map(StorageMappers::projectMemberEntityFromDomain).collect(Collectors.toList());
        return new ProjectgroupEntity(collect, projectGroup.getGroupName(), projectGroup.getProjectId());
    }

    public static ProjectEntity projectEntityFromDomain(Project project) {
        ProjectEntity projectEntity = new ProjectEntity(project.getProjectId());
        if(project.getProjectGroup()!=null)projectEntity.setProjectGroup(projectGroupEntityFromDomain(project.getProjectGroup()));
        projectEntity.setProjectType(project.getProjectType());
        projectEntity.setProjectCategory(project.getProjectCategory());
        if(project.getAuthor() != null)projectEntity.setAuthor(projectMemberEntityFromDomain(project.getAuthor()));
        projectEntity.setDescription(project.getDescription());
        projectEntity.setLinkToResource(project.getLinkToResource());
        return projectEntity;
    }

    public static ProjectMember projectMemberFromEntity(ProjectMemberEntity projectMemberEntity){
        ProjectMember projectMember = new ProjectMember();
        projectMember.setEmail(projectMemberEntity.getEmail());
        projectMember.setFirstName(projectMemberEntity.getFirstName());
        projectMember.setLastName(projectMemberEntity.getLastName());
        if(projectMemberEntity.getProjectsInterestedIn()!=null) projectMember.setProjectsInterestedIn(projectMemberEntity.getProjectsInterestedIn().stream().map(StorageMappers::domainProjectFromEntity).collect(Collectors.toList()));
        return projectMember;
    }

    public static ProjectGroup projectGroupFromEntity(ProjectgroupEntity projectgroupEntity){
        return new ProjectGroup(projectgroupEntity.getMembers().stream().map(StorageMappers::projectMemberFromEntity).collect(Collectors.toList()), projectgroupEntity.getGroupName(), projectgroupEntity.getProjectGroupId());
    }

    public static Project domainProjectFromEntity(ProjectEntity projectEntity){
        Project project = new Project(projectEntity.getProjectId());
        project.setProjectGroup(projectGroupFromEntity(projectEntity.getProjectGroup()));
        project.setProjectType(projectEntity.getProjectType());
        project.setProjectCategory(projectEntity.getProjectCategory());
        project.setDescription(projectEntity.getDescription());
        project.setLinkToResource(projectEntity.getLinkToResource());
        project.setAuthor(StorageMappers.projectMemberFromEntity(projectEntity.getAuthor()));
        return project;
    }

    public static ProjectMemberEntity from(ProjectMember projectMember){
        ProjectMemberEntity projectMemberEntity = new ProjectMemberEntity();
        projectMemberEntity.setFirstName(projectMember.getFirstName());
        projectMemberEntity.setLastName(projectMember.getLastName());
        projectMemberEntity.setEmail(projectMember.getEmail());
        return projectMemberEntity;
    }
}