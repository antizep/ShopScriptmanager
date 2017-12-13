package servlets;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
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
urlPatterns = "auth")
public class Auth extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        AuthenticationEntity authenticationEntity = new AuthenticationEntity();

        authenticationEntity.setLogin(login);
        authenticationEntity.setPassword(password);
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        AuthenticationDao service = ctx.getBean("jpaAuthenticationService", AuthenticationDao.class);
        authenticationEntity = service.auntification(authenticationEntity);

        response.getWriter().print(authenticationEntity.getId());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
