package com.geng.entity;

public class StudentDO {
    private  Integer id;
    private  String Name;
    private  String Number;
    private  String Home;
    private  Double Chinese;
    private  Double Math;
    private  Double English;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        this.Number = number;
    }

    public String getHome() {
        return Home;
    }

    public void setHome(String home) {
        this.Home = home;
    }

    public Double getChinese() {
        return Chinese;
    }

    public void setChinese(Double chinese) {
        this.Chinese = chinese;
    }

    public Double getMath() {
        return Math;
    }

    public void setMath(Double math) {
        this.Math = math;
    }

    public Double getEnglish() {
        return English;
    }

    public void setEnglish(Double english) {
        this.English = english;
    }
}
