package algebra.spring_boot.ProgramObrazovanja;

import algebra.spring_boot.Polaznik.Polaznik;
import algebra.spring_boot.Polaznik.dto.CreatePolaznikDto;
import algebra.spring_boot.ProgramObrazovanja.dto.CreateProgramObrazovanjaDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/programiObrazovanja")
@AllArgsConstructor
public class ProgramObrazovanjaController {

    private final ProgramObrazovanjaService programObrazovanjaService;



    @GetMapping
    public ResponseEntity<List<ProgramObrazovanja>> findAll() {

        List<ProgramObrazovanja> programiObrazovanja = programObrazovanjaService.findAll();

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

    @PostMapping()
    public ResponseEntity<ProgramObrazovanja> create (@Valid @RequestBody CreateProgramObrazovanjaDto dto) {
        ProgramObrazovanja programObrazovanja = programObrazovanjaService.create(dto);
        return ResponseEntity.status(201).body(programObrazovanja);
    }
}
