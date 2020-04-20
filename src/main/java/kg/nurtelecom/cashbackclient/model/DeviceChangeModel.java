package kg.nurtelecom.cashbackclient.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeviceChangeModel {
    private String currentPassword;
    private String newPassword;
    private String confirmPassword;
}
