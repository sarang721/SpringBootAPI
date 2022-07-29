package com.hotels.sarang.springboothotels.HotelsRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotels.sarang.springboothotels.models.Hotel;

public interface Repo  extends MongoRepository<Hotel,Integer>{
    
    
}
