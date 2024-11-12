import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {


        double [] inputProperties = {20000., 31.4, 450., 10., 1., 0.01, 10., 20., 1};
        //[0]=deltaH_R (J/mol)
        //[1]=E (kJ/mol)
        //[2]=T0 (K)
        //[3]=P0 (atm)
        //[4]=rho_c (kg/L)
        //[5]=alpha (1/K)
        //[6]= k_0 (L/mol.s)
        //[7]=v0 (L/s)
        //[8]=type (1=adiabatic, 2=isothermal)

        double type;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter \"1\" for an adiabatic reactor or \"2\" for an isothermal reactor");
        type = scan.nextDouble();



        double [] reactantConcentration ={2.};
        double[] productConcentration={1.};
        double[] reactantStoichiometry={1.};
        double[] productStoichiometry={1.};

        Reaction reactionObject = new Reaction(inputProperties, reactantConcentration, reactantStoichiometry, productConcentration, productStoichiometry);
       RateLaw rateLawObject = new RateLaw (inputProperties, reactionObject);

       double k;
        k=rateLawObject.calculateK(500);
        System.out.println("k is "+k);

        double rate;
        rate= rateLawObject.calculateRate(500,reactionObject);
        System.out.println("rate is "+rate);

    }
}