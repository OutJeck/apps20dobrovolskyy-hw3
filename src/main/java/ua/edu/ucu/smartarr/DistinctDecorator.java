package ua.edu.ucu.smartarr;


import java.util.ArrayList;


// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray array) {
        super(array);
    }

    @Override
    public Object[] toArray() {
        Object[] arraySmart = smartArray.toArray();

        ArrayList<Object> arrayOutput = new ArrayList<>();

        for (int i = 0; i < arraySmart.length - 1; i++) {
            for (int j = i + 1; j < arraySmart.length; j++) {
                if (
                        !arraySmart[i].equals(arraySmart[j])
                        &&
                        !arrayOutput.contains(arraySmart[i])
                ) {
                    arrayOutput.add(arraySmart[i]);
                }

            }
        }

        return arrayOutput.toArray();
    }

    @Override
    public String operationDescription() {
        return "Array without repeated elements";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
