import java.util.Comparator;

public class SortByNameComparator extends Folder implements Comparator<String>{
    public SortByNameComparator(String name) {
        super(name);
    }

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o2);
    }
}
