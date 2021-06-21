/** This class will represent a abstract item
 * could be either File or Folder(who contains array of files)
 * */
public abstract class StorageItem {
    final String name;
    final String date;
    final int size;

    public StorageItem(String name){
        this.size = getSize();
        this.name = name;
        this.date = TimeStamps.raffleAndConvertToDate();
    }

    /** Different between File and Folder types */
    public abstract int getSize();

    public void printTree(SortingField field){ ; ///GET BACK TO THAT LATER!!!!!

        }
    public String getName(){

        return this.name;
    }

    public String getDate(){

        return this.date;
    }

}
