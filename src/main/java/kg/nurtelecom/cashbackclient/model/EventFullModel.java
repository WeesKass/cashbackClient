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
public class EventFullModel {
    private Long id;
    private String name;
    private Date dateFrom;
    private Date dateTo;
    private String description;
}
