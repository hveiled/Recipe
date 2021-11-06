package recipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.w3c.dom.NameList;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Getter
@Setter
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "description")
    @NotBlank
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @Size(min = 1, message = "Must be at least one ingredient")
    private List<String> ingredients = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @Size(min = 1, message = "Must be at least one direction")
    @NotEmpty
    private List<String> directions = new ArrayList<>();

    @Override
    public String toString() {
        return "Recipe{" + '\n' +
                "id=" + id + '\n' +
                ", name='" + name + '\'' + '\n' +
                ", description='" + description + '\'' + '\n' +
                ", ingredients=" + ingredients + '\n' +
                ", directions=" + directions + '\n' +
                '}';
    }
}
