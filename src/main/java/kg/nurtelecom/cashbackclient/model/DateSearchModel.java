package kg.nurtelecom.cashbackclient.model;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DateSearchModel {
    private String from;
    private String to;
}
