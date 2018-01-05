package servlets;

import models.Authentification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import services.SessionService;
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
urlPatterns = "/SelectProducts")
public class SelectProducts extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        Authentification authentification = new Authentification();

        String idS = request.getParameter("id");
        String token = request.getParameter("token");

        authentification.setUserId(Long.parseLong(idS));
        authentification.setToken(token);

        if(SessionService.hasAuth(authentification)) {

            WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

            PriceDao priceDao = ctx.getBean("jpaPrice", PriceDao.class);

            List<EntityPrice> prices = priceDao.findAll();

            JSONArray pricesJ = new JSONArray(prices);
            JSONObject responseJ = new JSONObject();
            if(authentification.getRole() != SessionService.ROLE_ADMIN){
                for(int i=0; i<pricesJ.length();i++){
                    System.out.println(pricesJ.getJSONObject(i));
                    pricesJ.getJSONObject(i).getJSONObject("productByProduct").remove("purchase");
                    pricesJ.getJSONObject(i).remove("providerByProvider");
                }
            }

            responseJ.put("products", pricesJ);
            responseJ.put("authentication",true);
            response.getWriter().print(responseJ);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
