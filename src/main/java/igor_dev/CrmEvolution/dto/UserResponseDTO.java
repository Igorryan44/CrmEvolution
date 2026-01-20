package igor_dev.CrmEvolution.dto;

import jakarta.validation.constraints.NotBlank;

public record UserResponseDTO(
        Long id,
        String name,
        String nickname,
        String email,
        String senha
) {
}
