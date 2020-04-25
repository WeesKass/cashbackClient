package kg.nurtelecom.cashbackclient.model.pages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kg.nurtelecom.cashbackclient.model.FilialModel;
import kg.nurtelecom.cashbackclient.model.HistoryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class HistoryPage {
    private List<HistoryModel> content;
    private Boolean last;
    private Integer totalElements;
    private Integer totalPages;
    private Integer size;
    private Integer number;
    private Boolean first;
    private Integer numberOfElements;
}