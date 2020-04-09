package kg.nurtelecom.cashbackclient.service;

import kg.nurtelecom.cashbackclient.model.AuthModel;
import kg.nurtelecom.cashbackclient.model.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    @Autowired
    private RequestTemplate requestTemplate;

    private final RestTemplate restTemplate;

    AuthService (RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public boolean login (AuthModel model){
        String url = "http://localhost:4445/api/authenticate";
        try {
            ResponseEntity<JwtResponse> result = restTemplate.postForEntity(url, model, JwtResponse.class);
            if (result.getStatusCode() == HttpStatus.ACCEPTED) {
                System.out.println(result.getBody());
                requestTemplate.getHeaders().set("Authorization", result.getBody().getToken());
                requestTemplate.setClientId(result.getBody().getClientId());
                requestTemplate.setDeviceId(result.getBody().getDeviceId());
                System.out.println(requestTemplate.getHeaders());
                return true;
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public void logout (){
        try {
                requestTemplate.getHeaders().remove("Authorization");
                requestTemplate.setClientId(null);
                requestTemplate.setDeviceId(null);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
