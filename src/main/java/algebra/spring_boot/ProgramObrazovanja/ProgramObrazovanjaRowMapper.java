package algebra.spring_boot.ProgramObrazovanja;

import algebra.spring_boot.Polaznik.Polaznik;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgramObrazovanjaRowMapper implements RowMapper<ProgramObrazovanja> {
    @Override
    public ProgramObrazovanja mapRow(ResultSet rs, int rowNum) throws SQLException {

        Integer id = rs.getInt("id");
        String naziv = rs.getString("naziv");
        Integer csvet = rs.getInt("csvet");



        return new ProgramObrazovanja(id,naziv,csvet);
    }
}
