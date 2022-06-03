package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }


    /**
     * test for delete function
     */

    @Test
    public void deleteTest()
    {
        CityList li=new CityList();
        City cityname =new City("Dhaka","Khilgaon");
        li.add(cityname);
        li.delete(cityname);
        assertEquals(false,li.getCities().contains(cityname));
    }


    /**
     * test for throw exception
     */

    @Test
    public void DeleteExceptionTest()
    {
        CityList li = new CityList();
        City cityname = new City("Dhaka","Khilgaon");
        assertThrows(IllegalArgumentException.class,() -> {
            li.delete(cityname);
        });
    }


    /**
     * test for count function
     */

    @Test
    public void CountTest()
    {
        CityList li = new CityList();
        City cityname = new City("Dhaka","Khilgaon");
        li.add(cityname);
        assertEquals(1,li.count());
    }


    /**
     * test for sort function
     */

    @Test
    public void SortTest()
    {
        CityList li = new CityList();
        City cityname1 = new City("Dhaka","Khilgaon");
        li.add(cityname1);

        City cityname2 =new City("Khulna","Mongla");
        li.add(cityname2);

        assertEquals(cityname1, li.getCities(false).get(0));
    }
}
