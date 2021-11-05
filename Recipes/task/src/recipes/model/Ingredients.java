package recipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Ingredients")
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ingredient_id")
    @JsonIgnore
    private Long id;

    @Column(name = "ingredient")
    @JsonIgnore
    private String ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="recipe_id")
    @JsonIgnore
    private Recipe recipe;

    public Ingredients(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "id=" + id +
                ", ingredient='" + ingredient + '\'' +
                ", recipe=" + recipe +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredients that = (Ingredients) o;
        return ingredient.equals(that.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient);
    }
}
