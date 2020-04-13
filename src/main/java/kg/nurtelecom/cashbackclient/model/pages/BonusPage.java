package kg.nurtelecom.cashbackclient.model.pages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kg.nurtelecom.cashbackclient.model.BonusShortModel;
import lombok.*;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class BonusPage {
    private List<BonusShortModel> content;
    private Boolean last;
    private Integer totalElements;
    private Integer totalPages;
    private Integer size;
    private Integer number;
    private Boolean first;
    private Integer numberOfElements;

}
