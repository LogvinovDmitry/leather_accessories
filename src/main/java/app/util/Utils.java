package app.util;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class Utils {

    public static String getBasePath(HttpServletRequest request) {
        final String realPath = request.getServletContext().getRealPath("/");// Путь до папки, в которой лежит папка 'file' с картинками
        if (System.getProperty("isLocalRun") == null) {
            return realPath;
        } else {
            return realPath + "..\\..\\..\\";
        }
    }

    public static String replaceSlashesToSystem(String path) {
        return path.replace("/", File.separator)
                .replace("\\", File.separator);
    }
}
