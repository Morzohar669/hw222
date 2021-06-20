import java.util.ArrayList;

public class Folder extends StorageItem {
    ArrayList<StorageItem> arrayOfItems;

    public Folder(String name) {
        super(name);
        arrayOfItems = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return arrayOfItems.size(); // change it - every get is different
    }

    public boolean addItem(StorageItem item) {
        String itemName = item.getName();
        for (int i = 0; i < arrayOfItems.size(); i++) {
            if (itemName.equals(arrayOfItems.get(i).getName())) {
                return false;
            }
        }
        arrayOfItems.add(item);
        return true;
    }
//    public File findFile(String path){
//        return 0 ;
    }


