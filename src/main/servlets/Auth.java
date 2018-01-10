package servlets;

import models.Authentication;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import services.GenerateToken;
import services.SessionService;
import spring.entity.EntityAuthentication;
import spring.interfaces.AuthenticationDao;

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
        EntityAuthentication entityAuthentication = new EntityAuthentication();

        entityAuthentication.setLogin(login);
        entityAuthentication.setPassword(password);

        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        AuthenticationDao service = ctx.getBean("jpaAuthenticationService", AuthenticationDao.class);

        entityAuthentication = service.auntification(entityAuthentication);

        if(entityAuthentication != null) {

            Authentication authentication = new Authentication();

            authentication.setLogin(entityAuthentication.getLogin());
            authentication.setUserId(entityAuthentication.getId());
            authentication.setToken(GenerateToken.generateToken(authentication));

            authentication.setRole(entityAuthentication.getRole().getIdRole());

            JSONObject auth =new JSONObject();

            auth.put("id", authentication.getUserId());
            auth.put("token", authentication.getToken());
            auth.put("role", entityAuthentication.getRole().getIdRole());
            SessionService.addAuthentication(authentication);

            response.getWriter().print(auth);

        }else{
            response.getWriter().print(new JSONObject().put("error","no user"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
