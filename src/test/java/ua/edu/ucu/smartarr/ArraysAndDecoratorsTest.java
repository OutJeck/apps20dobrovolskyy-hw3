package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.BaseArray;

import static org.junit.Assert.*;

public class ArraysAndDecoratorsTest {
    Integer[] integers;
    BaseArray baseArray;

    @Before
    public void setUp() {
        this.integers = new Integer[]{-1, 2, 0, -4, 5, -1};
        this.baseArray = new BaseArray(integers);
    }

    @Test
    public void baseArrayTest() {
        assertEquals(baseArray.operationDescription(), "BaseArray");
        assertEquals(baseArray.size(), 6);
    }

    @Test
    public void distinctDecoratorTest() {

        SmartArray array = new DistinctDecorator(baseArray);
        assertEquals(array.operationDescription(), "Array without repeated elements");
        assertEquals(array.size(), 5);
    }

    @Test
    public void filterDecoratorTest() {
        MyPredicate predicate = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        SmartArray array = new FilterDecorator(baseArray, predicate);
        assertEquals(array.operationDescription(), "Only integer elements");
        assertEquals(array.size(), 2);
    }

    @Test
    public void mapDecoratorTest() {
        MyFunction function = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        SmartArray array = new MapDecorator(baseArray, function);
        assertEquals(array.operationDescription(), "Application of a function for array elements");
        assertEquals(array.size(), 6);
    }

    @Test
    public void sortDecoratorTest() {
        MyComparator comparator = new MyComparator() {
            @Override
            public int compare(Object objA, Object objB) {
                return ((Integer) objA) - ((Integer) objB);
            }
        };

        SmartArray array = new SortDecorator(baseArray, comparator);
        assertEquals(array.operationDescription(), "Sorted array by comparator");
        assertEquals(array.size(), 6);
    }




}
