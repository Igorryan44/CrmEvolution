package igor_dev.CrmEvolution.controller;

import igor_dev.CrmEvolution.dto.LeadRequestDTO;
import igor_dev.CrmEvolution.dto.LeadResponseDTO;
import igor_dev.CrmEvolution.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/leads")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @PostMapping
    @Valid
    public ResponseEntity<LeadResponseDTO> createLead(@Valid @RequestBody LeadRequestDTO lead){
        LeadResponseDTO response = leadService.save(lead);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LeadResponseDTO>> getLead(@PathVariable Long id){
        return ResponseEntity.ok(leadService.findById(id));
    }

    @GetMapping
    @Valid
    public ResponseEntity<List<LeadResponseDTO>> getAllLeads(){
        return ResponseEntity.ok(leadService.getAllLeads());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        leadService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeadResponseDTO> updateLead(@Valid @RequestBody LeadRequestDTO lead, @PathVariable Long id){
        return ResponseEntity.ok(leadService.updateLead(lead, id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<LeadResponseDTO>> getAllLeadStatus(@PathVariable String status){
        return ResponseEntity.ok(leadService.getLeadByStatus(status));
    }

    @PutMapping("/status/{id}/update")
    public ResponseEntity<LeadResponseDTO> updateLeadStatus(@PathVariable Long id, @Valid @RequestBody String status){
        return ResponseEntity.ok(leadService.updateStatus(id, status));
    }

    @PutMapping("/segmento/{id}/segmento")
    public ResponseEntity<LeadResponseDTO> updateLeadSegmento(@PathVariable Long id, @Valid @RequestBody String segmento){
        return ResponseEntity.ok(leadService.updateSegmento(id, segmento));
    }

}
