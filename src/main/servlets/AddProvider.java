package servlets;

import models.Authentication;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import services.SessionService;
import spring.entity.EntityProvider;
import spring.interfaces.ProviderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddProvider", urlPatterns = "/addProvider")
@MultipartConfig

public class AddProvider extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        //AuthenticationDao service = ctx.getBean("jpaAuthenticationService", AuthenticationDao.class);

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        String name = request.getParameter("name");
        String idS = request.getParameter("id");
        String token = request.getParameter("token");
        String minimum = request.getParameter("minimum");
        String URL = request.getParameter("URL");
        String remark = request.getParameter("remark");

        Authentication authentication = new Authentication();

        authentication.setUserId(Long.parseLong(idS));
        authentication.setToken(token);

        if(SessionService.hasAuth(authentication)){

            EntityProvider provider = new EntityProvider();

            provider.setUrl(URL);
            provider.setName(name);
            provider.setRemark(remark);
            provider.setMinPay(Long.valueOf(minimum));

            ProviderDao repository = ctx.getBean("jpaProviderService",ProviderDao.class);

            repository.save(provider);

            response.getWriter().print(new JSONObject()
                    .put("status","complete")
                    .put("id",provider.getId()));

        }else{

            response.getWriter().print(new JSONObject().put("error","Токен неверен!"));

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
