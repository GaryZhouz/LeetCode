package com.wzz.other.steamApiTrain;

/**
 * @Date 2021/3/17 15:35
 * @created by wzz
 */
public class Trader{
    private String name;
    private String city;


    public Trader() {
    }
    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
