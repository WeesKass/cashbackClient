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
public class BonusShortModel {
    private Long id;
    private Date validFrom;
    private Date validTo;
    private Integer validity;
    private Date createdDate;
    private String orgBonusType;
}
