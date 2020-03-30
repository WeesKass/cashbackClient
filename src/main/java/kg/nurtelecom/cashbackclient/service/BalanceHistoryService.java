package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.HistoryModel;
import kg.nurtelecom.cashbackclient.model.OrganizationModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@Service
public class BalanceHistoryService {
    private final RestTemplate restTemplate;

    BalanceHistoryService (RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public List<HistoryModel> getAllHistory(Long id){
        String url = "http://157.245.219.46:4445/api/balanceHistory/client/{id}";

        ObjectMapper mapper = new ObjectMapper();
        String json =  restTemplate.getForObject(url, String.class, 1);
        System.out.println(json);
        List<HistoryModel> result = new ArrayList<>();

        try {
            result = Arrays.asList(mapper.readValue(json, HistoryModel[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
