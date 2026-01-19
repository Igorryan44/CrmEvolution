package igor_dev.CrmEvolution.service;

import igor_dev.CrmEvolution.dto.LeadRequestDTO;
import igor_dev.CrmEvolution.dto.LeadResponseDTO;
import igor_dev.CrmEvolution.mapper.LeadMapper;
import igor_dev.CrmEvolution.model.Lead;
import igor_dev.CrmEvolution.repository.LeadRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LeadsService {

    @Autowired
    private LeadRepository leadsRepository;
    private LeadMapper mapper;

    public LeadResponseDTO save(LeadRequestDTO leadRequest){
        return mapper.toLeadResponseDTO(leadsRepository.save(mapper.toLeadEntity(leadRequest)));
    }

    public Optional<Lead> findLeadsById(Long id){
        return leadsRepository.findById(id);
    }

    public Optional<LeadResponseDTO> findById(Long id) {
        Lead entity = leadsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lead não encontrado!"));
        return Optional.ofNullable(mapper.toLeadResponseDTO(entity));
    }

    public void delete(Long id) {
        Lead entity = leadsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lead não encontrado!"));
        leadsRepository.delete(entity);
    }

}
