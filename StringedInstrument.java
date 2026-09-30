import java.util.ArrayList;
public class StringedInstrument{
    private ArrayList<Wire> wires = new ArrayList<Wire>();
    
    public ArrayList<Wire> getWires(){
        return wires;
    }
    public void addWire(Wire newWire){
        wires.add(newWire);
    }
    public Wire createWire(int wireNum){
        Wire newWire = new Wire(wireNum);
        return newWire;
    }
    public void setWires(int numWires){
        this.wires = new ArrayList<Wire>();
        for (int i=0; i<numWires; i++){
            Wire newWire = createWire(i);
            this.wires.add(newWire);
        }
    }
    public StringedInstrument(){
        ArrayList<Wire> wiresList = new ArrayList<Wire>();
    }
    public StringedInstrument(int numWires){
        setWires(numWires);
    }
    public StringedInstrument(int numWires, int maxWires, int minWires, int defaultNum){
        if (numWires >= minWires && numWires <= maxWires){
            setWires(numWires);
        } else{
            setWires(defaultNum);
        }
    }
    public boolean strikeWire(int wireNum){
        if (wireNum>=0 && wireNum < wires.size()){
            Wire currentWire = wires.get(wireNum);
            currentWire.strike();
            return true;
        } else{
            return false;
        }
    }
    public double calculateSampleFromWires(){
        double sum = 0.0;
        for (Wire w: wires){
            double val = w.sample();
            sum+=val;
        }
        return sum;
    }
    public void play(){
        double sampleVal = calculateSampleFromWires();
        StdAudio.play(sampleVal);
    }
}