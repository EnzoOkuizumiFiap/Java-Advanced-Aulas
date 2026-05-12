package fiap.com.br.services.model;

import fiap.com.br.services.controller.ProfessionalController;
import jakarta.persistence.*;
import org.springframework.hateoas.EntityModel;

import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private Integer rating;

    @ManyToMany
    private Set<Category> categories;

    @ManyToOne
    private Location location;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public EntityModel<Professional> toEntityModel() {
        var linkAllProfessional = linkTo(methodOn(ProfessionalController.class).findAll()).withRel("all-professionals").withTitle("All Professionals");
        var linkSelf = linkTo(methodOn(ProfessionalController.class).findById(id)).withSelfRel().withTitle("Professional Details");
        var linkNearby = linkTo(methodOn(ProfessionalController.class).findByLocationId(this.location.getId())).withRel("nearby-locations").withTitle("Nearby Professionals");

        return EntityModel.of(this, linkAllProfessional, linkSelf);
    }
}
