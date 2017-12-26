package servlets;

import org.json.JSONArray;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import spring.entity.EntityPrice;
import spring.interfaces.PriceDao;
import spring.interfaces.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectProduct",
urlPatterns = "/SelectProduct")
public class SelectProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        PriceDao priceDao = ctx.getBean("jpaPrice", PriceDao.class);

        List<EntityPrice> prices = priceDao.findAll();

        JSONArray pricesJ = new JSONArray(prices);

        response.getWriter().print(pricesJ);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
