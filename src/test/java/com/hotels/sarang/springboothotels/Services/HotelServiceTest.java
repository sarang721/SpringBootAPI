package com.hotels.sarang.springboothotels.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotels.sarang.springboothotels.HotelsRepository.Repo;
import com.hotels.sarang.springboothotels.models.Hotel;
import com.hotels.sarang.springboothotels.models.Search;


@SpringBootTest
public class HotelServiceTest {

    @Autowired
    private Repo repo;

    @Autowired 
    private HotelService service;

    @Test
    public void addHotels()
    {
        Hotel hotel=new Hotel();
        hotel.setId(20);
        hotel.setName("Tristar");

        hotel.setIsAvailable(true);
        hotel.setWeekdayPrice(100);
        hotel.setWeekendPrice(200);
        repo.save(hotel);
        assertNotNull(repo.getHotelById(20));
    }

    @Test
    public void getHotels()
    {

       
        
    }

    @Test
    public void getCheapest()
    {
        Hotel hotel=new Hotel();
        hotel.setId(20);
        hotel.setName("Tristar");

        hotel.setIsAvailable(true);
        hotel.setWeekdayPrice(0);
        hotel.setWeekendPrice(0);
        repo.save(hotel);

        String expectedName="Tristar";
        Search search=new Search();
        search.setFromdate("01-08-2022");
        search.setTodate(null);
        Hotel actualHotel=service.getHotel(search);

        String actualName=actualHotel.getName();

        assertEquals(expectedName, actualName);

    }


    @Test
    public void getCheapestBetween()
    {
        Hotel hotel=new Hotel();
        hotel.setId(20);
        hotel.setName("Tristar");

        hotel.setIsAvailable(true);
        hotel.setWeekdayPrice(0);
        hotel.setWeekendPrice(0);
        repo.save(hotel);  



        String expectedName="Tristar";
        Search search=new Search();
        search.setFromdate("2022-08-01");
        search.setTodate("2022-08-07");
        Hotel actualHotel=service.getHotelBetween(search);

        String actualName=actualHotel.getName();

        assertEquals(expectedName, actualName);


    }

    @Test
    public void delete()
    {
        repo.deleteById(20);
        assertEquals(null, repo.getHotelById(20));
    }





}
