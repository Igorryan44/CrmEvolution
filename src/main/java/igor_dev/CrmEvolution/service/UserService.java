package igor_dev.CrmEvolution.service;

import igor_dev.CrmEvolution.dto.UserRequestDTO;
import igor_dev.CrmEvolution.dto.UserResponseDTO;
import igor_dev.CrmEvolution.mapper.UserMapper;
import igor_dev.CrmEvolution.model.User;
import igor_dev.CrmEvolution.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private UserMapper mapper;

    public UserResponseDTO save(UserRequestDTO userRequest) {
        return mapper.toUserResponseDTO(userRepository.save(mapper.toUserEntity(userRequest)));
    }

    public List<UserResponseDTO> findAll() {
        return mapper.toUserResponseDTO(userRepository.findAll());

    }

    public Optional<UserResponseDTO> findById(Long id) {
        User entity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));
        return Optional.ofNullable(mapper.toUserResponseDTO(entity));
    }

    public void delete(Long id) {
        User entity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));
        userRepository.delete(entity);
    }
}
