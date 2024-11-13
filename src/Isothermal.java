public class Isothermal extends AbstractPBR {
    private double temperature;
    public Isothermal (double[] inputProperties, double temperature) {
        super(inputProperties);
        this.temperature = temperature;
    }

    public double calculateDXDW(double weight) {
        double g_X = 0.0;
        return g_X;
    }

    public double calculateDPDW(double weight) {
        double g_P = 0.0;
        return g_P;
    }

    public double getTemperature() {
        return inputProperties [2];
    }
}
