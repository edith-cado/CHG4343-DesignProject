public class Isothermal extends AbstractPBR {
    private double temperature;
    public Isothermal (double[] inputProperties, double temperature) {
        super(inputProperties);
        this.temperature = temperature;
    }

    public double calculateDXDW(double weight) {
        double conversion = 0.0;
        return conversion;
    }

    public double calculateDPDW(double weight) {
        double pressureDrop = 0.0;
        return pressureDrop;
    }

    public double getTemperature() {
        return temperature;
    }
}
