interface Image {
    void display();
}

class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadfromDisk();
    }

    @Override
    public void display() {
        System.out.println("Diaplaying image: " + fileName);
    }

    public void loadfromDisk() {
        System.out.println("Loading from disk: " + fileName);
    }
}

// Proxy: Controls access to the RealSubject
class ImageProxy implements Image {
    private RealImage realImage;
    private String fileName;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
        this.realImage = null;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // Lazy initialization
        }
        realImage.display();
    }
}

public class Main {
    public static void main(String[] args) {
        ImageProxy imageProxy = new ImageProxy("filename1");
        imageProxy.display();

        imageProxy.display();
    }
}