package com.github.chen0040.ls.methods.naive;


import com.github.chen0040.ls.CostEvaluationMethod;
import com.github.chen0040.ls.GradientEvaluationMethod;
import com.github.chen0040.ls.LocalSearch;
import com.github.chen0040.ls.TerminationEvaluationMethod;
import com.github.chen0040.ls.solutions.NumericSolution;
import com.github.chen0040.ls.solutions.NumericSolutionUpdateResult;

import java.util.Random;


/**
 * Created by xschen on 12/8/15.
 */
public class RandomSearch extends LocalSearch {

    public RandomSearch(){


    }

    @Override
    public LocalSearch makeCopy(){
        RandomSearch clone = new RandomSearch();
        clone.copy(this);
        return clone;
    }

    @Override
    public NumericSolution minimize(double[] x_0, final CostEvaluationMethod evaluate, GradientEvaluationMethod calc_gradient, TerminationEvaluationMethod should_terminate, Object constraint) {

        NumericSolution best_solution = new NumericSolution();

        double[] x = x_0.clone();
        double fx = evaluate.apply(x, getLowerBounds(), getUpperBounds(), constraint);

        best_solution.tryUpdateSolution(x, fx);

        int iteration = 0;
        NumericSolutionUpdateResult state = null;
        while(!should_terminate.shouldTerminate(state, iteration))
        {
            double[] x_next = createRandom(getLowerBounds(), getUpperBounds());
            double fx_next = evaluate.apply(x_next, getLowerBounds(), getUpperBounds(), constraint);

            state = best_solution.tryUpdateSolution(x_next, fx_next);

            if(state.improved())
            {
                notifySolutionUpdated(best_solution, state, iteration);
            }
            step(new NumericSolution(x_next, fx_next), state, iteration);
            iteration++;
        }

        return best_solution;
    }

    private static Random rand = new Random();

    public double[] createRandom(double[] lower, double[] upper){
        double[] x = new double[lower.length];
        for(int i=0; i < x.length; ++i){
            x[i] = lower[i] + rand.nextDouble() * (upper[i] - lower[i]);
        }
        return x;
    }
}
