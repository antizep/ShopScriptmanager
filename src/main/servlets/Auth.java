package servlets;

import models.Authentification;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import services.GenerateToken;
import services.SessionService;
import spring.entity.AuthenticationEntity;
import spring.interfaces.AuthenticationDao;
import spring.interfaces.RoleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Auth",
urlPatterns = "/auth")
public class Auth extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        AuthenticationEntity authenticationEntity = new AuthenticationEntity();

        authenticationEntity.setLogin(login);
        authenticationEntity.setPassword(password);

        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        AuthenticationDao service = ctx.getBean("jpaAuthenticationService", AuthenticationDao.class);

        authenticationEntity = service.auntification(authenticationEntity);

        if(authenticationEntity != null) {

            Authentification authentification = new Authentification();

            authentification.setLogin(authenticationEntity.getLogin());
            authentification.setUserId(authenticationEntity.getId());
            authentification.setToken(GenerateToken.generateToken(authentification));

            JSONObject auth =new JSONObject();

            auth.put("id",authentification.getUserId());
            auth.put("token",authentification.getToken());
            auth.put("role",authenticationEntity.getRole().getIdRole());
            SessionService.addAuthentication(authentification);

            response.getWriter().print(auth);

        }else{
            response.getWriter().print(new JSONObject().put("error","no user"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
