package com.hotels.sarang.springboothotels.Services;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.time.temporal.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.hotels.sarang.springboothotels.HotelsRepository.Repo;
import com.hotels.sarang.springboothotels.models.Hotel;
import com.hotels.sarang.springboothotels.models.Search;

@Service
public class HotelService {


    @Autowired
    public Repo repo;

    public void addHotel(Hotel hotel)
    {
        
        repo.save(hotel);
    }

    public List<Hotel> getHotels()
    {
        List<Hotel> hotels=repo.findAll();
        return hotels;
    }

    public void deleteHotel(int id)
    {
        repo.deleteById(id);
    }


    public Hotel getHotelBetween(Search search)
    {
        List<Hotel> hotels=repo.findAll();
        LocalDate start = LocalDate.parse(search.getFromdate()); //YY-MM-DD
        LocalDate end = LocalDate.parse(search.getTodate());

        final int startW = start.getDayOfWeek().getValue();
        final int endW = end.getDayOfWeek().getValue();

    final long days = ChronoUnit.DAYS.between(start, end);
    long result = days - 2*(days/7); //remove weekends

    if (days % 7 != 0) { 
        if (startW == 7) {
            result -= 1;
        } else if (endW == 7) {  
            result -= 1;
        } else if (endW < startW) { 
            result -= 2;
        }
    }
    long weekends=days-result;
    long weekdays=days-weekends;
    System.out.println("Number of weekends "+ weekends);
    System.out.println("Number of weekdays "+ weekdays);


    long maxi=Integer.MAX_VALUE;
    Hotel finalHotel=null;
    for(Hotel hotel:hotels)
    {
        long totalprice=(hotel.getWeekdayPrice()*weekdays) + (hotel.getWeekendPrice() * weekends);
        if(totalprice<maxi)
        {
            maxi=totalprice;
            finalHotel=hotel;
        }
    }

    return finalHotel;


}

    public Hotel getHotel(Search search)
    {
        List<Hotel> hotels=repo.findAll();
        String[] arr=search.getFromdate().split("-");

        LocalDate localDate = LocalDate.of(Integer.parseInt(arr[2]),Integer.parseInt(arr[1]),Integer.parseInt(arr[0]));
        java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        String dayofweek=dayOfWeek.toString();
        //System.out.println(dayOfWeek);

        int day=0;
        if(dayofweek.equals("MONDAY") || dayofweek.equals("TUESDAY") || dayofweek.equals("WEDNESDAY") || dayofweek.equals("THURSDAY") || dayofweek.equals("FRIDAY"))
        day=1;


        Hotel hotel=null;
        
        if(day==1)
        {

            hotel = hotels.stream()
            .min(Comparator.comparingInt(Hotel::getWeekdayPrice))
            .get();

            return hotel;

        }
        else{

            hotel = hotels.stream()
            .min(Comparator.comparingInt(Hotel::getWeekendPrice))
            .get();


            return hotel;

        }
    }
    
}
