package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.Project;
import aiss.bitbucketminer.model.ProjectValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${bitbucketminer.baseUri}" + "repositories/")
    private String baseUri;

    public List<ProjectValue> getPublicProjects() {
        String uri = baseUri;
        ResponseEntity<Project> response = restTemplate.exchange(uri, HttpMethod.GET, null, Project.class);
        return response.getBody().getValues();
    }

    public List<ProjectValue> getWorkspaceProjects(String owner) {
        String uri = baseUri + owner;
        ResponseEntity<Project> response = restTemplate.exchange(uri, HttpMethod.GET, null, Project.class);
        return response.getBody().getValues();
    }

    public ProjectValue getProjectByName(String owner, String repo) {
        String uri = baseUri + owner + "/" + repo;
        ResponseEntity<ProjectValue> response = restTemplate.exchange(uri, HttpMethod.GET, null, ProjectValue.class);
        return response.getBody();
    }

    public ProjectValue getProjectByUri(String uri) {
        ResponseEntity<ProjectValue> response = restTemplate.exchange(uri, HttpMethod.GET, null, ProjectValue.class);
        return response.getBody();
    }
}
