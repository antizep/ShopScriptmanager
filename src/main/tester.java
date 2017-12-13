package main;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import spring.entity.RolesEntity;
import spring.interfaces.RoleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlets.te",
        urlPatterns = "/te")
public class tester extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
//        RoleDao service = ctx.getBean("jpaAuntificationService", RoleDao.class);
//
//        RolesEntity e = service.findById(1);
//        System.out.println(e+"222");
//        response.getWriter().print(e);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}