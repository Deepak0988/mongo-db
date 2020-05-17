package com.learning.mongotest.repository;

import com.learning.mongotest.model.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface AppUserRepo extends MongoRepository<AppUser,Long> {

}
