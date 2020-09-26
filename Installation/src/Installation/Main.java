package Installation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void doActionAndLog(StringBuilder builder , File file , boolean createFolder ) {
        String fileName = file.getAbsolutePath();
        boolean result = false;
        if (createFolder) {
            result = file.mkdir();
        } else {
            try {
                result = file.createNewFile();
            } catch (IOException exception){
                builder.append(String.format("There is a problem with : %s , exception : %s %n", fileName , exception.getMessage() ));
            }
        }
        if ( result ) {
            builder.append(String.format("Successfully created : %s%n", fileName ));
        } else {
            builder.append(String.format("There is a problem with : %s%n", fileName ));
        }
    }

    public static void main(String[] args) {
        final String installationPathBase = "D:/Games2/";
        StringBuilder builder = new StringBuilder();

        File srcMap = new File(installationPathBase + "src");
        doActionAndLog(builder , srcMap, true );

        File resMap = new File(installationPathBase + "res");
        doActionAndLog(builder , resMap , true);

        File saveGamesMap = new File(installationPathBase + "saveGames");
        doActionAndLog(builder , saveGamesMap, true);

        File tempMap = new File(installationPathBase + "temp");
        doActionAndLog(builder , tempMap, true);

        File mainMap = new File(installationPathBase + "src/main");
        doActionAndLog(builder , mainMap, true);

        File testMap = new File(installationPathBase + "src/test");
        doActionAndLog(builder , testMap, true );


        File mainFile = new File(installationPathBase + "src/main/Main.java");
        doActionAndLog(builder , mainFile , false );

        File utilsFile = new File(installationPathBase + "src/main/Utils.java");
        doActionAndLog(builder , utilsFile , false );

        File drawablesMap = new File(installationPathBase + "res/drawables");
        doActionAndLog(builder , drawablesMap, true );

        File vectorsMap = new File(installationPathBase + "res/vectors");
        doActionAndLog(builder , vectorsMap, true );

        File iconsMap = new File(installationPathBase + "res/icons");
        doActionAndLog(builder , iconsMap, true );

        File tempFile = new File(installationPathBase + "temp/temp.txt");
        doActionAndLog(builder , tempFile , false );

        try (FileWriter writer = new FileWriter(installationPathBase + "temp/temp.txt", true)) {
            writer.write(builder.toString());
        } catch (IOException e) {
            builder.append(e.getMessage());
        }

    }
}

//    public static void main(String[] args) {
//        StringBuilder builder = new StringBuilder();
//        File srcMap = new File("D://Games2/src");
//        builder.append(srcMap.mkdir());
//
//
//
//        File srcMap = new File("D://Games2/src");
//        if (srcMap.mkdir()) {
//            System.out.println("Создано!");
//        }
//        File resMap = new File("D://Games2/res");
//        if (resMap.mkdir()) {
//            System.out.println("Создано!");
//        }
//        File saveGamesMap = new File("D://Games2/saveGames");
//        if (saveGamesMap.mkdir()) {
//            System.out.println("Создано!");
//        }
//        File tempMap = new File("D://Games2/temp");
//        if (tempMap.mkdir()) {
//            System.out.println("Создано!");
//        }
//        File mainMap = new File("D://Games2/src/main");
//        if (mainMap.mkdir()) {
//            System.out.println("Создано!");
//        }
//        File testMap = new File("D://Games2/src/test");
//        if (testMap.mkdir()) {
//            System.out.println("Создано!");
//        }
//
//        File mainFile = new File("D://Games2/src/main/Main.java");
//        try {
//            if ( mainFile.createNewFile()) {
//                System.out.println(" Файл создан ");
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        File utilsFile = new File("D://Games2/src/main/Utils.java");
//        try {
//            if (utilsFile.createNewFile()) {
//                System.out.println(" Файл создан ");
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        File drawablesMap = new File("D://Games2/res/drawables");
//        if (drawablesMap.mkdir()) {
//            System.out.println("Создано!");
//        }
//
//        File vectorsMap = new File("D://Games2/res/vectors");
//        if (vectorsMap.mkdir()) {
//            System.out.println("Создано!");
//        }
//
//        File iconsMap = new File("D://Games2/res/icons");
//        if (iconsMap.mkdir()) {
//            System.out.println("Создано!");
//        }
//
//        File tempFile = new File("D://Games2/temp/temp.txt");
//        try {
//            if ( tempFile.createNewFile()) {
//                System.out.println(" Файл создан ");
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//
//    }

