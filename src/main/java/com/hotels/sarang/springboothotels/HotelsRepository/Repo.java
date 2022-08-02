package com.hotels.sarang.springboothotels.HotelsRepository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.hotels.sarang.springboothotels.models.Hotel;

public interface Repo  extends MongoRepository<Hotel,Integer>{

    @Query("{id :?0}")                                                  
    Hotel getHotelById(int id);

    @Query("{name:?0}")
    Hotel getHotelsByName(String name);
    
    
}
