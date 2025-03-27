package algebra.spring_boot.Upis;

import algebra.spring_boot.Polaznik.Polaznik;
import algebra.spring_boot.ProgramObrazovanja.ProgramObrazovanja;
import algebra.spring_boot.Upis.dto.CreateUpisDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UpisServiceImpl implements UpisService{


    private final UpisRespository upisRespository;


    @Override
    public Optional<Upis> findById(Integer id) {
        return upisRespository.findById(id);
    }

    @Override
    public List<Upis> findAll() {
        return upisRespository.findAll();
    }

    @Override
    public Upis create(CreateUpisDto dto) {
        Polaznik polaznik = new Polaznik(dto.getPOLAZNIK_ID());
        ProgramObrazovanja programObrazovanja = new ProgramObrazovanja(dto.getPROGRAM_OBRAZOVANJA_ID());
        Upis upis = new Upis(polaznik,programObrazovanja);
        return upisRespository.save(upis);
    }
}
