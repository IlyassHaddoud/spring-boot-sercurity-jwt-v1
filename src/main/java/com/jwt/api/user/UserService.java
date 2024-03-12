package com.jwt.api.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<User> getUsers()
    {
        return this.userRepository.findAll();
    }

    public Optional<User> login(String email)
    {
        return this.userRepository.getUserByEmail(email);
    }

    public User register(User user)
    {
        return this.userRepository.save(user);
    }

    public User convertToUser(UserLoginDTO userLoginDTO)
    {
        return this.modelMapper.map(userLoginDTO,User.class);
    }
}
