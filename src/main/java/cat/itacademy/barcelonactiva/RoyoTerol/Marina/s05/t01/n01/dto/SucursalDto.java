package cat.itacademy.barcelonactiva.RoyoTerol.Marina.s05.t01.n01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SucursalDto {

    private Integer id;
    private String name;
    private String country;
    private String typeSucursal;

    private final List<String> countries = new ArrayList<>(Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus", "Czech Republic",
            "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta",
            "Netherlands", "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden"));

    public SucursalDto(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public void setCountry(String country) {
        this.country = country;
        this.typeSucursal = countries.stream().anyMatch(type -> type.equalsIgnoreCase(country)) ? "UE" : "Not UE";
    }
}
