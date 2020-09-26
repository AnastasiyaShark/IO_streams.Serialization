package Preservation;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    private static final String path = "D:/Games2/saveGames";

    public static void main(String[] args) {

        GameProgress gameProgress1 = new GameProgress(94, 12, 8, 36.5);
        saveGame(gameProgress1, "gameProgress1.dat");
        GameProgress gameProgress2 = new GameProgress(75, 10, 8, 56.2);
        saveGame(gameProgress2, "gameProgress2.dat");
        GameProgress gameProgress3 = new GameProgress(32, 3, 9, 79.6);
        saveGame(gameProgress3, "gameProgress3.dat");


        ArrayList<String> files = new ArrayList<>();
        files.add(path + "/gameProgress1.dat");
        files.add(path + "/gameProgress2.dat");
        files.add(path + "/gameProgress3.dat");
        zipFiles(path + "/zip.zip", files);


        File dir = new File(path );
            for (File item : dir.listFiles()) {
                if (item.isFile() && !item.getName().contains(".zip")) {
                    item.delete();
                }
            }


    }




    public static void saveGame(GameProgress gameProgress, String way) {
        try {
            FileOutputStream fos = new FileOutputStream(path + "/" + way);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gameProgress);
            oos.close();
            fos.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void zipFiles(String way1, ArrayList<String> files) {
        try {
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(way1));
            for (String way : files) {
                FileInputStream fis = new FileInputStream(way);
                String[] fileParts = way.split("/");
                String zipEntryName = fileParts[fileParts.length-1];
                ZipEntry entry = new ZipEntry(zipEntryName);
                zout.putNextEntry(entry);
            // считываем содержимое файла в массив byte
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
            // добавляем содержимое к архиву
                zout.write(buffer);
            // закрываем текущую запись для новой записи
                zout.closeEntry();
                fis.close();
            }
            zout.finish();
            zout.close();
        } catch (IOException e) {
            System.out.println (e.getMessage());
        }
    }

}






//    public static void main(String[] args) {
//        GameProgress gameProgress1 = new GameProgress(94, 12, 8, 36.5);
//        try (FileOutputStream fos1 = new FileOutputStream("D://Games2/saveGames/gameProgress1.dat");
//             ObjectOutputStream oos = new ObjectOutputStream(fos1)) {
//            oos.writeObject(gameProgress1);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        GameProgress gameProgress2 = new GameProgress(75, 10, 8, 56.2);
//        try (FileOutputStream fos2 = new FileOutputStream("D://Games2/saveGames/gameProgress2.dat");
//             ObjectOutputStream oos1 = new ObjectOutputStream(fos2)) {
//            oos1.writeObject(gameProgress2);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        GameProgress gameProgress3 = new GameProgress(32, 3, 9, 79.6);
//        try (FileOutputStream fos3 = new FileOutputStream("D://Games2/saveGames/gameProgress3.dat");
//             ObjectOutputStream oos2 = new ObjectOutputStream(fos3)) {
//            oos2.writeObject(gameProgress3);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

