package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     *
     * @param city This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     *
     * @return Return the sorted list of cities
     */
    public List<City> getCities() {
        List<City> cityList = cities;
        Collections.sort(cityList);
        return cityList;
    }

    /**
     * function to delete cities
     * @param city
     */

    public void delete(City city)
    {
        if(cities.contains(city))
        {
            cities.remove(city);
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    /**
     * function to count city numbers
     * @return integer
     */
    public int count()
    {
        return cities.size();
    }

    /**
     * function to sort the cities by cityname or province name
     * @param isCity
     * @return sorted list
     */
    public List<City> getCities(boolean isCity)
    {
        List<City> cityList = cities;
        if(isCity == true)
        {
            Collections.sort(cityList);
        }
        else
        {
            Collections.sort(cityList, new Comparator<City>()
            {
                @Override
                public int compare(City city, City t1)
                {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }
        return cityList;
    }
}
