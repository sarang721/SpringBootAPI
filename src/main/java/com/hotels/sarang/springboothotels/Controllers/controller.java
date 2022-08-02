package com.hotels.sarang.springboothotels.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hotels.sarang.springboothotels.Services.HotelService;
import com.hotels.sarang.springboothotels.models.Hotel;
import com.hotels.sarang.springboothotels.models.Search;

@RestController
public class controller {

    @Autowired
    public HotelService hotelService;

    @PostMapping("/add")
    public void addHotel(@RequestBody Hotel hotel)
    { 

        this.hotelService.addHotel(hotel);
    }

    @GetMapping("/getHotels")
    public List<Hotel> getHotel()
    {
        return this.hotelService.getHotels();
    }


    @DeleteMapping("/deleteHotel/{id}")
    public void delete(@PathVariable("id") int id)
    {
        this.hotelService.deleteHotel(id);
    }

    @GetMapping("/getHotel")
    public Hotel get(@RequestBody Search search)
    {
        return this.hotelService.getHotel(search);
    }


    @GetMapping("/getHotelBetween")
    public Hotel gethotelbetween(@RequestBody Search search)
    {
        return this.hotelService.getHotelBetween(search);
    }


}
