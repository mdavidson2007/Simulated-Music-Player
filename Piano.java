
public class Piano extends StringedInstrument{
    public Piano(){
        super(36);
    }
    public Piano(int numWires){
        super(numWires, 88, 0, 36);
    }
    @Override
    public Wire createWire(int wireNum){
        PianoWire newPianoWire = new PianoWire(wireNum);
        return newPianoWire;
    }
}
