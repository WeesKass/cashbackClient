package kg.nurtelecom.cashbackclient.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilialModel {
    private Long id;
    private String image;
    private Boolean status;
    private String address;
    private String name;
    private String description;
    private Double latitude;
    private Double longitude;
    private Long orgId;
    private Double averageRate;
}
