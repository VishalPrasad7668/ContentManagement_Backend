package com.niit.Content.controller;

import com.niit.Content.domain.Content;

import com.niit.Content.exception.ContentAlreadyExistsException;
import com.niit.Content.exception.ContentNotFoundException;
import com.niit.Content.exception.UserAlreadyExistsException;
import com.niit.Content.exception.UserNotFoundException;
import com.niit.Content.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content/")
//@CrossOrigin(origins = "http://localhost:4200/")
public class UsersController {

    private UsersService usersService;
    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/dashboard")
    public ResponseEntity<?> addContentToTheUser( @RequestBody Content content) throws UserNotFoundException, ContentAlreadyExistsException {
        try {
            return new ResponseEntity<>(usersService.addContentForUser(content), HttpStatus.OK);
        }catch (UserNotFoundException e){
            throw new UserNotFoundException();
        }catch (ContentAlreadyExistsException e){
            throw new ContentAlreadyExistsException();
        }
    }

    @GetMapping("/contents")
    public ResponseEntity<?> getContentFromUser() throws UserNotFoundException {
        try{
            return new ResponseEntity<>(usersService.getAllContentOfUser(),HttpStatus.OK);
        }catch (Exception e){
            throw new UserNotFoundException();
        }
    }
    @DeleteMapping("/delete/{contentId}")
    public ResponseEntity<?> deleteContentById(@PathVariable String contentId){
        return new ResponseEntity<>(usersService.deleteContentById(contentId),HttpStatus.OK);

    }
    @PostMapping("/edit")
    public ResponseEntity<?> editContent( @RequestBody Content content) throws ContentNotFoundException {
        return new ResponseEntity<>(usersService.updateContent(content),HttpStatus.OK);

    }
}
