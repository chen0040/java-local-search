package com.github.chen0040.ls.events;


import com.github.chen0040.ls.solutions.NumericSolution;
import com.github.chen0040.ls.solutions.NumericSolutionUpdateResult;


/**
 * Created by xschen on 12/8/15.
 */
public interface NumericSolutionUpdatedListener {

    void report(NumericSolution solution, NumericSolutionUpdateResult state, int iteration);
}
