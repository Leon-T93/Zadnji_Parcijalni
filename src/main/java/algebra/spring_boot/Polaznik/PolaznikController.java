package algebra.spring_boot.Polaznik;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/polaznici")
@AllArgsConstructor
public class PolaznikController {

    private final PolaznikService polaznikService;




    @GetMapping
    public ResponseEntity<List<Polaznik>> fetchAll() {

        List<Polaznik> polaznici = polaznikService.fetchAll();

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
}
