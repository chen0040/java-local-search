package com.github.chen0040.ls;


/**
 * Created by xschen on 29/4/2017.
 */
public interface CostEvaluationMethod{

   double apply(double[] x, double[] lowerBounds, double[] upperBounds, Object constraint);
}

