package app.repository.impl;

import app.repository.AdminRepository;
import app.util.ConnectionLeatherAccessoriesSchema;

import javax.servlet.http.Part;

public class AdminRepositoryImpl implements AdminRepository {
    private static final String INSERT_NEW = "INSERT INTO leather_accessories_schema.bag_information_1 VALUES (NULL, ?, ?, ?, ?, ?)";
    private static final String DEL = "DELETE FROM leather_accessories_schema.bag_information_1 WHERE bag_id = ?";
    ConnectionLeatherAccessoriesSchema conLeather = new ConnectionLeatherAccessoriesSchema();

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
    public void create() {
        System.out.print("qqqqqqqqqqqqqqqqqqqq");
    }
}
