package fibonacci;

import java.util.Iterator;

public class FibonacciWithMatrix implements Fibonacci {

    private final int[] startElements = {1, 1};
    private final int[][] A = {{0, 1},
            {1, 1}};
    private final int[][] APow2 = multiplyMatrixes(A, A);
    private int numOfMembers;
    private int[] members;

    public FibonacciWithMatrix(int numOfMembers) {
        this.numOfMembers = numOfMembers;
        members = new int[numOfMembers];
        generate();
    }

    private void generate() {
        members[0] = 1;
        if ((numOfMembers % 2) == 0) {
            generateForEvenNumber();
        } else {
            generateForOddNumber();
        }
    }

    int[] getMembers() {
        return members;
    }

    private void generateForEvenNumber() {
        int[][] currentMatrix = APow2;
        int[] nextTwoElements = {0, 0};

        members[0] = 1;
        members[1] = 1;
        int i = 2;
        while (i < numOfMembers - 1) {
            if (i < 4) {
                multiplyStartElementsByAPowN(APow2, nextTwoElements);
                members[i] = nextTwoElements[0];
                members[i + 1] = nextTwoElements[1];
            } else {
                currentMatrix = multiplyMatrixes(currentMatrix, APow2);
                multiplyStartElementsByAPowN(currentMatrix, nextTwoElements);
                members[i] = nextTwoElements[0];
                members[i + 1] = nextTwoElements[1];
            }
            i = i + 2;
        }
    }

    private void generateForOddNumber() {
        int[][] currentMatrix = A;
        int[] nextTwoElements = {0, 0};

        members[0] = 1;

        int i = 1;
        while (i < numOfMembers - 1) {
            if (i < 3) {
                multiplyStartElementsByAPowN(A, nextTwoElements);
                members[i] = nextTwoElements[0];
                members[i + 1] = nextTwoElements[1];
            } else {
                currentMatrix = multiplyMatrixes(currentMatrix, APow2);
                multiplyStartElementsByAPowN(currentMatrix, nextTwoElements);
                members[i] = nextTwoElements[0];
                members[i + 1] = nextTwoElements[1];
            }
            i = i + 2;
        }
    }

    int[][] multiplyMatrixes(int[][] matrix1, int[][] matrix2) {
        int[][] resultMatrix = new int[2][2];
        resultMatrix[0][0] = matrix1[0][0] * matrix2[0][0] + matrix1[0][1] * matrix2[1][0];
        resultMatrix[0][1] = matrix1[0][0] * matrix2[0][1] + matrix1[0][1] * matrix2[1][1];
        resultMatrix[1][0] = matrix1[1][0] * matrix2[0][0] + matrix1[1][1] * matrix2[0][1];
        resultMatrix[1][1] = matrix1[1][0] * matrix2[0][1] + matrix1[1][1] * matrix2[1][1];

        return resultMatrix;
    }

    void multiplyStartElementsByAPowN(int[][] APowN, int[] nextTwoElements) {
        nextTwoElements[0] = startElements[0] * (APowN[0][0] + APowN[1][0]);
        nextTwoElements[1] = startElements[1] * (APowN[0][1] + APowN[1][1]);
    }

    @Override
    public int getMember(int number) {
        if (number < numOfMembers) {
            return members[number];
        } else {
            throw new IllegalArgumentException("Превышение размера последовательности");
        }
    }

    @Override
    public int getLastMember() {
        return members[numOfMembers - 1];
    }

    @Override
    public Iterator iterator() {

        Iterator it = new Iterator() {
            int index = 0;

            @Override
            public boolean hasNext() {
                if (index < numOfMembers) {
                    return true;
                } else return false;
            }

            @Override
            public Integer next() {
                Integer member = members[index];
                index++;

                return member;
            }
        };
        return it;
    }

    @Override
    public int getSize() {
        return numOfMembers;
    }
}
