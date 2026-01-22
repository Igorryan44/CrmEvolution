package igor_dev.CrmEvolution.model;

import igor_dev.CrmEvolution.enums.Segmento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table()
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razaoSocial;

    private String nomeFantasia;

    private String cnpj;

    @Enumerated(EnumType.STRING)
    private Segmento segmento;

    private OffsetDateTime createdAt;

    @OneToMany(mappedBy = "leads", cascade = CascadeType.ALL)
    private List<Lead> leads;

}
