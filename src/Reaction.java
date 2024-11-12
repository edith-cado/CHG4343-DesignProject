public class Reaction
{
    private ReactionParameters reactionParameters;

    //constructor
    public Reaction(ReactionParameters reactionParameters) {
        if (reactionParameters==null) System.exit(0);
        this.reactionParameters = reactionParameters;
    } //end of constructor

    //copy constructor
    public Reaction(Reaction source)
    {
        if(source==null) System.exit(0);
        this.reactionParameters = source.reactionParameters;
    } //end of copy constructor

    //clone
    public Reaction clone()
    {
        return new Reaction(this);
    } //end of clone

    //accessor
    public ReactionParameters getReactionParameters()
    {
        return this.reactionParameters;
    } //end of accessor

    //mutator
    public boolean setReactionParameters(ReactionParameters reactionParameters)
    {
        if (reactionParameters==null) return false;
        this.reactionParameters = reactionParameters;
        return true;
    } //end of mutator

    //equals
    public boolean equals (Object comparator)
    {
        if (comparator==null) return false;
        else if (this.getClass()!=comparator.getClass()) return false;
        else if (this.reactionParameters != ((Reaction)comparator).reactionParameters) return false;

        return true;
    } //end of equals



    public double calculateInitialTotalConcentration()
    {
        double C_T0 = reactionParameters.getInputProperties()[3]/(RateLaw.R*reactionParameters.getInputProperties()[2]);
        if (C_T0<0.) System.exit(0);
        return C_T0;
    }

    public double calculateInitialTotalFlowrate()
    {
        double F_0 = calculateInitialTotalConcentration()*reactionParameters.getInputProperties()[7];
        if (F_0<0.) System.exit(0);
        return F_0;
    }

    public double calculateInitialLimitantConcentration()
    {
        double C_A0 = calculateInitialTotalConcentration()*reactionParameters.getReactantMoleFraction()[0];
        if(C_A0<0.) System.exit(0);
        return C_A0;
    }

    public double [] calculateInitialReactantConcentration ()
    {
        double [] initialReactantConcentration = new double [reactionParameters.getReactantStoichiometry().length];
        for (int i = 0; i < initialReactantConcentration.length; i++)
            initialReactantConcentration[i] = calculateInitialTotalConcentration()*reactionParameters.getReactantMoleFraction()[i];
        return initialReactantConcentration;
    }

    public double [] calculateInitialReactantFlowrate ()
    {
        double [] initialReactantFlowrate = new double [reactionParameters.getReactantStoichiometry().length];
        for (int i = 0; i < initialReactantFlowrate.length; i++)
            initialReactantFlowrate[i] = calculateInitialTotalFlowrate()*reactionParameters.getReactantMoleFraction()[i];
        return initialReactantFlowrate;
    }




    public double calculateTotalFlowrate (double [] reactantFlowrate, double [] productFlowrate, double [] inertFlowrate)
    {
        double totalFlowrate=0.;

        for (int i = 0; i < reactantFlowrate.length; i++)
            totalFlowrate = reactantFlowrate[i];
        for (int i = 0; i < productFlowrate.length; i++)
            totalFlowrate += productFlowrate[i];
        for (int i = 0; i < inertFlowrate.length; i++)
            totalFlowrate += inertFlowrate[i];

        return totalFlowrate;
    }

    public double [] calculateReactantConcentration (double [] reactantFlowrate, double [] productFlowrate, double [] inertFlowrate, double T, double P)
    {
        double [] reactantConcentration = new double [reactantFlowrate.length];
        for (int i = 0; i < reactantConcentration.length; i++)
            reactantConcentration[i] = calculateInitialTotalConcentration()*reactantFlowrate[i]/calculateTotalFlowrate(reactantFlowrate, productFlowrate, inertFlowrate)*reactionParameters.getInputProperties()[2]/T*P/reactionParameters.getInputProperties()[3];
        return reactantConcentration;
    }

    public double [] calculateProductConcentration (double [] reactantFlowrate, double [] productFlowrate, double [] inertFlowrate, double T, double P)
    {
        double [] productConcentration = new double [productFlowrate.length];
        for (int i = 0; i < productConcentration.length; i++)
            productConcentration[i] = calculateInitialTotalConcentration()*productFlowrate[i]/calculateTotalFlowrate(reactantFlowrate, productFlowrate, inertFlowrate)*reactionParameters.getInputProperties()[2]/T*P/reactionParameters.getInputProperties()[3];
        return productConcentration;
    }

    public double [] calculateInertConcentration (double [] reactantFlowrate, double [] productFlowrate, double [] inertFlowrate, double T, double P)
    {
        double [] inertConcentration = new double [inertFlowrate.length];
        for (int i = 0; i < inertConcentration.length; i++)
            inertConcentration[i] = calculateInitialTotalConcentration()*inertFlowrate[i]/calculateTotalFlowrate(reactantFlowrate, productFlowrate, inertFlowrate)*reactionParameters.getInputProperties()[2]/T*P/reactionParameters.getInputProperties()[3];
        return inertConcentration;
    }

}
