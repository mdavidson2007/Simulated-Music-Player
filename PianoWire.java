public class PianoWire extends Wire{
    public PianoWire(int wireNum){
        super(wireNum, 0.996);
    }
    @Override
    public double generateValue(int index, int wireLength){
        return Math.sin(index/(Math.PI*wireLength/2))-0.5;
    }
}