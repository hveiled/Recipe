package recipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "Recipe name should not to be blank")
    private String name;

    @Column(name = "category")
    @NotBlank(message = "Recipe category should not to be blank")
    private String category;

    @Column(name = "date")
    private String date;

    @Column(name = "description")
    @NotBlank(message = "Recipe description should not to be blank")
    private String description;

    @Column(name = "autor_id")
    @JsonIgnore
    private Long autorId;

    @ElementCollection(fetch = FetchType.EAGER)
    @Size(min = 1, message = "Must be at least one ingredient")
    @Fetch(FetchMode.SELECT)
    private List<String> ingredients = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @Size(min = 1, message = "Must be at least one direction")
    @Fetch(FetchMode.SELECT)
    private List<String> directions = new ArrayList<>();
}
