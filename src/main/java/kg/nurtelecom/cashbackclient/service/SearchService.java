package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.OrganizationModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@Service
public class SearchService {


    private final RestTemplate restTemplate;

    SearchService (RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public List<OrganizationModel> findByName(String name){
        String url = "http://localhost:8080/api/organization/list/search?search=" + name;

        ObjectMapper mapper = new ObjectMapper();
        String json =  restTemplate.getForObject(url, String.class,1);
        System.out.println(json);


        List<OrganizationModel> result = new ArrayList<>();


        try {
            result = Arrays.asList(mapper.readValue(json, OrganizationModel[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}