package algebra.spring_boot.Polaznik;

import algebra.spring_boot.Polaznik.dto.CreatePolaznikDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/polaznici")
@AllArgsConstructor
public class PolaznikController {

    private final PolaznikService polaznikService;




    @GetMapping
    public ResponseEntity<List<Polaznik>> findAll() {

        List<Polaznik> polaznici = polaznikService.findAll();

        return ResponseEntity.status(200).body(polaznici);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Polaznik> findById(@PathVariable Integer id) {
        Optional<Polaznik> polaznik = polaznikService.findById(id);

        if (polaznik.isEmpty()){
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(200).body(polaznik.get());
    }


    @PostMapping()
    public ResponseEntity<Polaznik> create (@Valid @RequestBody CreatePolaznikDto dto) {
        Polaznik polaznik = polaznikService.create(dto);
        return ResponseEntity.status(201).body(polaznik);
    }
}
