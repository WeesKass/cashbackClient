package kg.nurtelecom.cashbackclient.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientChangeModel {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String clientSex;
    private String nationality;
    private String locale;
}
