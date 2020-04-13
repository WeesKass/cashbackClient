package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.HistoryModel;
import kg.nurtelecom.cashbackclient.utils.ContextHolder;
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

    private ContextHolder contextHolder;

    private final RestTemplate restTemplate;

    BalanceHistoryService (RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
        contextHolder = ContextHolder.getInstance();
    }

    public List<HistoryModel> getAllHistory(Long id){
        String url = "http://localhost:4445/api/balanceHistory/client/{id}";
        System.out.println(contextHolder.getHeaders().toString());
        ObjectMapper mapper = new ObjectMapper();
        ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(contextHolder.getHeaders()), String.class , contextHolder.getClientId());
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
