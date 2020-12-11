package model;

import lib.Vehicle;
import java.util.List;

public interface Observer {

    void stateUpdated(List<Vehicle> newState);

}