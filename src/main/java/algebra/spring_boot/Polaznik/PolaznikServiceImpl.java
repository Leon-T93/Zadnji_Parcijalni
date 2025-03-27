package algebra.spring_boot.Polaznik;

import algebra.spring_boot.Polaznik.dto.CreatePolaznikDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PolaznikServiceImpl implements PolaznikService{

    private final PolaznikRepository polaznikRepository;



    @Override
    public Optional<Polaznik> findById(Integer id) {
        return polaznikRepository.findById(id);
    }


    @Override
    public List<Polaznik> findAll() {
        return polaznikRepository.findAll();
    }

    @Override
    public Polaznik create(CreatePolaznikDto dto) {
        Polaznik polaznik = new Polaznik(dto.getIme(),dto.getPrezime());

        return polaznikRepository.save(polaznik);
    }
}
