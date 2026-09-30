import java.util.Queue;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        testWire();
        testWireSubclasses();
        testStringedInstrument();
        testInstrumentSubclasses();
    }

    public static void testWire() {
        System.out.println("=== Testing Wire ===");

        Wire w = new Wire();

        System.out.println("Default wireNum: " + w.getWireNum());
        System.out.println("Default decayRate: " + w.getDecayRate());
        System.out.println("Default queue size: " + w.getNoteQueue().size());

        System.out.println("calculateWireLength(0): " + w.calculateWireLength(0));
        System.out.println("Expected: 357");

        System.out.println("calculateWireLength(12): " + w.calculateWireLength(12));
        System.out.println("Expected: 178");

        int beforeStrikeSize = w.getNoteQueue().size();
        w.strike();
        int afterStrikeSize = w.getNoteQueue().size();

        System.out.println("Queue size before strike: " + beforeStrikeSize);
        System.out.println("Queue size after strike: " + afterStrikeSize);

        System.out.println("First few values after strike:");
        printFirstFewValues(w.getNoteQueue(), 10);

        double sampleValue = w.sample();
        System.out.println("Sample returned: " + sampleValue);
        System.out.println("Queue size after sample: " + w.getNoteQueue().size());

        System.out.println();
    }

    public static void testWireSubclasses() {
        System.out.println("=== Testing Wire Subclasses ===");

        PianoWire pw = new PianoWire(0);
        pw.strike();
        System.out.println("PianoWire decay rate: " + pw.getDecayRate());
        System.out.println("Expected: 0.996");
        System.out.println("First few PianoWire values:");
        printFirstFewValues(pw.getNoteQueue(), 10);

        SimulatedWire sw = new SimulatedWire(0);
        sw.strike();
        System.out.println("SimulatedWire decay rate: " + sw.getDecayRate());
        System.out.println("Expected: 0.996");
        System.out.println("First few SimulatedWire values:");
        printFirstFewValues(sw.getNoteQueue(), 10);

        HarpsichordWire hw = new HarpsichordWire(0);
        hw.strike();
        System.out.println("HarpsichordWire decay rate: " + hw.getDecayRate());
        System.out.println("Expected: 0.984");
        System.out.println("First few HarpsichordWire values:");
        printFirstFewValues(hw.getNoteQueue(), 10);

        System.out.println();
    }

    public static void testStringedInstrument() {
        System.out.println("=== Testing StringedInstrument ===");

        StringedInstrument emptyInstrument = new StringedInstrument();
        System.out.println("Default instrument wires: " + emptyInstrument.getWires().size());
        System.out.println("Expected: 0");

        StringedInstrument instrument = new StringedInstrument(5);
        System.out.println("Custom instrument wires: " + instrument.getWires().size());
        System.out.println("Expected: 5");

        System.out.println("Wire numbers:");
        for (int i = 0; i < instrument.getWires().size(); i++) {
            System.out.println("Wire " + i + " wireNum: " + instrument.getWires().get(i).getWireNum());
        }

        System.out.println("strikeWire(2): " + instrument.strikeWire(2));
        System.out.println("Expected: true");

        System.out.println("strikeWire(-1): " + instrument.strikeWire(-1));
        System.out.println("Expected: false");

        System.out.println("strikeWire(5): " + instrument.strikeWire(5));
        System.out.println("Expected: false");

        double sampleSum = instrument.calculateSampleFromWires();
        System.out.println("calculateSampleFromWires returned: " + sampleSum);

        System.out.println("Calling play once...");
        instrument.play();

        System.out.println();
    }

    public static void testInstrumentSubclasses() {
        System.out.println("=== Testing Instrument Subclasses ===");
        
        
        
        Piano defaultPiano = new Piano();
        System.out.println("Default Piano wires: " + defaultPiano.getWires().size());
        System.out.println("Expected: 36");
        
        Piano zeroPiano = new Piano(0);
        System.out.println("Piano(0) wires: " + zeroPiano.getWires().size());
        System.out.println("Expected: 0");

        Piano validPiano = new Piano(88);
        System.out.println("Piano(88) wires: " + validPiano.getWires().size());
        System.out.println("Expected: 88");

        Piano invalidPiano = new Piano(100);
        System.out.println("Piano(100) wires: " + invalidPiano.getWires().size());
        System.out.println("Expected: 36");

        if (defaultPiano.getWires().size() > 0) {
            System.out.println("Default Piano first wire is PianoWire: " +
                (defaultPiano.getWires().get(0) instanceof PianoWire));
            System.out.println("Expected: true");
        }

        Harpsichord defaultHarpsichord = new Harpsichord();
        System.out.println("Default Harpsichord wires: " + defaultHarpsichord.getWires().size());
        System.out.println("Expected: 48");
        
        Harpsichord zeroHarp = new Harpsichord(0);
        System.out.println("Harp(0) wires: " + zeroHarp.getWires().size());
        System.out.println("Expected: 0");

        Harpsichord validHarpsichord = new Harpsichord(60);
        System.out.println("Harpsichord(60) wires: " + validHarpsichord.getWires().size());
        System.out.println("Expected: 60");

        Harpsichord invalidHarpsichord = new Harpsichord(70);
        System.out.println("Harpsichord(70) wires: " + invalidHarpsichord.getWires().size());
        System.out.println("Expected: 48");

        if (defaultHarpsichord.getWires().size() > 0) {
            System.out.println("Default Harpsichord first wire is HarpsichordWire: " +
                (defaultHarpsichord.getWires().get(0) instanceof HarpsichordWire));
            System.out.println("Expected: true");
        }

        ElectricPiano defaultElectricPiano = new ElectricPiano();
        System.out.println("Default ElectricPiano wires: " + defaultElectricPiano.getWires().size());
        System.out.println("Expected: 36");
        
        Piano zeroElectricPiano = new ElectricPiano(0);
        System.out.println("Electric Piano(0) wires: " + zeroElectricPiano.getWires().size());
        System.out.println("Expected: 0");

        ElectricPiano validElectricPiano = new ElectricPiano(88);
        System.out.println("ElectricPiano(88) wires: " + validElectricPiano.getWires().size());
        System.out.println("Expected: 88");

        ElectricPiano invalidElectricPiano = new ElectricPiano(100);
        System.out.println("ElectricPiano(100) wires: " + invalidElectricPiano.getWires().size());
        System.out.println("Expected: 36");

        if (defaultElectricPiano.getWires().size() > 0) {
            System.out.println("Default ElectricPiano first wire is SimulatedWire: " +
                (defaultElectricPiano.getWires().get(0) instanceof SimulatedWire));
            System.out.println("Expected: true");
        }

        System.out.println();
    }

    public static void printFirstFewValues(Queue<Double> queue, int amount) {
        int count = 0;

        for (Double value : queue) {
            if (count >= amount) {
                break;
            }

            System.out.println(value);
            count++;
        }
    }
}