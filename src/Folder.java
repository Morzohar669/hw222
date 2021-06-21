import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
            sum += (arrayOfItems.get(i)).getSize();
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
        printTree(field,this, 1);
    }

    public void printTree(SortingField field, Folder currFolder, int counter) {
        if (currFolder.arrayOfItems.size() == 0) {
            return;
        }
        System.out.println(currFolder.getName());

        // here we need to sort my correct field
        ArrayList<StorageItem> sortedArray = sortByField(field, currFolder.arrayOfItems);

        while (sortedArray.size() != 0) {

            for (int j = 0 ; j < counter ; j++) {
                System.out.print("|    ");
            }

            if (sortedArray.get(0) instanceof File){
                System.out.println(((File) sortedArray.get(0)).getName());
                sortedArray = storageBuilder(sortedArray);

            }else {
                printTree(field, ((Folder) sortedArray.get(0)), ++counter);
                sortedArray = storageBuilder(sortedArray);
                counter--;
            }
        }
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

        class SortByName implements Comparator<StorageItem> {

            public int compare(StorageItem a, StorageItem b) {
                return a.getName().compareTo(b.getName());
            }
        }

        class SortBySize implements Comparator<StorageItem> {

            public int compare(StorageItem a, StorageItem b) {
                if(a.getSize() > b.getSize()){
                    return 1;
                }
                if (a.getSize() == b.getSize()){
                    return 0;
                }
                return -1;
            }
        }

        class SortByDate implements Comparator<StorageItem> {

            public int compare(StorageItem a, StorageItem b) {
                if(a.getDate().getTime() > b.getDate().getTime()){
                    return 1;
                }
                if (a.getDate().getTime() == b.getDate().getTime()){
                    return 0;
                }
                return -1;
            }
        }

        /** Using Comparator.compering we decide what switch case to use */

        switch (field){
            case NAME:
                Collections.sort(arrayList, new SortByName());
                break;
            case DATE:
                Collections.sort(arrayList, new SortByDate().thenComparing(new SortByName()));
                break;
            case SIZE:
                Collections.sort(arrayList, new SortBySize().thenComparing(new SortByName()));
                break;
        }
        return arrayList;
    }
}