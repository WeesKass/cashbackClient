package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.pages.EventPage;
import kg.nurtelecom.cashbackclient.model.pages.FilialPage;
import kg.nurtelecom.cashbackclient.utils.ContextHolder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class FilialService {

    private ContextHolder contextHolder;
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    public FilialService (RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        contextHolder = ContextHolder.getInstance();
        mapper = new ObjectMapper();
    }

    public FilialPage getAllFilialsByOrgId(Long id, Integer page, Integer size){
        String url = String.format("http://localhost:4445/api/filial/org/%d?page=%d&size=%d", id, page,size);

        ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(contextHolder.getHeaders()), String.class);
        FilialPage result = new FilialPage();
        try {
            result = mapper.readValue(response.getBody(), FilialPage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}