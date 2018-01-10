package servlets;

import models.Authentication;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import services.SessionService;
import spring.entity.EntityPersonalDataParameter;
import spring.interfaces.PersonalDataParameterDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddPersonalDataParameter",
urlPatterns = "add.personalDataParameter")

public class AddPersonalDataParameter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());


        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        String nameParameter = request.getParameter("name_parameter");
        String idS = request.getParameter("id");
        String token = request.getParameter("token");
        Authentication authentication = new Authentication();
        authentication.setToken(token);
        authentication.setUserId(Long.parseLong(idS));
        JSONObject rspJ = new JSONObject();

        if(SessionService.hasAuth(authentication) && authentication.getRole()==SessionService.ROLE_ADMIN){

            EntityPersonalDataParameter dataParameter  = new EntityPersonalDataParameter();
            dataParameter.setName(nameParameter);
            PersonalDataParameterDao dataParameterDao = ctx.getBean("jpaPersonalDataParameter",PersonalDataParameterDao.class);
            dataParameterDao.save(dataParameter);

            rspJ.put("status",true).put("id",dataParameter.getId());

        }else {
            rspJ.put("error","сессия не найдена или нет прав на создание");
        }
        response.getWriter().print(rspJ);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
