package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.ClientPersonalCodeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class CodeService {

    @Autowired
    RequestTemplate requestTemplate;


    private final RestTemplate restTemplate;

    CodeService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public ClientPersonalCodeModel getCodeByClientId(Long clientId) {
        String url = "http://localhost:4445/api/client/code/{id}";
        ClientPersonalCodeModel result = new ClientPersonalCodeModel();
        System.out.println(requestTemplate.getHeaders().toString());
        HttpEntity<Object> entity = new HttpEntity<>(requestTemplate.getHeaders());
        try {
            ObjectMapper mapper = new ObjectMapper();
            ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.GET, entity, String.class , requestTemplate.getClientId());
            result = mapper.readValue(response.getBody(), ClientPersonalCodeModel.class);
//            GenerateQRCode.generateQRCodeImage(result.getPersonalCode());
//            result.setImageUrl("/assets/img/qr.png");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
