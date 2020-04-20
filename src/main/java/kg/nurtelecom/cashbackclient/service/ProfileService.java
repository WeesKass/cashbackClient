package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.ClientChangeModel;
import kg.nurtelecom.cashbackclient.model.ProfileModel;
import kg.nurtelecom.cashbackclient.model.DeviceChangeModel;
import kg.nurtelecom.cashbackclient.utils.ContextHolder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service

public class ProfileService {

    private ContextHolder contextHolder;
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    public ProfileService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        contextHolder = ContextHolder.getInstance();
        mapper = new ObjectMapper();
    }
    public ProfileModel getClientById(Long clientId) {
        String url = "http://localhost:4445/api/clientDevice/" + 1;

        String json =  restTemplate.getForObject(url, String.class);
        System.out.println(json);

        try {
            return mapper.readValue(json, ProfileModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ProfileModel();
    }

    public void putClientById(Long clientId, ClientChangeModel dto) {
        String url = "http://localhost:4445/api/client/" + 1;
        restTemplate.put(url, dto);
    }

    public Boolean putDeviceById(Long clientId, DeviceChangeModel dto) {
        String url = "http://localhost:4445/api/clientDevice/" + 1;
        HttpEntity<DeviceChangeModel> request = new HttpEntity<>(dto, contextHolder.getHeaders());
        if(restTemplate.postForEntity(url, request, String.class).getStatusCode() == HttpStatus.ACCEPTED){
            return true;
        }
        return false;
    }
    public Boolean changeDeviceById(Long clientId, String phone) {
        String url = "http://localhost:4445/api/clientDevice/phone/" + 1;

        HttpEntity<String> request = new HttpEntity<String>(phone, contextHolder.getHeaders());
        System.out.println(request.toString());
        if(restTemplate.postForEntity(url, request, String.class).getStatusCode() == HttpStatus.ACCEPTED){
            return true;
        }
        return false;
    }
}
