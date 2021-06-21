import java.util.ArrayList;

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
}