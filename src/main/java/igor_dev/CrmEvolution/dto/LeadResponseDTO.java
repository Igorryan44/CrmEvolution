package igor_dev.CrmEvolution.dto;

import igor_dev.CrmEvolution.enums.Canais;
import igor_dev.CrmEvolution.enums.Segmento;

import java.time.OffsetDateTime;

public record LeadResponseDTO(

        Long id,

        String empresa,

        Segmento segmento,

        Canais canalOrigem,

        Integer score,

        OffsetDateTime createAt,

        OffsetDateTime updateAt

) {


}
