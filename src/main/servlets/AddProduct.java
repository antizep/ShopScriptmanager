package servlets;

import services.FilesUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "AddProduct",
        urlPatterns = "/AddProduct")
@MultipartConfig
//не использовать очень сырая версия
public class AddProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        String nameProduct = request.getParameter("name_product");
        String purchase = request.getParameter("purchase");
        String selling = request.getParameter("selling");
        String description = request.getParameter("description");


        System.out.println(nameProduct+purchase+selling+description);
        List<Part> fileParts = request.getParts().stream().filter(part -> "images".equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
        int i=0;

        for (Part filePart : fileParts) {

            i++;
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String path = getServletContext().getRealPath("/products/"+i+"/employees/");
            System.out.println(path);
            FilesUtil.saveLogo(filePart,path);

        }
    }
}


