import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public enum SortingField implements Comparator<String> {

    NAME {
        @Override
        public int compare(String o1, String o2) {

            if (o1.compareTo(o2) > 0) {
                return 1;
            }
            return 0;
        }
    },

    SIZE {
//        @Override
//        public int compare(String o1, String o2) {
//
//            if (o1.compareTo(o2) > 0){
//                return 1;
//            }
//            return 0;
    },

    DATE {

    }
}
