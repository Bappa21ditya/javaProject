package com.security.java_project.system_design.splitwise.Strategy;

import com.security.java_project.system_design.splitwise.enums.SplitType;

public class SplitStrategyFactory {
    public SplitStrategy getStrategy(SplitType splitType) {

        switch (splitType) {

            case EQUAL:
                return new EqualSplitStrategy();

//            case EXACT:
//                return new ExactSplitStrategy();
//
//            case PERCENTAGE:
//                return new PercentageSplitStrategy();

            default:
                throw new IllegalArgumentException("Invalid Split Type");
        }
    }

}
