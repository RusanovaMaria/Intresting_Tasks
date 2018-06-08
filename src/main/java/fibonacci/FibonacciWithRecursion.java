package fibonacci;

import java.util.Iterator;

public class FibonacciWithRecursion implements Fibonacci {

    private int numOfMembers;
    private int [] members;

    public FibonacciWithRecursion(int numOfMembers) {
        this.numOfMembers = numOfMembers;
        members = new int [numOfMembers];
        create();
    }

    private void create() {
        for (int i = 0; i < numOfMembers; i++) {
            members[i] = f(i);
        }
    }

    private int f(int n) {
        if ((n == 0) || (n == 1)) {
            return 1;
        } else {
            return f(n-1) + f (n-2);
        }
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
        return members[numOfMembers-1];
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

