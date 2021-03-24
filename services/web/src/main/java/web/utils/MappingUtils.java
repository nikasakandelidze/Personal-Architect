package web.utils;

import model.members.ProjectMember;
import model.projectGroup.ProjectGroup;
import model.project.Project;
import web.dto.ProjectDto;
import web.dto.ProjectGroupDto;
import web.dto.ProjectMemberDto;

import java.util.UUID;
import java.util.stream.Collectors;

public class MappingUtils {
    //private so noone can instantiate MappingUtils object
    private MappingUtils() {
    }

    public static ProjectDto projectDtoFromProject(Project project) {
        return new ProjectDto(project.getProjectId(), project.getProjectType(), project.getDescription(), project.getLinkToResource(), project.getAuthor(), project.getProjectGroup(), project.getProjectCategory());
    }

    public static Project projectFromProjectDto(ProjectDto projectDto){
        final String id = projectDto.getProjectId() == null ? UUID.randomUUID().toString() : projectDto.getProjectId();
        Project project = new Project(id);
        project.setProjectGroup(projectDto.getProjectGroup());
        project.setProjectType(projectDto.getProjectType());
        project.setProjectCategory(projectDto.getProjectCategory());
        project.setAuthor(projectDto.getAuthor());
        project.setDescription(projectDto.getDescription());
        return project;
    }

    public static ProjectMemberDto projectMemberDtoFromProjectMember(ProjectMember projectMember){
        ProjectMemberDto projectMemberDto = new ProjectMemberDto(projectMember.getMemberId());
        projectMemberDto.setEmail(projectMember.getEmail());
        projectMemberDto.setFirstName(projectMember.getFirstName());
        projectMemberDto.setLastName(projectMember.getLastName());
        projectMemberDto.setProjectsInterestedIn(projectMember.getProjectsInterestedIn().stream().map(MappingUtils::projectDtoFromProject).collect(Collectors.toList()));
        return projectMemberDto;
    }

    public static ProjectMember projectMemberFromDto(ProjectMemberDto projectMemberDto){
        ProjectMember projectMember = new ProjectMember();
        projectMember.setEmail(projectMemberDto.getEmail());
        projectMember.setFirstName(projectMemberDto.getFirstName());
        projectMember.setLastName(projectMemberDto.getLastName());
        if(projectMemberDto.getProjectsInterestedIn()!=null)projectMember.setProjectsInterestedIn(projectMemberDto.getProjectsInterestedIn().stream().map(MappingUtils::projectFromProjectDto).collect(Collectors.toList()));
        return projectMember;
    }

    public static ProjectGroupDto projectGroupToDto(ProjectGroup projectGroup){
        return new ProjectGroupDto(projectGroup.getMembers().stream().map(MappingUtils::projectMemberDtoFromProjectMember).collect(Collectors.toList()), projectGroup.getGroupName(), projectGroup.getProjectId());
    }
}
