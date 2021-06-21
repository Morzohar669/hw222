import java.util.ArrayList;

public class File extends StorageItem {
    String type;
    String content;

    public File(String name, String type) {
        super(name);
        this.type = type;
        this.content = "";
    }

    @Override
    public String getName() {
        return name + "." + type;
    }

    @Override
    public int getSize() {
        if (content == null){
            return 0;
        }
        return content.length();
    }

    public void addContent(String contentToAdd) {
        content += contentToAdd;
    }

    public void printContent() {
        System.out.println(getName() + " Size: " + getSize() + "MB Created: " + getDate());
        System.out.println(content);
    }
    @Override
    public void printTree(SortingField field) {
        System.out.println(this.getName());
        return;
    }
}
