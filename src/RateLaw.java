public class RateLaw
{
    private ReactionParameters reactionParameters;
    private Reaction rxn;

    public static double R=0.082057; //L.atm/mol.K

    //constructor
    public RateLaw(ReactionParameters reactionParameters, Reaction rxn)
    {
        if (reactionParameters==null) System.exit(0);
        if (rxn==null) System.exit (0);
        this.reactionParameters = reactionParameters;
        this.rxn= rxn; //check if this is right
    } //end of constructor

    //copy constructor
    public RateLaw(RateLaw source)
    {
        if(source==null) System.exit(0);
        this.reactionParameters = source.reactionParameters;
        this.rxn= source.rxn;
    } //end of copy constructor

    //clone
    public RateLaw clone()
    {
        return new RateLaw(this);
    } //end of clone

    //accessors
    public ReactionParameters getReactionParameters()
    {
        return this.reactionParameters;
    }

    public Reaction getRxn()
    {
        return this.rxn;
    }  //end of accessors

    //mutators
    public boolean setReactionParameters(ReactionParameters reactionParameters)
    {
        if (reactionParameters==null) return false;
        this.reactionParameters = reactionParameters;
        return true;
    }

    public boolean setRxn(Reaction rxn)
    {
        if (rxn==null) return false;
        this.rxn = rxn;
        return true;
    } //end of mutators

    //equals
    public boolean equals (Object comparator)
    {
        if (comparator==null) return false;
        else if (this.getClass()!=comparator.getClass()) return false;
        else if (this.reactionParameters != ((RateLaw)comparator).reactionParameters) return false;
        else if (this.rxn!= ((RateLaw)comparator).rxn) return false;
        return true;
    } //end of equals


    //methods
    public double calculateK(double T)
    {
        double k = reactionParameters.getInputProperties()[6] * Math.exp((reactionParameters.getInputProperties()[1]/R)*(1/reactionParameters.getInputProperties()[2]-1/T));
        return k;
    }

    public double calculateRate(double T, Reaction rxn) //for irreversible reaction
    {
        double [] reactantConcentration=rxn.calculateReactantConcentration(reactantFlowrate, productFlowrate, inertFlowrate, T, P);
        double [] reactantStoichiometry=reactionParameters.getReactantStoichiometry();

        double rate=calculateK(T);
        for (int i = 0; i < reactantConcentration.length; i++)
        {
            rate *= Math.pow(reactantConcentration[i], reactantStoichiometry[i]);
        }
        return rate;
    }



}
