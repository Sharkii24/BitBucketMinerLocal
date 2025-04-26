package aiss.bitbucketminer.authorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthorizationService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${bitbucketminer.token}")
    private String token;

    public <T> ResponseEntity<T> getWithToken(String uri, Class c) {
        HttpHeaders headers = new HttpHeaders();
        // headers.set("Authorization", "Bearer " + token);
        HttpEntity<T> request = new HttpEntity<>(null, headers);
        ResponseEntity<T> response = restTemplate.exchange(uri, HttpMethod.GET, request, c);
        return response;
    }
}
