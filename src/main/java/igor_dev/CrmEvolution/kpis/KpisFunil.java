package igor_dev.CrmEvolution.kpis;

import java.time.LocalDate;

public class KpisFunil {

    public Integer diasFunil(LocalDate diaEntrada){
        return diaEntrada.compareTo(LocalDate.now());
    }
}
