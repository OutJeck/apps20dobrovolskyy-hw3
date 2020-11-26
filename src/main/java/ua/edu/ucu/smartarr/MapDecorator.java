package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
    }

    @Override
    public Object[] toArray() {
        Object[] arraySmart = smartArray.toArray();

        ArrayList<Object> arrayOutput = new ArrayList<>();

        for (Object object: arraySmart) {
            arrayOutput.add(function.apply(object));
        }

        return arrayOutput.toArray();
    }

    @Override
    public String operationDescription() {
        return "Application of a function for array elements";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
