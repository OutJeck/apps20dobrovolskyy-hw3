package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.MapDecorator;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.SortDecorator;

public class SmartArrayApp {
    private static final int GPA_THRESHOLD = 4;
    private static final int SECOND_YEAR = 2;

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(
                    Student[] students) {

        MyPredicate predicate = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == SECOND_YEAR
                        &&
                        ((Student) t).getGpa() >= GPA_THRESHOLD;
            }
        };

        MyComparator comparator = new MyComparator() {
            @Override
            public int compare(Object studOne, Object studTwo) {
                String surnameOne = ((Student) studOne).getSurname();
                String surnameTwo = ((Student) studTwo).getSurname();
                return surnameOne.compareTo(surnameTwo);
            }
        };

        MyFunction function = new MyFunction() {
            @Override
            public Object apply(Object t) {
                String surname = ((Student) t).getSurname();
                String name = ((Student) t).getName();
                return surname + " " + name;
            }
        };

        SmartArray studentSmartArray = new BaseArray(students);
        studentSmartArray = new DistinctDecorator(studentSmartArray);
        studentSmartArray = new FilterDecorator(studentSmartArray, predicate);
        studentSmartArray = new SortDecorator(studentSmartArray, comparator);
        studentSmartArray = new MapDecorator(studentSmartArray, function);


        // Hint: to convert Object[] to String[] - use the following code
        Object[] result = studentSmartArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);
    }
}
