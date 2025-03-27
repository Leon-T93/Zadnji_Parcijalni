package algebra.spring_boot.Upis;

import algebra.spring_boot.Polaznik.Polaznik;
import algebra.spring_boot.ProgramObrazovanja.ProgramObrazovanja;
import algebra.spring_boot.ProgramObrazovanja.dto.CreateProgramObrazovanjaDto;
import algebra.spring_boot.Upis.dto.CreateUpisDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/upisi")
@AllArgsConstructor
public class UpisController {

    private final UpisService upisService;


    @GetMapping
    public ResponseEntity<List<Upis>> findAll() {

        List<Upis> upisi = upisService.findAll();

        return ResponseEntity.status(200).body(upisi);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Upis> findById(@PathVariable Integer id) {
        Optional<Upis> upis = upisService.findById(id);

        if (upis.isEmpty()){
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(upis.get());
    }

    @PostMapping()
    public ResponseEntity<Upis> create (@Valid @RequestBody CreateUpisDto dto) {
        Upis upis = upisService.create(dto);
        return ResponseEntity.status(201).body(upis);
    }
}
