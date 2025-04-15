package Missions;

import DefaultPackage.Delay;
import Vehicles.SpaceVehicle;

public class ExplorationMission extends Mission{

    public ExplorationMission(String destination, int durationDays, String name, SpaceVehicle rocket) {
        super(destination, durationDays, name, rocket);
    }

    @Override
        public void performMission(){
        Delay.slowOut("Exploring " + getDestination() + " for " + getDurationDays() + " days...");
        }
}
