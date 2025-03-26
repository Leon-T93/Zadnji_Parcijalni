package algebra.spring_boot.Polaznik;

import algebra.spring_boot.Upis.Upis;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "POLAZNIK")
public class Polaznik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;


    @JsonBackReference
    @OneToMany(mappedBy = "polaznik")
    private List<Upis> upisi;

    public Polaznik(Integer id, String ime, String prezime) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
    }
}
