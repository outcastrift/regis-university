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

    /**
     * Public Constructor.
     * **/
    public Speed(AlgorithmType algorithmType, long time) {
        super();
        this.algorithmType = algorithmType;
        this.time = time;

    }
    /**
     * Returns the AlgorithmType of this Speed Object.
     * **/
    public AlgorithmType getAlgorithmType() {
        return algorithmType;
    }

    /**
     * Returns the amount of time it took for the algorithm to sort a array.
     * **/
    public long getTime() {
        return time;
    }


}
