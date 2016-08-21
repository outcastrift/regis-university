package cs310sort.results;

import cs310sort.algorithms.AlgorithmType;

/**
 * This software was created for Regis University's CS 310 Course All rights to this software belong to Samuel Davis
 * appropriate licenses and restrictions apply.
 * Class Description
 * Class that contains the results of a run of a algorithm.
 * @author Samuel Kyle Davis
 */
public class Speed {
    private AlgorithmType algorithmType;
    private long time;

    public Speed(AlgorithmType algorithmType, long time) {
        super();
        this.algorithmType = algorithmType;
        this.time = time;

    }

    public AlgorithmType getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(AlgorithmType algorithmType) {
        this.algorithmType = algorithmType;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
