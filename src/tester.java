import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import spring.entity.EntityAuntification;
import spring.interfaces.AuntificationService;

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

        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        AuntificationService service = ctx.getBean("jpaAuntificationService", AuntificationService.class);
        EntityAuntification e = service.auntification("parazit", "3333");
        response.getWriter().print(e.getUserId());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}