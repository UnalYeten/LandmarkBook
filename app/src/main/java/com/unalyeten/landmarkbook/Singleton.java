package com.unalyeten.landmarkbook;

public class Singleton {

    private Landmark landmark;
    private static Singleton singleton;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if (singleton == null)
            singleton = new Singleton();

        return singleton;
    }

    public Landmark getLandmark(){
        return this.landmark;
    }

    public void setLandmark(Landmark landmark){
        this.landmark = landmark;
    }

}
