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
    Long id;
    String orgBonusType;
    Date validFrom;
    Date validTo;
    Integer validity;
}
