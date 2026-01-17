package igor_dev.CrmEvolution.service;

import igor_dev.CrmEvolution.dto.LeadResponseDTO;
import igor_dev.CrmEvolution.model.Lead;
import igor_dev.CrmEvolution.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeadsService {

    @Autowired
    private LeadRepository leadsRepository;
    private LeadResponseDTO leadResponseDTO;

    public Lead createLead(Lead lead){
        return leadsRepository.save(lead);
    }

    public Optional<Lead> findLeadsById(Long id){
        return leadsRepository.findById(id);
    }



}
