package igor_dev.CrmEvolution.dto;

import igor_dev.CrmEvolution.model.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(

        @NotBlank(message = "O campo 'name' não pode ser vazio")
        String name,

        @NotBlank(message = "O campo 'nickname' não pode ser vazio")
        String nickname,

        @NotBlank(message = "O campo 'email' não pode ser vazio")
        Email email,

        @NotBlank(message = "O campo 'senha' não pode ser vazio")
        String senha
) {
}
