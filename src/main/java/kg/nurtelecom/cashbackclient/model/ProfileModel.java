package kg.nurtelecom.cashbackclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileModel {
    private Long id;
    private ClientModel client;
    private String phoneNumber;
    private String imei;
    private Date lastEnterDate;
    private Boolean status;
}
