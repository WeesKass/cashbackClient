package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.OrganizationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@Service
public class ClientOrgSubscribesService {

    @Autowired
    private RequestTemplate requestTemplate;

    private final RestTemplate restTemplate;

    ClientOrgSubscribesService (RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public Map<String, List<OrganizationModel>> getAllSubscribes(Long id){
        String url = "http://157.245.219.46:4445/api/organization/list/{id}";


        ObjectMapper mapper = new ObjectMapper();
        ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(requestTemplate.getHeaders()), String.class , requestTemplate.getClientId());
        System.out.println(response);
        Map<String,List<OrganizationModel>> result = new HashMap<>();
        try {

            OrganizationModel[] list2 = mapper.readValue(response.getBody(), OrganizationModel[].class);

            for (OrganizationModel org : list2 ){
                if (!result.containsKey(org.getCategoryName())) {
                    result.put(org.getCategoryName(), new ArrayList<>());
                }
                result.get(org.getCategoryName()).add(org);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}