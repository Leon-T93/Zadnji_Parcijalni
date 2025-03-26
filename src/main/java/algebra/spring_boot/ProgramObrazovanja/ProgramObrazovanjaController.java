package algebra.spring_boot.ProgramObrazovanja;

import algebra.spring_boot.Polaznik.Polaznik;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/programiObrazovanja")
@AllArgsConstructor
public class ProgramObrazovanjaController {

    private final ProgramObrazovanjaService programObrazovanjaService;



    @GetMapping
    public ResponseEntity<List<ProgramObrazovanja>> fetchAll() {

        List<ProgramObrazovanja> programiObrazovanja = programObrazovanjaService.fetchAll();

        return ResponseEntity.status(200).body(programiObrazovanja);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProgramObrazovanja> findById(@PathVariable Integer id) {
        Optional<ProgramObrazovanja> programObrazovanja = programObrazovanjaService.findById(id);

        if (programObrazovanja.isEmpty()){
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(programObrazovanja.get());
    }
}
