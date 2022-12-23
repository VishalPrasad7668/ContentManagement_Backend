package com.niit.UserAuthentication.service;

import com.niit.UserAuthentication.domain.UserModel;
import com.niit.UserAuthentication.exception.UserAlreadyExistException;
import com.niit.UserAuthentication.exception.UserNotFoundException;

import com.niit.UserAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{

    private UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public UserModel addUser(UserModel user) throws UserAlreadyExistException {
        if (userRepository.findById(user.getEmailId()).isPresent()) {
            throw new UserAlreadyExistException();
        }
        UserModel users = userRepository.save(user);

        return users;

    }

    @Override
    public UserModel loginCheck(String email, String userPassword) throws UserNotFoundException
    {
        UserModel user = userRepository.findByEmailIdAndPassword(email,userPassword);
        if(user!=null){ //authentication is ok
            return user;
        }
        else{ // authentication failed
            throw new UserNotFoundException();
        }


    }
}
