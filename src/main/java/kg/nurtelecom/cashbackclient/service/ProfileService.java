package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.*;
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
        String url = "http://157.245.219.46:4445/api/clientDevice/" + clientId;

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
        String url = "http://157.245.219.46:4445/api/client/" + clientId;
        restTemplate.put(url, dto);
    }

    public Boolean putDeviceById(Long clientId, DeviceChangeModel dto) {
        String url = "http://157.245.219.46:4445/api/clientDevice/" + clientId;
        HttpEntity<DeviceChangeModel> request = new HttpEntity<>(dto, contextHolder.getHeaders());
        if(restTemplate.postForEntity(url, request, String.class).getStatusCode() == HttpStatus.ACCEPTED){
            return true;
        }
        return false;
    }
    public Boolean changeDeviceById(Long clientId, String phone) {
        String url = "http://157.245.219.46:4445/api/clientDevice/phone/" + clientId;

        HttpEntity<String> request = new HttpEntity<String>(phone, contextHolder.getHeaders());
        System.out.println(request.toString());
        if(restTemplate.postForEntity(url, request, String.class).getStatusCode() == HttpStatus.ACCEPTED){
            return true;
        }
        return false;
    }

    public Boolean createDeviceById(Long clientId, AuthModel model) {
        String url = "http://157.245.219.46:4445/api/clientDevice/device";
        System.out.println("yo");
        HttpEntity<NewDeviceModel> request = new HttpEntity<NewDeviceModel>(new NewDeviceModel(1,model.getUsername(),model.getPassword(),"Desktop-IMEI-25162243"), contextHolder.getHeaders());
        System.out.println(request.toString());
        HttpStatus status = restTemplate.postForEntity(url, request, String.class).getStatusCode();
        if(status == HttpStatus.ACCEPTED || status == HttpStatus.OK){
            return true;
        }
        return false;
    }
}
