package kg.nurtelecom.cashbackclient.model;

import java.util.Date;

public class BonusShort {

    private Long id;
    private String bonusType;
    private Date validFrom;
    private Date validTo;
    private Integer validity;

    public BonusShort() {
    }

    public BonusShort(Long id, String bonusType, Date validFrom, Date validTo, Integer validity) {
        this.id = id;
        this.bonusType = bonusType;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.validity = validity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBonusType() {
        return bonusType;
    }

    public void setBonusType(String bonusType) {
        this.bonusType = bonusType;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }
}
