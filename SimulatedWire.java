

public class SimulatedWire extends Wire{
    public SimulatedWire(int wireNum){
        super(wireNum, 0.996);
    }
    @Override
    public double generateValue(int index, int wireLength){
        double first = index % (wireLength / 2);
        double second = wireLength / 4;
        
        if (first < second){
            return 0.5;
        } else{
            return -0.5;
        }
    }
}