package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        this.comparator = comparator;
    }

    @Override
    public Object[] toArray() {
        return Arrays.stream(smartArray.toArray()).sorted(comparator).toArray();
    }

    @Override
    public String operationDescription() {
        return "Sorted array by comparator";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
