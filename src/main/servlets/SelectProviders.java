package servlets;

import models.Authentication;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import services.SessionService;
import spring.entity.EntityProvider;
import spring.interfaces.ProviderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectProviders",
urlPatterns = "/SelectProviders")
public class SelectProviders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        String idS = request.getParameter("id");
        String token = request.getParameter("token");

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        JSONObject rspJ = new JSONObject();

        Authentication authentication = new Authentication();

        authentication.setUserId(Long.parseLong(idS));
        authentication.setToken(token);

        if(SessionService.hasAuth(authentication)) {
            if (authentication.getRole() == SessionService.ROLE_ADMIN) {
                ProviderDao repository = ctx.getBean("jpaProviderService", ProviderDao.class);

                List<EntityProvider> providers = repository.selectAll();
                JSONArray providersJ = new JSONArray(providers);
//            for(EntityProvider provider : providers){
//                rspJ.put("provider",provider);
//            }
                rspJ.put("providers", providersJ);
                rspJ.put("authentication", true);
            }else{
                rspJ.put("authentication", false);
                rspJ.put("error","у вас нет прав для просмотра контента");
            }
        } else {
            rspJ.put("authentication", false);
        }
        response.getWriter().print(rspJ);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
