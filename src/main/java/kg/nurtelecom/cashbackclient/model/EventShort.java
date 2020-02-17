package kg.nurtelecom.cashbackclient.model;

import java.util.Date;

public class EventShort {

    private Long id;
    private String description;
    private Date dateFrom;
    private Date dateTo;

    public EventShort() {
    }

    public EventShort(Long id, String description, Date dateFrom, Date dateTo) {
        this.id = id;
        this.description = description;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

}
