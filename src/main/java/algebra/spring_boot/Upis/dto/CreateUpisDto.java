package algebra.spring_boot.Upis.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUpisDto {

    @NotNull
    private Integer PROGRAM_OBRAZOVANJA_ID;

    @NotNull
    private Integer POLAZNIK_ID;
}
