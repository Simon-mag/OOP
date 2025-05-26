package Missions;

import Vehicles.SpaceVehicle;

public abstract class Mission {
    private String destination;
    private int durationDays;
    private String name;
    SpaceVehicle rocket;

    public Mission(String name){this.name = name;}
    public Mission(String destination, int durationDays, String name, SpaceVehicle rocket){
        this.destination = destination;
        this.durationDays = durationDays;
        this.name = name;
        this.rocket = rocket;
    }

    public void performMission(){}

    public String getDestination() {return destination;}
    public int getDurationDays() {return durationDays;}
    public String getName() {return name;}
    public SpaceVehicle getRocket() {return rocket;}

    public void setName(String name) {this.name = name;}

}
