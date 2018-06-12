package servlets;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Select",
    urlPatterns = "/select_summ_orders"
)
public class SelectSumm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");


        String idUser=  request.getParameter("id_user");
        String tocken = request.getParameter("tocken");

        /*

            тут будет проверка

         */

        System.out.println("id:"+idUser+" tocken"+tocken);

        double summ = 2000.90;

        JSONObject responseJ = new JSONObject();
        responseJ.put("summ",summ);

        response.getWriter().print(responseJ);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
