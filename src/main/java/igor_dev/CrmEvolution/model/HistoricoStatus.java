package igor_dev.CrmEvolution.model;

import igor_dev.CrmEvolution.enums.LeadStatus;
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
public class HistoricoStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private LeadStatus statusAnterior;

    @Enumerated(EnumType.STRING)
    private LeadStatus statusNovo;

    private OffsetDateTime dataMudanca;
}
