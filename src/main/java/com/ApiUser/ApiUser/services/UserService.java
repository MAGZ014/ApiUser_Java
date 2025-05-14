package com.ApiUser.ApiUser.services;

import com.ApiUser.ApiUser.models.User;
import com.ApiUser.ApiUser.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    // Listar usuario
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    // Crear usuario
    public User createUser(User user){
        return userRepository.save(user);
    }

    // Eliminar usuario por Id
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Actualizar usuario
    public User updateUserData(Long id, User dataUpdate) {
        User userExists = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        userExists.setName(dataUpdate.getName());
        userExists.setEmail(dataUpdate.getEmail());
        userExists.setAge(dataUpdate.getAge());
        userExists.setPhone(dataUpdate.getPhone());

        return userRepository.save(userExists);
    }
}
