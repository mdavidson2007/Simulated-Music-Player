public class ElectricPiano extends Piano{
    public ElectricPiano(){
        super();
    }
    public ElectricPiano(int numWires){
        super(numWires);
    }
    @Override
    public Wire createWire(int wireNum){
        SimulatedWire newElectricWire = new SimulatedWire(wireNum);
        return newElectricWire;
    }
}