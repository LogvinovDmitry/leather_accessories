package app.repository.Server;

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
import java.util.UUID;


public class ServerRepository {

    //final private String PATH_TO_STORE_OF_IMAGES = "C:\\Users\\Дмитрий\\leather_accessories\\file\\";
    final private String PATH_TO_STORE_OF_IMAGES = "C:\\photo_for_leather_accessories\\";

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
        try {
            Part filePart = req.getPart("file_main_photo_title");

            String fileName = getSubmittedFileName(filePart); //photo_2022-12-05_11-38-23.jpg
            String str = UUID.randomUUID().toString();

            String[] partsOfName = fileName.split("\\.");
            String mime = partsOfName[partsOfName.length - 1];


            File file = new File(PATH_TO_STORE_OF_IMAGES + str + "." + mime);

            try (InputStream inputStream = filePart.getInputStream()) {
                Files.copy(inputStream, file.toPath());
                String imagePath = file.toString().replaceAll("\\\\", "/");
                return imagePath; // C:/photo_for_leather_accessories/72f12e40-c4d9-48ff-9821-b92b09e4213c.jpg
            }


            //Так не работает Ретерн!! не вписіваеться в нужное место
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }

        } catch (IOException | ServletException e) {
            throw new RuntimeException("Couldn't save file", e);
        }


    }


}


//        try {
//            Part filePart = req.getPart("file_main_photo_title");
//filePart.getFileName();
//filePart.getSubmittedFileName();
//
//
//            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//            String mime = FileName.getMime(fileName);
//            File file = File.createTempFile(partOfFileName, "." + mime, new File(pathToStore));
//
//            try( InputStream inputStream = filePart.getInputStream()) {
//                Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
//
//
//                return file.toString().replaceAll("\\\\","/");
//
//            }
//        } catch (IOException | ServletException e) {
//            throw new RuntimeException("Couldn't save file", e);
//        }
//    }


