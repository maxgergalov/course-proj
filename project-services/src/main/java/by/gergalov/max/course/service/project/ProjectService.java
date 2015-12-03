package by.gergalov.max.course.service.project;

import by.gergalov.max.course.entity.Project;
import by.gergalov.max.course.service.common.BaseService;

import java.util.List;


public interface ProjectService extends BaseService<Project>{

    Project registerProject(Project project);

    void deleteProject(long projectId);

    List<Project> getProjects(List<Project> projectIds);

}
