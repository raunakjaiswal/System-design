import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {

    void showDetails();

    long getSize();
}

class File implements FileSystemComponent {
    private String name;
    private long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("File name: " + name + " , size: " + size);
    }

    @Override
    public long getSize() {
        return size;
    }
}

class Folder implements FileSystemComponent {

    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Folder: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }

    @Override
    public long getSize() {
        long totalSize = 0;
        for (FileSystemComponent component : components) {
            totalSize += component.getSize();
        }
        return totalSize;

    }
}

public class Main {
    public static void main(String[] args) {
        File file1 = new File("file1.txt", 500);
        File file2 = new File("file2.txt", 1500);
        File file3 = new File("file3.jpg", 2500);

        // Create a folder and add files to it
        Folder folder1 = new Folder("Documents");
        folder1.addComponent(file1);
        folder1.addComponent(file2);

        // Create another folder and add a file to it
        Folder folder2 = new Folder("Pictures");
        folder2.addComponent(file3);

        // Create a top-level folder and add other folders to it
        Folder rootFolder = new Folder("Root");
        rootFolder.addComponent(folder1);  // Add Documents folder
        rootFolder.addComponent(folder2);  // Add Pictures folder

        // Display details of the entire file system
        rootFolder.showDetails();
        System.out.println("Total size: " + rootFolder.getSize() + " bytes");
    }
}