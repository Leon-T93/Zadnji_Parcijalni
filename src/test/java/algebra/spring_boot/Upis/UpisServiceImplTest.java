package algebra.spring_boot.Upis;

import algebra.spring_boot.Polaznik.Polaznik;
import algebra.spring_boot.Polaznik.PolaznikRepository;
import algebra.spring_boot.Polaznik.PolaznikServiceImpl;
import algebra.spring_boot.Polaznik.dto.CreatePolaznikDto;
import algebra.spring_boot.ProgramObrazovanja.ProgramObrazovanja;
import algebra.spring_boot.Upis.dto.CreateUpisDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UpisServiceImplTest {


    @InjectMocks
    private UpisServiceImpl upisService;

    @Mock
    private UpisRespository upisRespositoryMock;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testFindById() {
        Polaznik polaznik = new Polaznik("Marko","Maric");
        ProgramObrazovanja programObrazovanja = new ProgramObrazovanja("Programiranje",5);
        Upis upis = new Upis(polaznik,programObrazovanja);

        when(upisRespositoryMock.findById(upis.getId())).thenReturn(Optional.of(upis));

        upisService.findById(upis.getId());

        verify(upisRespositoryMock, times(1)).findById(upis.getId());
    }


    @Test
    public void testFindAll() {
        Polaznik polaznik = new Polaznik("Marko","Maric");
        Polaznik polaznik2 = new Polaznik("Ivan","Ivic");
        ProgramObrazovanja programObrazovanja = new ProgramObrazovanja("Programiranje",5);
        ProgramObrazovanja programObrazovanja2 = new ProgramObrazovanja("Matematika",4);

        Upis upis = new Upis(polaznik,programObrazovanja);
        Upis upis1 = new Upis(polaznik2, programObrazovanja2);

        List<Upis> upisList = new ArrayList<>();
        upisList.add(upis);
        upisList.add(upis1);

        when(upisRespositoryMock.findAll()).thenReturn(upisList);

        upisService.findAll();

        verify(upisRespositoryMock, times(1)).findAll();
    }

    @Test
    public void testCreate() {
        CreateUpisDto dto = new CreateUpisDto(1,2);
        Polaznik polaznik = new Polaznik(dto.getPOLAZNIK_ID());
        ProgramObrazovanja programObrazovanja = new ProgramObrazovanja(dto.getPROGRAM_OBRAZOVANJA_ID());
        Upis upis = new Upis(polaznik,programObrazovanja);

        when(upisRespositoryMock.save(upis)).thenReturn(upis);

        upisService.create(dto);

        verify(upisRespositoryMock,times(1)).save(upis);
    }


}