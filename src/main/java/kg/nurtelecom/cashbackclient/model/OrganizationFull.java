package kg.nurtelecom.cashbackclient.model;

import java.util.List;

public class OrganizationFull extends OrganizationShort {

    private List<FilialShort> filials;

    private List<EventShort> events;

    private List<BonusShort> bonuses;


    public OrganizationFull() {
    }

    public OrganizationFull(OrganizationShort organizationShort, List<FilialShort> filials, List<EventShort> events, List<BonusShort> bonuses, Double amountOfBonus) {
        super(organizationShort, amountOfBonus);
        this.filials = filials;
        this.events = events;
        this.bonuses = bonuses;
    }

    public OrganizationFull(Long id, String name, String description, String imageUrl, List<FilialShort> filials, List<EventShort> events, List<BonusShort> bonuses, Double amountOfBonus   ) {
        super(id, name, description, imageUrl, amountOfBonus);
        this.filials = filials;
        this.events = events;
        this.bonuses = bonuses;
    }

    public List<FilialShort> getFilials() {
        return filials;
    }

    public void setFilials(List<FilialShort> filials) {
        this.filials = filials;
    }

    public List<EventShort> getEvents() {
        return events;
    }

    public void setEvents(List<EventShort> events) {
        this.events = events;
    }

    public List<BonusShort> getBonuses() {
        return bonuses;
    }

    public void setBonuses(List<BonusShort> bonuses) {
        this.bonuses = bonuses;
    }
}
