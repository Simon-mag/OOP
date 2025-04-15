package Vehicles;

import DefaultPackage.Delay;

public class Rocket implements SpaceVehicle{

    @Override
    public void launch() {
        Delay.slowOut("Igniting thrusters, Prepare for takeoff!");
    }

    @Override
    public void land() {
        Delay.slowOut("Scanning for suitable landing area, Fasten belts!");
    }

    @Override
    public void transportCrew() {
        Delay.slowOut("In transit with crew!");
    }
}
