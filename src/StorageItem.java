import java.sql.Timestamp;
import java.util.Collections;

/** This class will represent a abstract item
 * could be either File or Folder(who contains array of files)
 * */
public abstract class StorageItem {
    final String name;
    final Timestamp date;
    final int size;

    public StorageItem(String name){
        this.size = getSize();
        this.name = name;
        this.date = TimeStamps.raffleAndConvertToDate();
    }

    /** Different between File and Folder types */
    public abstract int getSize();

    public String getName(){

        return this.name;
    }

    public Timestamp getDate(){

        return this.date;
    }

    public abstract void printTree(SortingField field);
}
