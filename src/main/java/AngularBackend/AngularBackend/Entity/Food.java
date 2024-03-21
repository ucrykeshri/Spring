package AngularBackend.AngularBackend.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int foodId;
    String name;
    double price;
    double discount;
    String reviews;
    String recipie;

}

