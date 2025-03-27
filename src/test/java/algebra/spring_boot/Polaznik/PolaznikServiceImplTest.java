package algebra.spring_boot.Polaznik;

import algebra.spring_boot.Polaznik.dto.CreatePolaznikDto;
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

class PolaznikServiceImplTest {


    @InjectMocks
    private PolaznikServiceImpl polaznikService;

    @Mock
    private PolaznikRepository polaznikRepositoryMock;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void testFindById() {
        Polaznik polaznik = new Polaznik("Marko","Maric");

        when(polaznikRepositoryMock.findById(polaznik.getId())).thenReturn(Optional.of(polaznik));

        polaznikService.findById(polaznik.getId());

        verify(polaznikRepositoryMock, times(1)).findById(polaznik.getId());
    }


    @Test
    public void testFindAll() {
        Polaznik polaznik = new Polaznik("Marko","Maric");
        Polaznik polaznik2 = new Polaznik("Ivan","Ivic");

        List<Polaznik> polaznikList = new ArrayList<>();
        polaznikList.add(polaznik);
        polaznikList.add(polaznik2);

        when(polaznikRepositoryMock.findAll()).thenReturn(polaznikList);

        polaznikService.findAll();

        verify(polaznikRepositoryMock, times(1)).findAll();
    }


    @Test
    public void testCreate() {
        CreatePolaznikDto dto = new CreatePolaznikDto("Marko", "Maric");
        Polaznik polaznik = new Polaznik(dto.getIme(), dto.getPrezime());

        when(polaznikRepositoryMock.save(polaznik)).thenReturn(polaznik);

        polaznikService.create(dto);

        verify(polaznikRepositoryMock,times(1)).save(polaznik);
    }






}