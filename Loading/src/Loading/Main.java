package Loading;

import Preservation.GameProgress;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {

    public static void main(String[] args) {

        openZip("zip.zip", "D://Games2/saveGames/");
       GameProgress gameProgress = openProgress("D://Games2/saveGames/gameProgress1.dat");
       if (gameProgress != null) {
           System.out.println(gameProgress);
       } else {
           System.out.println("Ошибка чтения файла: " + "D://Games2/saveGames/gameProgress1.dat");
       }

    }
    public static void openZip(String way, String wayBack){
        try (ZipInputStream zin = new ZipInputStream(new
                FileInputStream("D://Games2/saveGames/" + way))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName(); // получим название файла
                // распаковка
                FileOutputStream fout = new FileOutputStream(wayBack + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static GameProgress openProgress (String way){
        GameProgress gameProgress = null;
        try (FileInputStream fis = new FileInputStream(way);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            // десериализуем объект и скастим его в класс
            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return gameProgress;
    }
}
