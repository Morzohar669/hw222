import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;

public abstract class StorageItem {
    final String name;
    final long date;
    //final long size;
    public StorageItem(String name){
        //this.size = getSize();
        this.name = name;
        this.date = System.currentTimeMillis()/1000; // change it to constant
        System.out.println(this.date);

    }

    public abstract int getSize();

    public void printTree(SortingField field){ ;


        }
    public String getName(){
        return this.name;
    }

    public long getDate(){
        return this.date;

    }

}
