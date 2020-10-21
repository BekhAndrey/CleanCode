package plane;

import model.ClassificationLevel;
import model.ExperimentalPlaneType;

public class ExperimentalPlane extends Plane{

    private ExperimentalPlaneType experimentalType;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String planeModel, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalPlaneType experimentalType, ClassificationLevel classificationLevel) {
        super(planeModel, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = experimentalType;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + planeModel + '\'' +
                '}';
    }
}
