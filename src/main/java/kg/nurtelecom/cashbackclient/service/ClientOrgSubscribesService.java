package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.OrganizationModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@Service
public class ClientOrgSubscribesService {


    private final RestTemplate restTemplate;

    ClientOrgSubscribesService (RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public Map<String, List<OrganizationModel>> getAllSubscribes(Long id){
        String url = "http://localhost:8080/api/organization/list/{id}";

        ObjectMapper mapper = new ObjectMapper();
        String json =  restTemplate.getForObject(url, String.class, 1);
        System.out.println(json);
        Map<String,List<OrganizationModel>> result = new HashMap<>();
        try {

            List<OrganizationModel> list2 = Arrays.asList(mapper.readValue(json, OrganizationModel[].class));

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