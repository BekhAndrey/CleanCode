import plane.ExperimentalPlane;
import model.MilitaryPlaneType;
import plane.MilitaryPlane;
import plane.PassengerPlane;
import plane.Plane;

import java.util.*;

public class Airport {
    private List<? extends Plane> allPlanesList;

    public Airport(List<? extends Plane> planes) {
        this.allPlanesList = planes;
    }

    public List<PassengerPlane> getPassengerPlanesList() {
        List<? extends Plane> allPlanesList = this.allPlanesList;
        List<PassengerPlane> passengerPlanesList = new ArrayList<>();
        for (Plane plane : allPlanesList) {
            if (plane instanceof PassengerPlane) {
                passengerPlanesList.add((PassengerPlane) plane);
            }
        }
        return passengerPlanesList;
    }

    public List<MilitaryPlane> getMilitaryPlanesList() {
        List<MilitaryPlane> militaryPlanesList = new ArrayList<>();
        for (Plane plane : allPlanesList) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanesList.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanesList;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanesList();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanesList() {
        List<MilitaryPlane> transportMilitaryPlanesList = new ArrayList<>();
        List<MilitaryPlane> militaryPlanesList = getMilitaryPlanesList();
        for (int i = 0; i < militaryPlanesList.size(); i++) {
            if (militaryPlanesList.get(i).getMilitaryType() == MilitaryPlaneType.TRANSPORT) {
                transportMilitaryPlanesList.add(militaryPlanesList.get(i));
            }
        }
        return transportMilitaryPlanesList;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanesList() {
        List<MilitaryPlane> bomberMilitaryPlanesList = new ArrayList<>();
        List<MilitaryPlane> militaryPlanesList = getMilitaryPlanesList();
        for (int i = 0; i < militaryPlanesList.size(); i++) {
            if (militaryPlanesList.get(i).getMilitaryType() == MilitaryPlaneType.BOMBER) {
                bomberMilitaryPlanesList.add(militaryPlanesList.get(i));
            }
        }
        return bomberMilitaryPlanesList;

    }

    public List<ExperimentalPlane> getExperimentalPlanesList() {
        List<ExperimentalPlane> experimentalPlanesList = new ArrayList<>();
        for (Plane plane : allPlanesList) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanesList.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanesList;
    }

    public Airport sortPlanesByMaxDistance() {
        Collections.sort(allPlanesList, new Comparator<Plane>() {
            public int compare(Plane firstPlane, Plane secondPlane) {
                return firstPlane.getMaxFlightDistance() - secondPlane.getMaxFlightDistance();
            }
        });
        return this;
    }
    
    public Airport sortPlanesByMaxSpeed() {
        Collections.sort(allPlanesList, new Comparator<Plane>() {
            public int compare(Plane firstPlane, Plane secondPlane) {
                return firstPlane.getMaxSpeed() - secondPlane.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortPlanesByMaxLoadCapacity() {
        Collections.sort(allPlanesList, new Comparator<Plane>() {
            public int compare(Plane firstPlane, Plane secondPlane) {
                return firstPlane.getMaxLoadCapacity() - secondPlane.getMaxLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getAllPlanesList() {
        return allPlanesList;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + allPlanesList.toString() +
                '}';
    }

}
