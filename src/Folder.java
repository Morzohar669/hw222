import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

public class Folder extends StorageItem {
    ArrayList<StorageItem> arrayOfItems;

    public Folder(String name) {
        super(name);
        arrayOfItems = new ArrayList<>();
    }

    @Override
    public int getSize() {
        if (arrayOfItems == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arrayOfItems.size(); i++) {
            sum += arrayOfItems.get(1).size;
        }
        return sum;
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

    public File findFile(String path) {
        return checkFile(arrayOfItems, path);
    }

    /** send me into recursive helping function with the list nd the path */

    public File checkFile(ArrayList<StorageItem> arrayOfItems, String pathString) {
        if (pathString.length() == 0) {
            return null;
        }

        /** This block makes path from string to arraylist of strings*/
        String[] pathSplit = pathString.split("/");
        ArrayList<String> pathList = new ArrayList<String>();

        for (String item : pathSplit) {
            pathList.add(item);
        }

        /** now we want to check if the item is in the folder*/
        for (int i = 0; i < arrayOfItems.size(); i++) {
            if (arrayOfItems.get(i).getName().equals(pathList.get(0))) {

                /** if the item is a folder or a file*/
                if (arrayOfItems.get(i) instanceof File) {
                    return ((File) arrayOfItems.get(i));
                }
                /** if we got here then the item have the same name but is not a file!*/

                StringBuilder currPath = new StringBuilder();
                for (int j =1 ; j < pathList.size() ; j++ ) {
                    currPath.append(pathList.get(j));
                    currPath.append("/");
                }
                currPath.replace(currPath.length() - 1 , currPath.length(),"");

                return checkFile(((Folder) arrayOfItems.get(i)).arrayOfItems, currPath.toString());
            }
        }
        /** if we got here so the file is not exist in this folder*/
        return null;
    }

    @Override
    public void printTree(SortingField field) {
        printTree(field, arrayOfItems);
    }

    public void printTree(SortingField field, ArrayList<StorageItem> arrayToPrint){
        if (arrayOfItems.size() == 0){
            return;
        }

        System.out.println(getName());

        // here we need to sort my correct field
        ArrayList<StorageItem> sortedArray = sortByField(field, arrayToPrint);

        System.out.println("|    ");

        if (sortedArray.get(0) instanceof File)
            System.out.println(((File) sortedArray.get(0)).getName());
            sortedArray = storageBuilder(sortedArray);
            printTree(field, sortedArray);

        sortedArray = storageBuilder(sortedArray);
        printTree(field, sortedArray);
    }

    public ArrayList<StorageItem> storageBuilder(ArrayList<StorageItem> arrWithAll){
        ArrayList<StorageItem> arrWithout0 = new ArrayList<>();
        if (arrWithAll.size() == 0){
            return null;
        }
        for (int i = 1 ; i < arrWithAll.size() ; i++){
            arrWithout0.add(arrWithAll.get(i));
        }
        return arrWithout0;
    }

    public ArrayList<StorageItem> sortByField(SortingField field, ArrayList<StorageItem> arrayList){
        if (field == SortingField.NAME){

            /* Sort statement*/
            Collections.sort(arrayList);

        }
    }

}