package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.HistoryModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NotificationService {

    private final RestTemplate restTemplate;

    NotificationService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public List<HistoryModel> getNotificationByClientId(Long clientId) {
        String url = "http://localhost:8080/api/balanceHistory/client/{id}";

        ObjectMapper mapper = new ObjectMapper();
        String json = restTemplate.getForObject(url, String.class, clientId);
        List<HistoryModel> result = new ArrayList<>();

        try {
            result = Arrays.asList(mapper.readValue(json, HistoryModel[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
