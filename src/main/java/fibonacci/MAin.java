package ru.datastructures.fibonacci;

public class MAin {
    public static void main(String[] args) {
        FibonacciWithMatrix fibonacci = new FibonacciWithMatrix(41);
        FibonacciWithMatrix fibonacci1 = new FibonacciWithMatrix(40);

        int[][] A = {{0, 1},
                {1, 1}};
        int [] nextTwoElements = new int [2];
        int [] [] matrix = A;
        for (int i = 0; i < 4; i++) {
          matrix = ((FibonacciWithMatrix) fibonacci).multiplyMatrixes(matrix, A);
          ((FibonacciWithMatrix) fibonacci).multiplyStartElementsByAPowN(matrix, nextTwoElements);
        }

        int fib[] = fibonacci.getMembers();
        for (int i = 0; i < fib.length; i++) {
            System.out.print(fib[i] + " ");
        }
        System.out.println();

        int fib1[] = fibonacci1.getMembers();
        for (int i = 0; i < fib1.length; i++) {
            System.out.print(fib1[i] + " ");
        }
    }
}
