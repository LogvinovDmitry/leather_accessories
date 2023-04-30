package app.repository.Server;

import app.model.dto.BagDto;
import app.service.UserService;
import app.service.impl.UserServiceImpl;
import app.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ServerRepository {

    private static final String PATH_TO_STORE_OF_IMAGES = "file\\mainPhotoTitle\\";
    private static final String PATH_TO_STORE_OF_OTHER_IMAGES = "file\\otherImages\\";

    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

    public String uploadFile(HttpServletRequest req) {
        String baseFilePath = Utils.getBasePath(req);
//        System.out.println("baseFilePath = " + baseFilePath);
        try {
            Part filePart = req.getPart("file_main_photo_title");

            String fileName = getSubmittedFileName(filePart); //photo_2022-12-05_11-38-23.jpg
            if (fileName == null || fileName.isEmpty()) {
                throw new RuntimeException("Can't submit form without main photo");
            }

            String str = UUID.randomUUID().toString();

            String[] partsOfName = fileName.split("\\.");
            String mime = partsOfName[partsOfName.length - 1];

            File file = new File(
                    Utils.replaceSlashesToSystem(baseFilePath + File.separator + PATH_TO_STORE_OF_IMAGES + str + "." + mime)
            );

            final File parentDirectory = file.getParentFile();
            if (!parentDirectory.exists() && !parentDirectory.mkdirs()) {
                // Папка не существует и не удалось её создать
                System.err.println("Directory '" + parentDirectory + "' does not exist and I can't create it!");
            }

            try (InputStream inputStream = filePart.getInputStream()) {
                Files.copy(inputStream, file.toPath());
                return Utils.makeUrlSlashesFromSystem(file.toString()); // C:/photo_for_leather_accessories/72f12e40-c4d9-48ff-9821-b92b09e4213c.jpg
            }

            //При появлении иключения в консоль выведется сообщение и метод продолжит выполняться (и продолжает выполнятся с вся программа).
            //А метод должен заканчиваться ретерном. Поэтому в начале необходимо назначить переменную как нулл в блоке
            //try присвоить ей необходимое значение и в конце ретернуть.

            //В ситуации, когда мы обрабатываем исключение так как сейчас (подсвеченная часть кода),
            //при исключении метод останавливается как все выполнение программы.
            //Поэтому ретерн можно писать там, где он есть сейчас.

//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }

        } catch (IOException | ServletException e) {
            throw new RuntimeException("Couldn't save file", e);
        }


    }

    public List<String> uploadFiles(HttpServletRequest req) {
        String baseFilePath = Utils.getBasePath(req);
//        System.out.println("baseFilePath = " + baseFilePath);
        List<String> listPhoto = new ArrayList<>();

        try {

            List<Part> listPart = new ArrayList<>();

            listPart.add(req.getPart("file_name_1"));
            listPart.add(req.getPart("file_name_2"));
            listPart.add(req.getPart("file_name_3"));
            listPart.add(req.getPart("file_name_4"));
            listPart.add(req.getPart("file_name_5"));
            listPart.add(req.getPart("file_name_6"));
            listPart.add(req.getPart("file_name_7"));
            listPart.add(req.getPart("file_name_8"));
            listPart.add(req.getPart("file_name_9"));


            for (Part filePart : listPart) {


                String fileName = getSubmittedFileName(filePart); //photo_2022-12-05_11-38-23.jpg


                if (fileName != null && !fileName.equals("")) {

                    String str = UUID.randomUUID().toString();

                    String[] partsOfName = fileName.split("\\.");
                    String mime = partsOfName[partsOfName.length - 1];


                    File file = new File(
                            Utils.replaceSlashesToSystem(baseFilePath + File.separator + PATH_TO_STORE_OF_OTHER_IMAGES + str + "." + mime)
                    );

                    final File parentDirectory = file.getParentFile();
                    if (!parentDirectory.exists() && !parentDirectory.mkdirs()) {
                        // Папка не существует и не удалось её создать
                        System.err.println("Directory '" + parentDirectory + "' does not exist and I can't create it!");
                    }

                    try (InputStream inputStream = filePart.getInputStream()) {
                        Files.copy(inputStream, file.toPath());
                        String imagePath = Utils.makeUrlSlashesFromSystem(file.toString());
                        listPhoto.add(imagePath);


                    }
                }
            }
        } catch (IOException | ServletException e) {
            throw new RuntimeException("Couldn't save file", e);
        }

        //System.out.println(listPhoto.size());
        if (listPhoto.size() == 0) {
            throw new RuntimeException("You need to upload at least one secondary photo");
        }
        return listPhoto;
    }

    public void removeFile(BagDto bagDto, String baseFilePath) {

        String mainPhotoTitle = bagDto.getMainPhotoTitle();

        File fileMainPhoto = new File(baseFilePath + File.separator + mainPhotoTitle);
        fileMainPhoto.delete();

        List<String> listPhoto = bagDto.getListPhoto();
        for (String pathPhoto : listPhoto) {
            File otherImage = new File(baseFilePath + File.separator + pathPhoto);
            otherImage.delete();
        }
    }

}



