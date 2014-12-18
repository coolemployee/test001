package com.implemica.task.antsyferov;
/**
 * @author Anton Antsyferov
 * 
 */
public class Test001 {

    static int n; // input: number N of brackets
    static int numberOfCorrectSequences = 0; // result: number of possible
					     // correct bracket-sequences

    /**
     * @param args
     *            args[0] N, the number of brackets to calculate sequences
     */
    public static void main(String[] args) {

	n = Integer.parseInt(args[0]);
	// starting recursion here
	processSequence(0, 0);
	// printing result
	System.out.println(numberOfCorrectSequences);
    }

    /**
     * Recursive method to calculate sum of possible correct bracket-sequences.
     * Should be initialized with (0,0) parameters.
     * 
     * @param openBracketsCount
     *            number of currently used "(" brackets
     * @param closeBracketsCount
     *            number of currently used ")" brackets
     */
    static void processSequence(int openBracketsCount, int closeBracketsCount) {
	if (openBracketsCount + closeBracketsCount == 2 * n) {
	    // at this point we've formed a correct sequence, incrementing
	    // result
	    numberOfCorrectSequences++;
	    return;
	}

	if (openBracketsCount < n)
	    // if '('-brackets are available, than adding '('
	    processSequence(openBracketsCount + 1, closeBracketsCount);

	if (openBracketsCount > closeBracketsCount)
	    // if current sequence can be closed 'correctly', than adding ')'.
	    // Note: in this way of rules we are generating ONLY correct
	    // sequences
	    processSequence(openBracketsCount, closeBracketsCount + 1);

	return;

    }

}
