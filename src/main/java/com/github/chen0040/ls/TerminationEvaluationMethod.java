package com.github.chen0040.ls;


import com.github.chen0040.ls.solutions.NumericSolutionUpdateResult;


/**
 * Created by xschen on 29/4/2017.
 */
public interface TerminationEvaluationMethod {
   boolean shouldTerminate(NumericSolutionUpdateResult state, int iteration);
}
