package igor_dev.CrmEvolution.service;

import igor_dev.CrmEvolution.model.Leads;
import igor_dev.CrmEvolution.repository.LeadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeadsService {

    @Autowired
    private LeadsRepository leadsRepository;

    public Leads createLead(Leads lead){
        return leadsRepository.save(lead);
    }

    public Optional<Leads> findLeadsById(Long id){
        return leadsRepository.findById(id);
    }



}
