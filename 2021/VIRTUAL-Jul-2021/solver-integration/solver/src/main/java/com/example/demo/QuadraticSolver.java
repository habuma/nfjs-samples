package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class QuadraticSolver {
	
    public Solution solve(Equation equation) {
        double[] solutionPair = this.solve(
                equation.getCoefficientA(),
                equation.getCoefficientB(),
                equation.getCoefficientC());
        return new Solution(solutionPair[0], solutionPair[1]);
    }

    private double[] solve(double a, double b, double c) {
        // divide all terms by a to normalize to a = 1
        double bn = b / a; 
        double cn = c / a;
        
        double avg = (bn/2);
        double u = Math.sqrt((bn*bn / 4) - cn);
        double x1 = -avg - u;
        double x2 = -avg + u;
        
        return new double[] {x1, x2};
    }
}
