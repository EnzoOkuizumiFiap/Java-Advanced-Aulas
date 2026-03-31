package br.com.fiap.ecommerce.service;

import br.com.fiap.ecommerce.entity.User;
import br.com.fiap.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

//    @Autowired -> Deixa muito acoplado
//    private UserRepository userRepository; Injeção de Dependência... Ela não é recomendada...

    //Também é uma Injeção de Dependência... É possível usar Lombok ao invés de digitar tudo isso!
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
