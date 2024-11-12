public class ReactionParameters
{
    private double[] inputProperties;
    private double[] reactantStoichiometry;
    private double[] productStoichiometry;
    private double[] inertStoichiometry;
    private double[] reactantMoleFraction;
    private double[] productMoleFraction;
    private double[] inertMoleFraction;
    private double[] reactantHeatCapacity;
    private double[] productHeatCapacity;
    private double[] inertHeatCapacity;

    //constructor
    public ReactionParameters(double[] inputProperties, double[] reactantStoichiometry, double[] productStoichiometry, double[] inertStoichiometry, double[] reactantMoleFraction, double[] productMoleFraction, double[] inertMoleFraction, double[] reactantHeatCapacity, double[] productHeatCapacity, double[] inertHeatCapacity) {
        if (inputProperties==null) System.exit(0);
        this.inputProperties = new double [inputProperties.length];
        for (int i=0; i<inputProperties.length; i++)
            this.inputProperties[i] = inputProperties[i];
        if (reactantStoichiometry==null) System.exit(0);
        if (reactantMoleFraction==null) System.exit(0);
        if (reactantHeatCapacity==null) System.exit(0);
        if (reactantMoleFraction.length != reactantStoichiometry.length || reactantMoleFraction.length != reactantHeatCapacity.length) {
            throw new IllegalArgumentException("All arrays for the reactants must be the same length");
        }
        if (productStoichiometry==null) System.exit(0);
        if (productMoleFraction==null) System.exit(0);
        if (productHeatCapacity==null) System.exit(0);
        if (productMoleFraction.length != productStoichiometry.length || productMoleFraction.length != productHeatCapacity.length) {
            throw new IllegalArgumentException("All arrays for the products must be the same length");
        }
        if (inertStoichiometry==null) System.exit(0);
        if (inertMoleFraction==null) System.exit(0);
        if (inertHeatCapacity==null) System.exit(0);
        if (inertMoleFraction.length != inertStoichiometry.length || inertMoleFraction.length != inertHeatCapacity.length) {
            throw new IllegalArgumentException("All arrays for the inerts must be the same length");
        }
        this.reactantStoichiometry = new double [reactantStoichiometry.length];
        for (int i=0; i<reactantStoichiometry.length; i++)
            this.reactantStoichiometry[i] = reactantStoichiometry[i];

        this.productStoichiometry = new double [productStoichiometry.length];
        for (int i=0; i<productStoichiometry.length; i++)
            this.productStoichiometry[i] = productStoichiometry[i];

        this.inertStoichiometry = new double [inertStoichiometry.length];
        for (int i=0; i<inertStoichiometry.length; i++)
            this.inertStoichiometry[i] = inertStoichiometry[i];

        this.reactantMoleFraction = new double [reactantMoleFraction.length];
        for (int i=0; i<reactantMoleFraction.length; i++)
            this.reactantMoleFraction[i] = reactantMoleFraction[i];

        this.productMoleFraction = new double [productMoleFraction.length];
        for (int i=0; i<productMoleFraction.length; i++)
            this.productMoleFraction[i] = productMoleFraction[i];

        this.inertMoleFraction = new double [inertMoleFraction.length];
        for (int i=0; i<inertMoleFraction.length; i++)
            this.inertMoleFraction[i] = inertMoleFraction[i];

        this.reactantHeatCapacity = new double [reactantHeatCapacity.length];
        for (int i=0; i<reactantHeatCapacity.length; i++)
            this.reactantHeatCapacity[i] = reactantHeatCapacity[i];

        this.productHeatCapacity = new double [productHeatCapacity.length];
        for (int i=0; i<productHeatCapacity.length; i++)
            this.productHeatCapacity[i] = productHeatCapacity[i];

        this.inertHeatCapacity = new double [inertHeatCapacity.length];
        for (int i=0; i<inertHeatCapacity.length; i++)
            this.inertHeatCapacity[i] = inertHeatCapacity[i];
    } //end of constructor

    //copy constructor
    public ReactionParameters(ReactionParameters source)
    {
        if(source==null) System.exit(0);
        this.inputProperties = new double [source.inputProperties.length];
        for(int i=0; i<source.inputProperties.length; i++)
            this.inputProperties[i]=source.inputProperties[i];

        this.reactantStoichiometry = new double [source.reactantStoichiometry.length];
        for(int i=0; i<source.reactantStoichiometry.length; i++)
            this.reactantStoichiometry[i]=source.reactantStoichiometry[i];

        this.productStoichiometry = new double [source.productStoichiometry.length];
        for(int i=0; i<source.productStoichiometry.length; i++)
            this.productStoichiometry[i]=source.productStoichiometry[i];

        this.inertStoichiometry = new double [source.inertStoichiometry.length];
        for(int i=0; i<source.inertStoichiometry.length; i++)
            this.inertStoichiometry[i]=source.inertStoichiometry[i];


        this.reactantMoleFraction = new double [source.reactantMoleFraction.length];
        for(int i=0; i<source.reactantMoleFraction.length; i++)
            this.reactantMoleFraction[i]=source.reactantMoleFraction[i];

        this.productMoleFraction = new double [source.productMoleFraction.length];
        for(int i=0; i<source.productMoleFraction.length; i++)
            this.productMoleFraction[i]=source.productMoleFraction[i];

        this.inertMoleFraction = new double [source.inertMoleFraction.length];
        for(int i=0; i<source.inertMoleFraction.length; i++)
            this.inertMoleFraction[i]=source.inertMoleFraction[i];


        this.reactantHeatCapacity = new double [source.reactantHeatCapacity.length];
        for(int i=0; i<source.reactantHeatCapacity.length; i++)
            this.reactantHeatCapacity[i]=source.reactantHeatCapacity[i];

        this.productHeatCapacity = new double [source.productHeatCapacity.length];
        for(int i=0; i<source.productHeatCapacity.length; i++)
            this.productHeatCapacity[i]=source.productHeatCapacity[i];

        this.inertHeatCapacity = new double [source.inertHeatCapacity.length];
        for(int i=0; i<source.inertHeatCapacity.length; i++)
            this.inertHeatCapacity[i]=source.inertHeatCapacity[i];
    } //end of copy constructor

    //accessors
    public double [] getInputProperties()
    {
        double [] inputProperties = new double [this.inputProperties.length];
        for (int i=0; i<this.inputProperties.length; i++)
            inputProperties[i]=this.inputProperties[i];
        return inputProperties;
    }
    public double [] getReactantStoichiometry()
    {
        double [] reactantStoichiometry = new double [this.reactantStoichiometry.length];
        for (int i=0; i<this.reactantStoichiometry.length; i++)
            reactantStoichiometry[i]=this.reactantStoichiometry[i];
        return reactantStoichiometry;
    }
    public double [] getProductStoichiometry()
    {
        double [] productStoichiometry = new double [this.productStoichiometry.length];
        for (int i=0; i<this.productStoichiometry.length; i++)
            productStoichiometry[i]=this.productStoichiometry[i];
        return productStoichiometry;
    }
    public double [] getInertStoichiometry()
    {
        double [] inertStoichiometry = new double [this.inertStoichiometry.length];
        for (int i=0; i<this.inertStoichiometry.length; i++)
            inertStoichiometry[i]=this.inertStoichiometry[i];
        return inertStoichiometry;
    }
    public double [] getReactantMoleFraction()
    {
        double [] reactantMoleFraction = new double [this.reactantMoleFraction.length];
        for (int i=0; i<this.reactantMoleFraction.length; i++)
            reactantMoleFraction[i]=this.reactantMoleFraction[i];
        return reactantMoleFraction;
    }
    public double [] getProductMoleFraction()
    {
        double [] productMoleFraction = new double [this.productMoleFraction.length];
        for (int i=0; i<this.productMoleFraction.length; i++)
            productMoleFraction[i]=this.productMoleFraction[i];
        return productMoleFraction;
    }
    public double [] getInertMoleFraction()
    {
        double [] inertMoleFraction = new double [this.inertMoleFraction.length];
        for (int i=0; i<this.inertMoleFraction.length; i++)
            inertMoleFraction[i]=this.inertMoleFraction[i];
        return inertMoleFraction;
    }
    public double [] getReactantHeatCapacity()
    {
        double [] reactantHeatCapacity = new double [this.reactantHeatCapacity.length];
        for (int i=0; i<this.reactantHeatCapacity.length; i++)
            reactantHeatCapacity[i]=this.reactantHeatCapacity[i];
        return reactantHeatCapacity;
    }
    public double [] getProductHeatCapacity()
    {
        double [] productHeatCapacity = new double [this.productHeatCapacity.length];
        for (int i=0; i<this.productHeatCapacity.length; i++)
            productHeatCapacity[i]=this.productHeatCapacity[i];
        return productHeatCapacity;
    }
    public double [] getInertHeatCapacity()
    {
        double [] inertHeatCapacity = new double [this.inertHeatCapacity.length];
        for (int i=0; i<this.inertHeatCapacity.length; i++)
            inertHeatCapacity[i]=this.inertHeatCapacity[i];
        return inertHeatCapacity;
    }
    //end of accessors

    //mutators
    public boolean setInputProperties(double [] inputProperties)
    {
        if (inputProperties==null) return false;
        this.inputProperties = new double [inputProperties.length];
        for (int i=0; i<inputProperties.length; i++)
            this.inputProperties[i]=inputProperties[i];
        return true;
    }
    public boolean setReactantStoichiometry(double [] reactantStoichiometry)
    {
        if (reactantStoichiometry==null) return false;
        this.reactantStoichiometry = new double [reactantStoichiometry.length];
        for (int i=0; i<reactantStoichiometry.length; i++)
            this.reactantStoichiometry[i]=reactantStoichiometry[i];
        return true;
    }
    public boolean setProductStoichiometry(double [] productStoichiometry)
    {
        if (productStoichiometry==null) return false;
        this.productStoichiometry = new double [productStoichiometry.length];
        for (int i=0; i<productStoichiometry.length; i++)
            this.productStoichiometry[i]=productStoichiometry[i];
        return true;
    }
    public boolean setInertStoichiometry(double [] inertStoichiometry)
    {
        if (inertStoichiometry==null) return false;
        this.inertStoichiometry = new double [inertStoichiometry.length];
        for (int i=0; i<inertStoichiometry.length; i++)
            this.inertStoichiometry[i]=inertStoichiometry[i];
        return true;
    }
    public boolean setReactantMoleFraction(double [] reactantMoleFraction)
    {
        if (reactantMoleFraction==null) return false;
        this.reactantMoleFraction = new double [reactantMoleFraction.length];
        for (int i=0; i<reactantMoleFraction.length; i++)
            this.reactantMoleFraction[i]=reactantMoleFraction[i];
        return true;
    }
    public boolean setProductMoleFraction(double [] productMoleFraction)
    {
        if (productMoleFraction==null) return false;
        this.productMoleFraction = new double [productMoleFraction.length];
        for (int i=0; i<productMoleFraction.length; i++)
            this.productMoleFraction[i]=productMoleFraction[i];
        return true;
    }
    public boolean setInertMoleFraction(double [] inertMoleFraction)
    {
        if (inertMoleFraction==null) return false;
        this.inertMoleFraction = new double [inertMoleFraction.length];
        for (int i=0; i<inertMoleFraction.length; i++)
            this.inertMoleFraction[i]=inertMoleFraction[i];
        return true;
    }
    public boolean setReactantHeatCapacity(double [] reactantHeatCapacity)
    {
        if (reactantHeatCapacity==null) return false;
        this.reactantHeatCapacity = new double [reactantHeatCapacity.length];
        for (int i=0; i<reactantHeatCapacity.length; i++)
            this.reactantHeatCapacity[i]=reactantHeatCapacity[i];
        return true;
    }
    public boolean setProductHeatCapacity(double [] productHeatCapacity)
    {
        if (productHeatCapacity==null) return false;
        this.productHeatCapacity = new double [productHeatCapacity.length];
        for (int i=0; i<productHeatCapacity.length; i++)
            this.productHeatCapacity[i]=productHeatCapacity[i];
        return true;
    }
    public boolean setInertHeatCapacity(double [] inertHeatCapacity)
    {
        if (inertHeatCapacity==null) return false;
        this.inertHeatCapacity = new double [inertHeatCapacity.length];
        for (int i=0; i<inertHeatCapacity.length; i++)
            this.inertHeatCapacity[i]=inertHeatCapacity[i];
        return true;
    } //end of mutators

    public ReactionParameters clone()
    {
        return new ReactionParameters(this);
    }

    //equals
    public boolean equals (Object comparator)
    {
        if (comparator==null) return false;
        else if (this.getClass()!=comparator.getClass()) return false;
        for (int i=0; i<inputProperties.length; i++)
            if(this.inputProperties[i] !=((ReactionParameters)comparator).inputProperties[i]) return false;
        for (int i=0; i<reactantStoichiometry.length; i++)
            if(this.reactantStoichiometry[i] !=((ReactionParameters)comparator).reactantStoichiometry[i]) return false;
        for (int i=0; i<productStoichiometry.length; i++)
            if(this.productStoichiometry[i] !=((ReactionParameters)comparator).productStoichiometry[i]) return false;
        for (int i=0; i<inertStoichiometry.length; i++)
            if(this.inertStoichiometry[i] !=((ReactionParameters)comparator).inertStoichiometry[i]) return false;
        for (int i=0; i<reactantMoleFraction.length; i++)
            if(this.reactantMoleFraction[i] !=((ReactionParameters)comparator).reactantMoleFraction[i]) return false;
        for (int i=0; i<productMoleFraction.length; i++)
            if(this.productMoleFraction[i] !=((ReactionParameters)comparator).productMoleFraction[i]) return false;
        for (int i=0; i<inertMoleFraction.length; i++)
            if(this.inertMoleFraction[i] !=((ReactionParameters)comparator).inertMoleFraction[i]) return false;
        for (int i=0; i<reactantHeatCapacity.length; i++)
            if(this.reactantHeatCapacity[i] !=((ReactionParameters)comparator).reactantStoichiometry[i]) return false;
        for (int i=0; i<productHeatCapacity.length; i++)
            if(this.productHeatCapacity[i] !=((ReactionParameters)comparator).productHeatCapacity[i]) return false;
        for (int i=0; i<inertHeatCapacity.length; i++)
            if(this.inertHeatCapacity[i] !=((ReactionParameters)comparator).inertHeatCapacity[i]) return false;
        return true;
    } //end of equals

}
