package app.repository;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

@WebServlet(urlPatterns = {"/file-servlet"})
@MultipartConfig()
public class FileServlet extends HttpServlet {
    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Part part : req.getParts()) {
            if (part.getName().equals("text-name")) {
                InputStream inputStream = part.getInputStream();
                String s = IOUtils.toString(inputStream, "UTF-8");//Деает из стрима строку
                req.setAttribute("sec", s);
            }

            String str = UUID.randomUUID().toString();
            if (part.getName().equals("file-name")) {
                String fileName = getSubmittedFileName(part);

                try (InputStream inputStream = part.getInputStream();
                    OutputStream outputStream = new FileOutputStream("C:\\Users\\Дмитрий\\leather_accessories\\file\\" + str + fileName))
                {
                    IOUtils.copy(inputStream, outputStream);
                }
            }
        }

        getServletContext().getRequestDispatcher("/renderForm.jsp").forward(req, resp);

    }
}