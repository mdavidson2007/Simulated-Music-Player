

public class Harpsichord extends StringedInstrument{
    public Harpsichord(){
        super(48);
    }
    public Harpsichord(int numWires){
        super(numWires, 60, 0, 48);
    }
    @Override
    public Wire createWire(int wireNum){
        HarpsichordWire newHarpWire = new HarpsichordWire(wireNum);
        return newHarpWire;
    }
}