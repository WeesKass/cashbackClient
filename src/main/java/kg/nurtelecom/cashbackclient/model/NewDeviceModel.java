package kg.nurtelecom.cashbackclient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewDeviceModel {
    private Integer clientId;
    private String phoneNumber;
    private String password;
    private String imei;
}
