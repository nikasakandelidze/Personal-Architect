package useCases.projectsFeed.helper.Projectsfilter;

import model.projects.Project;

import java.util.List;

public interface ProjectFilterer {
    List<Project> filter(List<Project> input, ProjectFiltererData filterByData);
}
