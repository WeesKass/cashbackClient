package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.HistoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BalanceHistoryService {

    @Autowired
    private RequestTemplate requestTemplate;

    private final RestTemplate restTemplate;

    BalanceHistoryService (RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public List<HistoryModel> getAllHistory(Long id){
        String url = "http://157.245.219.46:4445/api/balanceHistory/client/{id}";
        System.out.println(requestTemplate.getHeaders().toString());
        ObjectMapper mapper = new ObjectMapper();
        ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(requestTemplate.getHeaders()), String.class , requestTemplate.getClientId());
        System.out.println(response);
        List<HistoryModel> result = new ArrayList<>();

        try {
            result = Arrays.asList(mapper.readValue(response.getBody(), HistoryModel[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
