package useCases.project.helper.Projectsfilter;

import model.projects.Project;
import model.projects.ProjectGroup;
import model.projects.member.ProjectMember;

import java.util.List;
import java.util.stream.Collectors;

/*
    Only filter with one thing at a time for now
 */
public class ConcreteProjectFilterer implements ProjectFilterer{
    @Override
    public List<Project> filter(List<Project> input, ProjectFiltererData filterByData) {
        return input.stream()
                .filter(e->{
                    if(filterByData.getAuthor() != null){
                        return isMatchByuAuthor(e.getAuthor(), filterByData.getAuthor());
                    }else if(filterByData.getId() != null){
                        return isMatchById(e.getProjectId(), filterByData.getId());
                    }else if(filterByData.getProjectGroup() != null){
                        return isMatchByProjectGroup(e.getProjectGroup(), filterByData.getProjectGroup());
                    }else{
                        return true;
                    }
                }).collect(Collectors.toList());
    }

    private boolean isMatchByuAuthor(ProjectMember first, ProjectMember second){
        return first.equals(second);
    }

    private boolean isMatchById(String firstId, String secondId){
        return firstId.equals(secondId);
    }

    private boolean isMatchByProjectGroup(ProjectGroup firstGroup, ProjectGroup secondGroup){
        return firstGroup.equals(secondGroup);
    }
}
