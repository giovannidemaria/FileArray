import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPFileArray extends FileArray {


  public GZIPFileArray(String filePathName) {
    super(filePathName);
  }

  public GZIPFileArray(String filePathName, int n) throws IOException {
    super(filePathName, n);
  }


  protected void writeFile(int[] numbers) throws IOException {
    FileOutputStream fos = new FileOutputStream(filePathName);
    GZIPOutputStream gos = new GZIPOutputStream(fos);
    DataOutputStream dos = new DataOutputStream(gos);
    for (int number : numbers) {
      dos.writeInt(number);
    }
    dos.close();
    gos.close();
    fos.close();
  }

  protected int[] readFile() throws IOException {
    FileInputStream fis = new FileInputStream(filePathName);
    GZIPInputStream gis = new GZIPInputStream(fis);
    DataInputStream dis = new DataInputStream(gis);

    int n = dis.readInt();
    int[] read = new int[n + 1];
    read[0] = n;
    for (int i = 1; i < n + 1; i++) {
      read[i] = dis.readInt();
    }

    dis.close();
    gis.close();
    fis.close();

    return read;
  }

}
