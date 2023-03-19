package app.controller.user;

import app.controller.Command;
import app.util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DisplayFileCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String baseFilePath = Utils.getBasePath(request);
//        System.out.println("baseFilePath = " + baseFilePath);

        File file = new File(baseFilePath + request.getParameter("path")); //Получаем фаил, что бы дальше с ним работать (request.getParameter("path"); //Путь по которому находится запрашиваемый
                                                              // фаил: file/619484b4-b89b-4094-ba8b-e1da87f39862photo_2022-12-05_11-38-23.jpg)

        String contentType = request.getSession().getServletContext().getMimeType(file.getName()); //image/jpeg  (file.getName() - 619484b4-b89b-4094-ba8b-e1da87f39862photo_2022-12-05_11-38-23.jpg)
        response.reset();    //Сбрасывает все данные, которые хранятся в буфере, заголовки и коды ответа.
        response.setBufferSize(10240);
        response.setContentType(contentType); //Устанавливаем тип передаваемых данных в респонзе. В данном случае "image/jpeg".
                                              // Разновидностей много.. загугли "список типов MIME")

//Зачем устанавливать эти Хедеры?? и зачем делать response.reset(); и response.setBufferSize(10240); ???????????7
        response.setHeader("Content-Type", contentType);
        response.setHeader("Content-Length", String.valueOf(file.length()));  // String.valueOf - преобразует различные типы значений в строку.
        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");


        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(file), 10240); //Класс BufferedInputStream – классический представитель обертки-буфера. Он – класс-обертка над InputStream. При чтении данных из него, он читает их из оригинального InputStream’а большими порциями в буфер, а потом отдает из буфера потихоньку. По умолчанию размер буфера: private static int DEFAULT_BUFFER_SIZE = 8192;
             BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream(), 10240)) {  // 10240байт - означает кусками какого размера будет копироваться файл.
            byte[] buffer = new byte[10240]; //создание, то есть, выделение памяти для массива на 10240 элементов типа byte

            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);          //это означает: «записать содержимое buffer в BufferedOutputStream начиная с цифры по индексом "0" до посленей цифры с индексом "length". Однако если бы у вас был буфер, содержащий 100 байт, и вы хотели бы записать только средние 80, вы бы сказали write( buffer, 10, 80 ).

            }

        } catch (IOException e) {
            throw new RuntimeException("Couldn't read/write file: " + e.getMessage());
        }
    }
}


// Альтернативный менее рациональный метод без использования буфера. (Все работает)
//        try (FileInputStream in = new FileInputStream(file);
//            OutputStream out = response.getOutputStream()){
//            byte[] buf = new byte[1024];
//            int count = 0;
//            while ((count = in.read(buf)) >= 0) {
//                out.write(buf, 0, count);
//            }
//
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//}