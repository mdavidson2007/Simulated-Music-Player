import java.util.Queue;
import java.util.LinkedList;
public class Wire
{
    private double decayRate;
    private Queue<Double> noteQueue;
    private int wireNum;
    
    public double getDecayRate(){
        return decayRate;
    }
    public Queue<Double> getNoteQueue(){
        return noteQueue;
    }
    public int getWireNum(){
        return wireNum;
    }
    public int calculateWireLength(int wireNum){
        double length = StdAudio.SAMPLE_RATE*Math.pow(2, (22-wireNum)/12.0)/440;
        return (int)length;
    }
    public void buildWire(int wireLength){
        this.noteQueue = new LinkedList<Double>();
        for (int i = 0; i<wireLength; i++){
            this.noteQueue.add(0.0);
        }
    }
    public Wire(){
        wireNum = 0;
        int length = calculateWireLength(wireNum);
        buildWire(length);
        decayRate = 0.995;
    }
    public Wire(int inputWireNum){
        wireNum = inputWireNum;
        int length = calculateWireLength(inputWireNum);
        buildWire(length);
        decayRate = 0.995;
    }
    public Wire(int inputWireNum, double inputDecayRate){
        wireNum = inputWireNum;
        int length = calculateWireLength(inputWireNum);
        buildWire(length);
        decayRate = inputDecayRate;
    }
    public double generateValue(int index, int wireLength){
        double randomVal = Math.random();
        randomVal -= 0.5;
        return randomVal;
    }
    public void strike(){
        int wireLength = noteQueue.size();
        for (int i=0; i<wireLength; i++){
            noteQueue.remove();
            double newVal = generateValue(i, wireLength);
            noteQueue.add(newVal);
            
        }
    }
    public double sample(){
        double firstVal = noteQueue.remove();
        double secondVal = noteQueue.peek();
        double avg = (firstVal+secondVal)/2;
        double newVal = avg*decayRate;
        noteQueue.add(newVal);
        return firstVal;
    }
}