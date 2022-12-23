package com.niit.Content.service;

import com.niit.Content.domain.Content;

import com.niit.Content.exception.ContentAlreadyExistsException;
import com.niit.Content.exception.ContentNotFoundException;
import com.niit.Content.exception.UserAlreadyExistsException;
import com.niit.Content.exception.UserNotFoundException;
import com.niit.Content.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
@Service
public class UserServiceImpl implements UsersService{

    private UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

//    @Override
//    public Users addUser(Users user) throws UserAlreadyExistsException {
////        if (usersRepository.findById(user.getEmailId()).isPresent()){
////            throw new UserAlreadyExistsException();
////        }
////        Users user1 = usersRepository.save(user);
////        return user1;
//        return null;
//    }

    @Override
    public Content addContentForUser(Content content)  {

        return usersRepository.save(content);
    }

    @Override
    public List<Content> getAllContentOfUser()  {

        return usersRepository.findAll();

    }

    @Override
    public boolean deleteContentById(String contentId) {
        boolean response = true;
        if (usersRepository.findById(contentId).isEmpty()){
            response = false;
        }
        usersRepository.deleteById(contentId);
        return response;
    }

    @Override
    public String updateContent(Content content) throws ContentNotFoundException {

        usersRepository.save(content);
        return "Content edited";
    }
}
