public abstract class AbstractPBR implements Function {
    protected double[] inputProperties;
    protected double g_X;
    protected double g_P;
    protected double temperature;
    protected ReactionParameters reactionParameters;
    protected Reaction rxn;

    // Constructor
    public AbstractPBR(double[] inputProperties, ReactionParameters reactionParameters,Reaction rxn) {
        this.inputProperties = inputProperties;
        this.g_X = 0.0;
        this.g_P = inputProperties[3]; // index 3
        this.temperature = inputProperties[2]; // index 2
        this.reactionParameters = reactionParameters;
        this.rxn = rxn;
    }
    //Copy Constructor
    public AbstractPBR(AbstractPBR source) {
        this.inputProperties = source.inputProperties.clone();
        this.g_X = source.g_X;
        this.g_P = source.g_P;
        this.temperature = source.temperature;
        this.reactionParameters = source.reactionParameters;
        this.rxn = source.rxn;
    }
    public abstract AbstractPBR clone();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractPBR other = (AbstractPBR) obj;
        return Double.compare(other.g_X, g_X) == 0 &&
                Double.compare(other.g_P, g_P) == 0 &&
                Double.compare(other.temperature, temperature) == 0 &&
                java.util.Arrays.equals(inputProperties, other.inputProperties);
    }

    public abstract double calculateDXDW(double weight);
    public abstract double calculateDPDW(double weight);
}

// Method to simulate the reactor using ODESolver



