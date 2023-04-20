import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Main2 {
  public static void main(String @NotNull [] args) throws IOException {
    int nParams = args.length;
    if (nParams == 0)
      System.exit(-1);
    String filePathName = args[0];
    FileArray fileArray;
    if (new File(filePathName).exists())
      fileArray = new FileArray(filePathName);
    else
      fileArray = new FileArray(filePathName, (new Random()).nextInt(33));

    for (int i = 1; i < args.length; i++)
      if (args[i].equals("p"))
        fileArray.print();
      else if (args[i].equals("i"))
        fileArray.incrementAll();
  }
}