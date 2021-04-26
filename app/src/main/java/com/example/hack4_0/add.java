package com.example.hack4_0;

public class add {
    private String name,address,latitude,longitude,phone,beds,test_kits;

    public add()
    {

    }
    public add(String name,String address,String latitude,String longitude,String phone,String beds,String test_kits)
    {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phone = phone;
        this.beds = beds;
        this.test_kits = test_kits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getTest_kits() {
        return test_kits;
    }

    public void setTest_kits(String test_kits) {
        this.test_kits = test_kits;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
