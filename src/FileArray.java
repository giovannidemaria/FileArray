import java.io.*;
import java.util.Random;

public class FileArray {
  private final String filePathName;


  // loads an existing file
  public FileArray(String filePathName) {
    this.filePathName = filePathName;

    //controllare se esiste il filepath
  }

  // creates new file with n random elements
  public FileArray(String filePathName, int n) throws IOException {
    this.filePathName = filePathName;

    int[] numbers = new int[n + 1];
    Random random = new Random();
    numbers[0] = n;
    for (int i = 1; i < n + 1; i++) {
      numbers[i] = random.nextInt(1025);
      // System.out.println(i + "\t" + numbers[i]);
    }
    FileOutputStream fos = new FileOutputStream(filePathName);
    try (fos; DataOutputStream dos = new DataOutputStream(fos)) {
      for (int i = 0; i < n + 1; i++) {
        dos.writeInt(numbers[i]);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // pretty print with at most 5 aligned elements per row
  public void print() {
    int[] numbers = readFile();
    int n = numbers[0];
    int zeroOrder = (Integer.toString(n)).length();
    int maxNumber = 0;
    for (int i = 1; i < numbers.length; i++) {
      if (numbers[i] > maxNumber) maxNumber = numbers[i];
    }
    int zeroOrder2 = (Integer.toString(maxNumber)).length();

    for (int i = 1; i < n + 1; i++) {
      if ((i - 1) % 5 == 0) {
        System.out.printf("\n[%0" + zeroOrder + "d-%0" + zeroOrder + "d]", i - 1, i + 4);
      }
      System.out.printf(" %" + zeroOrder2 + "d", numbers[i]);
    }
  }

  //increment all elements
  public void incrementAll() throws FileNotFoundException {
    int[] numbers = readFile();
    for (int i = 1; i < numbers.length; i++) {
      numbers[i]++;
    }
    writeFile(numbers);
  }

  public int[] readFile() {
    int[] numbers = new int[0];
    try {
      FileInputStream fis = new FileInputStream(filePathName);
      DataInputStream dis = new DataInputStream(fis);
      int n = dis.readInt();
      numbers = new int[n + 1];
      numbers[0] = n;
      for (int i = 1; i < n + 1; i++) {
        numbers[i] = dis.readInt();
      }
      fis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return numbers;
  }

  public void writeFile(int[] numbers) throws FileNotFoundException {
    FileOutputStream fos = new FileOutputStream(filePathName);
    try (fos; DataOutputStream dos = new DataOutputStream(fos)) {

      for (int number : numbers) {
        dos.writeInt(number);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}