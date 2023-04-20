import java.io.IOException;
public class Main {
  public static void main(String[] args) throws IOException {
    FileArray fileArray = new FileArray("file.bin", 150);
    fileArray.print();
    fileArray.incrementAll();
    fileArray.print();
  }
}