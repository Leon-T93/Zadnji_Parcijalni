package algebra.spring_boot.Upis;

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
@RequestMapping("/upisi")
@AllArgsConstructor
public class UpisController {

    private final UpisService upisService;


    @GetMapping
    public ResponseEntity<List<Upis>> fetchAll() {

        List<Upis> upisi = upisService.fetchAll();

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
}
