package kg.nurtelecom.cashbackclient.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryModel {
    private Long id;
    private Long clientId;
    private Date createdDate;//
    private String operationType;//
    private Double amount;//
    private Double total;
    private String bonusType;
    private String organizationName;//
}
