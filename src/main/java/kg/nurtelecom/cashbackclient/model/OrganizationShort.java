package kg.nurtelecom.cashbackclient.model;

public class OrganizationShort {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;

    public OrganizationShort() {
    }

    public OrganizationShort(OrganizationShort organizationShort) {
        this(organizationShort.id, organizationShort.name, organizationShort.description, organizationShort.imageUrl);
    }

    public OrganizationShort(Long id, String name, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return imageUrl;
    }

    public void setImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
