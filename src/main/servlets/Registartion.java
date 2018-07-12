package servlets;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import spring.entity.EntityAuthentication;
import spring.entity.EntityRoles;
import spring.interfaces.AuthenticationDao;
import spring.interfaces.RoleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Registartion" , urlPatterns = "/registration")
public class Registartion extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject requestJ = new JSONObject(request.getParameter("request"));
        JSONObject responseJ = new JSONObject();
        try{
            WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
            EntityAuthentication entityAuthentication = new EntityAuthentication(requestJ);


            RoleDao roleDao = ctx.getBean("jpaAuntificationRoleService",RoleDao.class);
            EntityRoles entityRoles = roleDao.findByName("buyer");
            entityAuthentication.setRole(entityRoles);

            AuthenticationDao authenticationDao = ctx.getBean("jpaAuthenticationService", AuthenticationDao.class);

            if(!authenticationDao.searshByLogin(entityAuthentication.getLogin())){
                authenticationDao.save(entityAuthentication);
                requestJ.put("status","ok");

            }else {

                responseJ.put("status","error").put("error","логин занят");

            }


        }catch (JSONException e ){
            responseJ.put("error","Отсутствуют параметры");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
