package kg.nurtelecom.cashbackclient.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationFullModel{

    private Long id;
    private String image;
    private Boolean status;
    private String name;
    private Long categoryId;
    private String categoryName;
    private String description;
    List<BonusShortModel> bonusShortModels;
    List<EventFullModel> eventModels;
    List<FilialShortModel> filialShortModels;


}
