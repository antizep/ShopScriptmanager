package servlets;

import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import services.FilesUtil;
import spring.entity.EntityPrice;
import spring.entity.EntityProduct;
import spring.entity.EntityProvider;
import spring.interfaces.PriceDao;
import spring.interfaces.ProductDao;

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
import java.util.ArrayList;
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

        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        String nameProduct = request.getParameter("name_product");
        String purchase = request.getParameter("purchase");
        String selling = request.getParameter("selling");
        String description = request.getParameter("description");
        String[] providers = request.getParameterValues("provider[]");

        EntityProduct product = new EntityProduct();
        product.setName(nameProduct);
        product.setDescription(description);
        product.setPurchase(Integer.parseInt(purchase));
        product.setSelling(Integer.parseInt(selling));

        ProductDao productDao = ctx.getBean("jpaProduct",ProductDao.class);

        productDao.save(product);
        PriceDao priceDao = ctx.getBean("jpaPrice",PriceDao.class);

        List<EntityPrice> productsList = new ArrayList<>();

        for(String providerS: providers){

            EntityPrice price= new EntityPrice();
            price.setProductByProduct(product);

            EntityProvider provider = new EntityProvider();
            provider.setId(Long.parseLong(providerS));

            price.setProviderByProvider(provider);
            productsList.add(price);
        }
        priceDao.saveAll(productsList);

        JSONObject ret = new JSONObject();
        ret.put("status","complete");

        //System.out.println(nameProduct+purchase+selling+description);
        List<Part> fileParts = request.getParts().stream().filter(part -> "images".equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
        int i=0;

        for (Part filePart : fileParts) {

            i++;
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String path = getServletContext().getRealPath("/products/"+i+"/employees/");
            System.out.println(path);
            FilesUtil.saveLogo(filePart,path);

        }
        response.getWriter().print(ret);
    }
}


