package kg.nurtelecom.cashbackclient.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.WriterException;
import kg.nurtelecom.cashbackclient.model.ClientPersonalCodeModel;
import kg.nurtelecom.cashbackclient.model.OrganizationModel;
import kg.nurtelecom.cashbackclient.utils.GenerateQRCode;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

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
