package servlets;

import models.Authentication;
import org.json.JSONObject;
import services.SessionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Exit", urlPatterns = "/exit")
public class Exit extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        try {

            long id = Long.parseLong(request.getParameter("id"));
            String token = request.getParameter("token");
            Authentication authentication = new Authentication();

            authentication.setToken(token);
            authentication.setUserId(id);

            SessionService.deleteAuthentication(authentication);
            JSONObject  rsp= new JSONObject();
            rsp.put("status","ok");

            response.getWriter().print(rsp);

        }catch (NumberFormatException e){

            e.printStackTrace();

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
