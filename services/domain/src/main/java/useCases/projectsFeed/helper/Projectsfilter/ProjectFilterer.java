package useCases.projectsFeed.helper.Projectsfilter;

import model.project.Project;

import java.util.List;

public interface ProjectFilterer {
    List<Project> filter(List<Project> input, ProjectFiltererData filterByData);
}
