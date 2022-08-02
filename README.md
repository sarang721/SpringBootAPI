# SpringBootAPI

1 Add Hotels

POST localhost:8080/add
{
  "id":1,
  "name":"Miami Beach",
  "weekDayPrice":80,
  "weekendPrice":110,
  "isAvailable":true
}


2 Get Hotels

GET localhost:8080/getHotels

3 Get Cheapest Hotel for One day 

GET localhost:8080/getHotel

{
    "fromdate":"29-07-2022",
    "todate":""
}


4 Get Cheapest Hotel Between

GET localhost:8080/getHotelBetween

{
  "fromdate":"2022-07-20", //YY-MM-DD
  "todate":"2022-07-29"
}


5 DELETE localhost:8080/deleteHotel/{id}





