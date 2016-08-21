package cs310sort.results;

import cs310sort.algorithms.AlgorithmType;

/**
 * This software was created for Regis University's CS 310 Course All rights to this software belong to Samuel Davis
 * appropriate licenses and restrictions apply.
 * Class Description
 * Convenience class to create a speed object.
 * @author Samuel Kyle Davis
 */
public class SpeedBuilder {
    private AlgorithmType algorithmType;
    private long time;

    private SpeedBuilder(){}

    /**
     * Creates a new instance of this SpeedBuilder.
     * **/
    public static SpeedBuilder newInstance() {
        return new SpeedBuilder();
    }

    /**
     * Sets the AlgorithmType for this sort Algorithm.
     * **/
    public SpeedBuilder setAlgorithmType(AlgorithmType algorithmType) {
        this.algorithmType = algorithmType;
        return this;
    }


    /**
     * Sets the amount of time it took to complete a sort with a algorithm.
     * **/
    public SpeedBuilder setTime(long time) {
        this.time = time;
        return this;
    }

    /**
     * Returns a Speed object containing all the set variables.
     * **/
    public Speed build() {
        return new Speed(algorithmType, time);
    }
}
