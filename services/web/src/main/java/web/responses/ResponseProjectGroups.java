package web.responses;

import web.dto.ProjectGroupDto;

import java.util.List;

public class ResponseProjectGroups {
    private List<ProjectGroupDto> projectGroupDtos;

    public ResponseProjectGroups(List<ProjectGroupDto> projectGroupDtos) {
        this.projectGroupDtos = projectGroupDtos;
    }

    public List<ProjectGroupDto> getProjectGroupDtos() {
        return projectGroupDtos;
    }
}
