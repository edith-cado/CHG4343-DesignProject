public class ODE
{
    //this is a bare bones solver using a VERY slow and unsophisticated algorithm - it is intended for illustrative purposes only
    public static double[] integrate(double x_0, double x_f, double[] y_0,double delx, int maxIt, Function f) {
        double x=x_0;
        int numEquations=y_0.length;
        double[] y=new double[numEquations];
        for(int j=0;j<numEquations;j++)
            y[j]=y_0[j];
        int i=0;
        //communicate with the Function object, asking it for the right-hand-side values of the odes, given the current
        //values of x and y[]. This is accomplished through the Function object's calculateValue method
        while(x<=x_f && i<maxIt)
        {
            for(int j=0;j<numEquations;j++)
                y[j]=y[j]+delx*(f.calculateValue(x,y))[j];
            x=x+delx;
            i++;
        }

        return y;
    }//end of integrate method
}//end of Euler class