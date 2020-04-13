package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.OrganizationFullModel;
import kg.nurtelecom.cashbackclient.model.OrganizationModel;
import kg.nurtelecom.cashbackclient.utils.ContextHolder;
import kg.nurtelecom.cashbackclient.model.pages.OrganizationPage;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrganizationService {

    private ContextHolder contextHolder;
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    public OrganizationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        contextHolder = ContextHolder.getInstance();
        mapper = new ObjectMapper();
    }

    public OrganizationPage getAllOrgByNameOrDesc(String search, Integer page, Integer size){
        String url = String.format("http://localhost:4445/api/organization/list?search=%s&page=%d&size=%d",search,page,size);

        ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(contextHolder.getHeaders()), String.class);
        OrganizationPage result = new OrganizationPage();
        try {
            result = mapper.readValue(response.getBody(), OrganizationPage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Map<String, List<OrganizationModel>> getAllSubscribes(Long id){
        String url = "http://localhost:4445/api/organization/list/{id}";

        ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(contextHolder.getHeaders()), String.class , contextHolder.getClientId());
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

    public OrganizationFullModel getOrganizationInfo(Long id) {
        String url = "http://localhost:4445/api/organization/info/{id}";

        ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(contextHolder.getHeaders()), String.class, id);
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
