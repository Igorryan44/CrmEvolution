package igor_dev.CrmEvolution.model;

import igor_dev.CrmEvolution.enums.Canais;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table()
public class AuditEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String entidade;

    private Long entidadeId;

    private String acao;

    @Enumerated(EnumType.STRING)
    private Canais canal;

    private OffsetDateTime timestamp;
}
