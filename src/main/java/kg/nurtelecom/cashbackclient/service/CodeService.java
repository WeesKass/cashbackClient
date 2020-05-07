package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.ClientPersonalCodeModel;
import kg.nurtelecom.cashbackclient.utils.ContextHolder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class CodeService {

    ContextHolder contextHolder;


    private final RestTemplate restTemplate;

    CodeService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
        contextHolder = ContextHolder.getInstance();
    }

    public ClientPersonalCodeModel getCodeByClientId() {
        String url = "http://157.245.219.46:4445/api/client/code/{id}";
        ClientPersonalCodeModel result = new ClientPersonalCodeModel();
        System.out.println(contextHolder.getHeaders().toString());
        HttpEntity<Object> entity = new HttpEntity<>(contextHolder.getHeaders());
        try {
            ObjectMapper mapper = new ObjectMapper();
            ResponseEntity<String> response =  restTemplate.exchange(url, HttpMethod.GET, entity, String.class , contextHolder.getClientId()); //contextHolder.getClientId()
            result = mapper.readValue(response.getBody(), ClientPersonalCodeModel.class);
//            GenerateQRCode.generateQRCodeImage(result.getPersonalCode());
//            result.setImageUrl("/assets/img/qr.png");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
