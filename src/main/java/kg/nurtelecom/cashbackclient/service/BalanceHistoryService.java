package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.HistoryModel;
import kg.nurtelecom.cashbackclient.model.pages.HistoryPage;
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

    public HistoryPage getAllHistory(Integer page, Integer size){
        String url = String.format("http://localhost:4445/api/balanceHistory/client/%d?page=%d&size=%d", 1L, page, size); //contextHolder.getClientId()
        System.out.println(contextHolder.getHeaders().toString());
        ObjectMapper mapper = new ObjectMapper();
        ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(contextHolder.getHeaders()), String.class);
        System.out.println(response);
        HistoryPage result = new HistoryPage();

        try {
            result = mapper.readValue(response.getBody(), HistoryPage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
