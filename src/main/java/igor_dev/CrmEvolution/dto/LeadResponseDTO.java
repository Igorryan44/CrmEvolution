package igor_dev.CrmEvolution.dto;

import igor_dev.CrmEvolution.enums.Canais;
import igor_dev.CrmEvolution.enums.LeadStatus;
import igor_dev.CrmEvolution.enums.Segmento;

import java.time.OffsetDateTime;

public record LeadResponseDTO(

        Long id,

        String empresa,

        LeadStatus status,

        Segmento segmento,

        Canais canalOrigem,

        Integer score,

        OffsetDateTime createAt,

        OffsetDateTime updateAt

) {


}
