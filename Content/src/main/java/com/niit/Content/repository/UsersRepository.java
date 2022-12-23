package com.niit.Content.repository;


import com.niit.Content.domain.Content;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<Content,String> {
    Content findByContentId(String contentId);
}
