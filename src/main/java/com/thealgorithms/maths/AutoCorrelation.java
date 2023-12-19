package com.thealgorithms.maths;


/**
 * Class for linear auto-correlation of a discrete signal
 *
 * @author Athina-Frederiki Swinkels
 * @version 1.0
 */

public class AutoCorrelation {

    /**
     * Discrete linear auto-correlation function.
     * Input and output signals have starting index 0.
     *
     * @param x The discrete signal
     * @return The result of the auto-correlation of signals x. The result is also a signal.
     */
    public static double[] autoCorrelation(double[] x){
        //The result signal's length is double the length of signal x minus 1
        double[] result=new double[2*x.length-1];
        int N=result.length;

        /*
        To find the auto-correlation of a discrete signal x, we perform cross-correlation between x signal and itself.
        Here's an example:
        x=[1,2,1,1]
        y=[1,2,1,1]

        i=0:      [1,2,1,1]
            [1,2,1,1]               result[0]=1*1=1

        i=1:       [1,2,1,1]
               [1,2,1,1]            result[1]=1*1+2*1=3

        i=2:       [1,2,1,1]
                 [1,2,1,1]          result[2]=1*2+2*1+1*1=5

        i=3:       [1,2,1,1]
                   [1,2,1,1]        result[3]=1*1+2*2+1*1+1*1=7

        i=4:       [1,2,1,1]
                     [1,2,1,1]      result[4]=2*1+1*2+1*1=5

        i=5:       [1,2,1,1]
                       [1,2,1,1]    result[5]=1*1+1*2=3

        i=1:       [1,2,1,1]
                         [1,2,1,1]  result[6]=1*1=1

        result=[1,3,5,7,5,3,1]


         */
        int start=x.length;
        for (int i = 0; i < N; i++) {
            result[i] = 0;

            int kMin = Math.max(i - (x.length - 1), 0);
            int kMax = Math.min(i, x.length - 1);

            if(i<x.length){
                start--;
            }


            int count=0;
            for (int k = kMin; k <= kMax; k++) {
                result[i] += x[k] * x[start+count];
                count++;
            }


        }

        //The calculated auto-correlation of x signal is returned here.
        return result;


    }

}
