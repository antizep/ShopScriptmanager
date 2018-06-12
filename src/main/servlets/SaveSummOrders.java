package servlets;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveSummOrders",
urlPatterns = "/save_summ_oerders")
public class SaveSummOrders extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");


        String idUser=  request.getParameter("id_user");
        String tocken = request.getParameter("tocken");
        String summOrdersS = request.getParameter("summ_orders");
        try {

            double summ = Double.parseDouble(summOrdersS);

        }catch (NumberFormatException e){
            JSONObject error = new JSONObject();

            error.put("error","Ошибка формата номера: summ_orders="+summOrdersS);

            response.getWriter().print(error);
            return;
        }


        JSONObject responseJ = new JSONObject();
        responseJ.put("status","ok");

        response.getWriter().print(responseJ);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
