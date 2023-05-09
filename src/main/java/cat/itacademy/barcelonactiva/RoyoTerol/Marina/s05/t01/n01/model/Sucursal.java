package cat.itacademy.barcelonactiva.RoyoTerol.Marina.s05.t01.n01.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private Integer id;

    @Column (name = "name", nullable = false, length = 60, unique = true)
    private String name;

    @Column (name = "country")
    private String country;

}
