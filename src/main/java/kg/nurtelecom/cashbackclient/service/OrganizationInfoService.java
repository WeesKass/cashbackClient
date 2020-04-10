package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.OrganizationFullModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class OrganizationInfoService {

    @Autowired
    RequestTemplate requestTemplate;

    private final RestTemplate restTemplate;

    public OrganizationInfoService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public OrganizationFullModel getOrganizationInfo(Long id) {
        String url = "http://localhost:4445/api/organization/info/{id}";

        ObjectMapper mapper = new ObjectMapper();
        ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(requestTemplate.getHeaders()), String.class, id);
        System.out.println(response);
        OrganizationFullModel orgFull = new OrganizationFullModel();
        try {
            orgFull = mapper.readValue(response.getBody(), OrganizationFullModel.class);
            System.out.println(orgFull.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orgFull;
    }

}
