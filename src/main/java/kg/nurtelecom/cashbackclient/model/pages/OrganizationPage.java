package kg.nurtelecom.cashbackclient.model.pages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kg.nurtelecom.cashbackclient.model.OrganizationModel;
import lombok.*;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationPage {
    private List<OrganizationModel> content;
    private Boolean last;
    private Integer totalElements;
    private Integer totalPages;
    private Integer size;
    private Integer number;
    private Boolean first;
    private Integer numberOfElements;

}
