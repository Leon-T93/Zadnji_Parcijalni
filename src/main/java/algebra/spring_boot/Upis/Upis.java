package algebra.spring_boot.Upis;

import algebra.spring_boot.Polaznik.Polaznik;
import algebra.spring_boot.ProgramObrazovanja.ProgramObrazovanja;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UPIS")
public class Upis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "POLAZNIK_ID", referencedColumnName = "id")
    private Polaznik polaznik;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "PROGRAM_OBRAZOVANJA_ID", referencedColumnName = "id")
    private ProgramObrazovanja programObrazovanja;

    public Upis(Polaznik polaznik) {
        this.polaznik = polaznik;
    }

    public Upis(Polaznik polaznik, ProgramObrazovanja programObrazovanja) {
        this.polaznik = polaznik;
        this.programObrazovanja = programObrazovanja;
    }
}
