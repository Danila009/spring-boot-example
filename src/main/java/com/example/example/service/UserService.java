package com.example.example.service;

import com.example.example.dto.UserDTO;
import com.example.example.entities.UserEntity;
import com.example.example.exception.UserAlreadyExistException;
import com.example.example.exception.UserNotFoundException;
import com.example.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new UserAlreadyExistException("Пользователь с таким Email уже существует");
        }
        return userRepository.save(user);
    }

    public Iterable<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public UserDTO getById(Long id) throws UserNotFoundException {
        Optional<UserEntity> user =  userRepository.findById(id);

        if (user.isEmpty()){
            throw new UserNotFoundException("Пользователь не найден");
        }

        return UserDTO.toDTO(user.get());
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
