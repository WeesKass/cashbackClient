package kg.nurtelecom.cashbackclient.service;

import kg.nurtelecom.cashbackclient.model.AuthModel;
import kg.nurtelecom.cashbackclient.model.JwtResponse;
import kg.nurtelecom.cashbackclient.utils.ContextHolder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    private ContextHolder contextHolder;

    private final RestTemplate restTemplate;

    AuthService (RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
        contextHolder = ContextHolder.getInstance();
    }

    public boolean login (AuthModel model){
        String url = "http://157.245.219.46:4445/api/authenticate";
        try {
            ResponseEntity<JwtResponse> result = restTemplate.postForEntity(url, model, JwtResponse.class);
            if (result.getStatusCode() == HttpStatus.ACCEPTED) {
                System.out.println(result.getBody());
                contextHolder.getHeaders().set("Authorization", result.getBody().getToken());
                contextHolder.setClientId(result.getBody().getClientId());
                contextHolder.setDeviceId(result.getBody().getDeviceId());
                System.out.println(contextHolder.getHeaders());
                return true;
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    public void logout (){
        try {
                contextHolder.getHeaders().remove("Authorization");
                contextHolder.setClientId(null);
                contextHolder.setDeviceId(null);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
