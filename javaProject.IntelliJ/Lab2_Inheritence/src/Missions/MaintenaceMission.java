package Missions;

import DefaultPackage.Delay;
import Vehicles.SpaceVehicle;

public class MaintenaceMission extends Mission {

    public MaintenaceMission(String name){super(name);}
    public MaintenaceMission(String destination, int durationDays, String name, SpaceVehicle rocket) {
        super(destination, durationDays, name, rocket);
    }

    @Override
    public void performMission(){
        Delay.slowOut("Performing maintenance on " + getDestination() + " for " + getDurationDays() + " days...");
    }
}
