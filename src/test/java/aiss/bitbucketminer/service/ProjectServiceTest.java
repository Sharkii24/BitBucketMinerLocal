package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.ProjectValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceTest {

    @Autowired
    ProjectService projectService;

    @Test
    @DisplayName("List of Public Projects")
    void getPublicProjects() {
        List<ProjectValue> projects = null;
        projects = projectService.getPublicProjects();
        assertFalse(projects.isEmpty(), "The list of projects is empty!");
        System.out.println(projects);
    }

    @Test
    @DisplayName("List of Projects with owner")
    void getWorkspaceProjects() {
        String owner = "gentlero";
        List<ProjectValue> projects = null;
        projects = projectService.getWorkspaceProjects(owner);
        assertFalse(projects.isEmpty(), "The list of projects is empty!");
        System.out.println(projects);
    }

    @Test
    @DisplayName("Get a Project by owner and repo name")
    void getProjectByName() {
        String owner = "gentlero";
        String repo = "bitbucket-api";
        ProjectValue project = null;
        project = projectService.getProjectByName(owner, repo);
        assertFalse(project == null, "The project is null!");
        System.out.println(project);
    }
}