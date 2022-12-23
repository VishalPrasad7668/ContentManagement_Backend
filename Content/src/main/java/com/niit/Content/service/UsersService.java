package com.niit.Content.service;

import com.niit.Content.domain.Content;

import com.niit.Content.exception.ContentAlreadyExistsException;
import com.niit.Content.exception.ContentNotFoundException;
import com.niit.Content.exception.UserAlreadyExistsException;
import com.niit.Content.exception.UserNotFoundException;

import java.util.List;

public interface UsersService {
//    public Users addUser(Users user) throws UserAlreadyExistsException;
    public Content addContentForUser(Content content) throws ContentAlreadyExistsException, UserNotFoundException;
    public List<Content> getAllContentOfUser() throws UserNotFoundException;

    public boolean deleteContentById(String contentId);
    public String updateContent(Content content) throws ContentNotFoundException;

}
