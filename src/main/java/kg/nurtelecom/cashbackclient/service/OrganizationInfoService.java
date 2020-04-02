package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.OrganizationFullModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class OrganizationInfoService {

    private final RestTemplate restTemplate;

    public OrganizationInfoService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public OrganizationFullModel getOrganizationInfo(Long id) {
        String url = "http://157.245.219.46:4445/api/organization/info/{id}";

        ObjectMapper mapper = new ObjectMapper();
        String json = restTemplate.getForObject(url, String.class, id);
        System.out.println(json);
        OrganizationFullModel orgFull = new OrganizationFullModel();
        try {
            orgFull = mapper.readValue(json, OrganizationFullModel.class);
            System.out.println(orgFull.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orgFull;
    }

}
