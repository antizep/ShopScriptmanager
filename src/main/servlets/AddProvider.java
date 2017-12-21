package servlets;

import models.Authentification;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import services.FilesUtil;
import services.SessionService;
import spring.entity.EntityProvider;
import spring.interfaces.AuthenticationDao;
import spring.interfaces.ProviderDao;
import spring.repositories.ProviderRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "AddProvider", urlPatterns = "/addProvider")
@MultipartConfig

public class AddProvider extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        AuthenticationDao service = ctx.getBean("jpaAuthenticationService", AuthenticationDao.class);

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        String name = request.getParameter("name");
        String idS = request.getParameter("id");
        String token = request.getParameter("token");
        String minimum = request.getParameter("minimum");
        String URL = request.getParameter("URL");
        String remark = request.getParameter("remark");
        Authentification authentification = new Authentification();

        authentification.setUserId(Long.parseLong(idS));
        authentification.setToken(token);

        if(SessionService.hasAuth(authentification)){

            EntityProvider provider = new EntityProvider();

            provider.setUrl(URL);
            provider.setName(name);
            provider.setRemark(remark);
            provider.setMinPay(Long.valueOf(minimum));

            ProviderDao repository = ctx.getBean("jpaProviderService",ProviderDao.class);

            repository.save(provider);

        }else{
            response.getWriter().print("Токен неверен!");
        }

        response.getWriter().print(".!.");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
