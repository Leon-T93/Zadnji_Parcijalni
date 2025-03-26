package algebra.spring_boot.ProgramObrazovanja;

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
@Table(name = "PROGRAM_OBRAZOVANJA")
public class ProgramObrazovanja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "csvet")
    private Integer csvet;

    @JsonBackReference
    @OneToMany(mappedBy = "programObrazovanja")
    private List<Upis> upisi;

    public ProgramObrazovanja(Integer id, String naziv, Integer csvet) {
        this.id = id;
        this.naziv = naziv;
        this.csvet = csvet;
    }
}
