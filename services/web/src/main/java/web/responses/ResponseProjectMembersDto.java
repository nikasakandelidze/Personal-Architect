package web.responses;

import web.dto.ProjectMemberDto;

import java.util.List;

public class ResponseProjectMembersDto {
    private List<ProjectMemberDto> members;

    public ResponseProjectMembersDto(List<ProjectMemberDto> members) {
        this.members = members;
    }

    public List<ProjectMemberDto> getMembers() {
        return members;
    }

    public void setMembers(List<ProjectMemberDto> members) {
        this.members = members;
    }
}
