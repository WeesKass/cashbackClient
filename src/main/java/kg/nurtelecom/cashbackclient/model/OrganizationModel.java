package kg.nurtelecom.cashbackclient.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrganizationModel {

    private Long id;
    private String imageUrl;
    private Boolean status;
    private String name;
    private Long categoryId;
    private String categoryName;
    private String description;
}