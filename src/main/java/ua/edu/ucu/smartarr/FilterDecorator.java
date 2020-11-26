package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private final MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
    }

    @Override
    public Object[] toArray() {
        Object[] arraySmart = smartArray.toArray();

        ArrayList<Object> arrayOutput = new ArrayList<>();

        for (Object object: arraySmart) {
            if (predicate.test(object)) {
                arrayOutput.add(object);
            }
        }
        return arrayOutput.toArray();
    }

    @Override
    public String operationDescription() {
        return "Only integer elements";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
