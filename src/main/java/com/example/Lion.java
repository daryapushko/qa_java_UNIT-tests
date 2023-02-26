package com.example;

import java.util.List;

public class Lion{
    private IFeline feline;
    boolean hasMane;

    public Lion(IFeline feline){
        this.feline = feline;
    }

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public List<String> getFood(String animalKind) throws Exception {
        return feline.getFood("Хищник");
    }
}
