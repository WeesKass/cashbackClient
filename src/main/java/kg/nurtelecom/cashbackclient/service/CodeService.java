package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.nurtelecom.cashbackclient.model.ClientPersonalCodeModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class CodeService {

    private final RestTemplate restTemplate;

    CodeService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public ClientPersonalCodeModel getCodeByClientId(Long clientId) {
        String url = "http://157.245.219.46:4445/api/client/code/{id}";
        ClientPersonalCodeModel result = new ClientPersonalCodeModel();


        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = restTemplate.getForObject(url, String.class, clientId);
            result = mapper.readValue(json, ClientPersonalCodeModel.class);
//            GenerateQRCode.generateQRCodeImage(result.getPersonalCode());
//            result.setImageUrl("/assets/img/qr.png");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
