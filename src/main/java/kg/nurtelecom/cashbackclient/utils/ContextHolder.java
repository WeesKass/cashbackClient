package kg.nurtelecom.cashbackclient.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class ContextHolder {
    private static ContextHolder instance = null;
    private HttpHeaders headers;
    private Long deviceId;
    private Long clientId;

    private ContextHolder() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public static ContextHolder getInstance(){
        if (instance == null){
            instance = new ContextHolder();
        }
        return instance;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
