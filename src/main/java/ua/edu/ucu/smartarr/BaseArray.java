package ua.edu.ucu.smartarr;

import com.sun.xml.internal.rngom.parse.host.Base;

// Base array for decorators
public class BaseArray implements SmartArray {
    private final Object[] array;

    public BaseArray(Object[] objects) {
        this.array = objects.clone();
    }

    @Override
    public Object[] toArray() {
        return array.clone();
    }

    @Override
    public String operationDescription() {
        return "BaseArray";
    }

    @Override
    public int size() {
        return array.length;
    }
}
