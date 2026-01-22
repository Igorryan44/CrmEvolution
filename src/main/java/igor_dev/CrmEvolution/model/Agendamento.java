package igor_dev.CrmEvolution.model;

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
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private OffsetDateTime dataHoraAgendada;

    private Boolean realizado;

    private OffsetDateTime createAt;

    @ManyToOne()
    @JoinColumn(name = "lead_id")
    private Lead lead;
}
