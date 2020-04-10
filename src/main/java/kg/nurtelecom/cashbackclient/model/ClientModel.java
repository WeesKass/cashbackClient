package kg.nurtelecom.cashbackclient.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String clientSex;
    private Date createdDate;
    private String nationality;
}
