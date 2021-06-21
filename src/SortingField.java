import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public enum SortingField {

    NAME{
        class Sortbyname implements Comparator<Student> {
            // Used for sorting in ascending order of
            // roll number
            public int compare(Student a, Student b)
            {
                return a.rollno - b.rollno;
            }
        }
    },

    SIZE,

    DATE
}
