package services;

import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;

public class FilesUtil {

    private static String imageName = "logo.";

    public static boolean saveLogo(Part filePart, String path) {
        if (filePart != null) {

            BufferedInputStream bufferedReader = null;
            try {
                bufferedReader = new BufferedInputStream(filePart.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

            File shopPage = new File(path);
            if (!shopPage.exists())
                if (!shopPage.mkdirs()) {
                    System.out.println("не удалось создать файл");
                    return false;
                }
            String mem;
            try {
                mem = Paths.get(filePart.getSubmittedFileName())
                        .getFileName()
                        .toString()
                        .split("\\.")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                return false;
            }
            File logo = new File(path + "/" + imageName + mem);

            try(FileOutputStream fos = new FileOutputStream(logo)) {
                int ch;
                while ((ch = bufferedReader.read()) != -1) {
                    fos.write(ch);
                }

                bufferedReader.close();
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static String getImageName() {
        return imageName;
    }

    public static void setImageName(String imageName) {
        FilesUtil.imageName = imageName;
    }
}
