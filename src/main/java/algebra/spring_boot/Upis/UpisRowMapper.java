package algebra.spring_boot.Upis;

import algebra.spring_boot.Polaznik.Polaznik;
import algebra.spring_boot.ProgramObrazovanja.ProgramObrazovanja;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpisRowMapper implements RowMapper<Upis> {
    @Override
    public Upis mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer id = rs.getInt("id");
        Integer polaznikId= rs.getInt("POLAZNIK_ID");
        Integer programObrazovanjaId= rs.getInt("PROGRAM_OBRAZOVANJA_ID");

        String ime = rs.getString("ime");
        String prezime = rs.getString("prezime");

        String naziv = rs.getString("naziv");
        Integer csvet = rs.getInt("csvet");

        Polaznik polaznik = new Polaznik(polaznikId,ime,prezime);
        ProgramObrazovanja programObrazovanja = new ProgramObrazovanja(programObrazovanjaId,naziv,csvet);



        return new Upis(id,polaznik,programObrazovanja);
    }
}
