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
@Table(name = "Directions")
public class Directions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "direction_id")
    @JsonIgnore
    private Long id;

    @Column(name = "direction")
    @JsonIgnore
    private String direction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="recipe_id")
    @JsonIgnore
    private Recipe recipe;

    public Directions(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Directions{" +
                "id=" + id +
                ", direction='" + direction + '\'' +
                ", recipe=" + recipe +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directions that = (Directions) o;
        return direction.equals(that.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
