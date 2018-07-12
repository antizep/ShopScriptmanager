package servlets;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import spring.entity.EntityCaruselSchedule;
import spring.interfaces.CaruselScheduleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "SelectCarousel", urlPatterns = "/select.carousel")
public class SelectCarousel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        CaruselScheduleDao caruselScheduleDao = ctx.getBean("jpaCarouselSchedule",CaruselScheduleDao.class);
        Date today = new Date(new java.util.Date().getTime());

        List<EntityCaruselSchedule> caruselScheduleList = caruselScheduleDao.findBeforeDatef(today,today);
        JSONArray imagesJ = new JSONArray();

        for(EntityCaruselSchedule caruselSchedule :caruselScheduleList) {

            File path = new File(System.getProperty("upload.dir") + "/img/carusel/"+caruselSchedule.getId());
            File[] images = path.listFiles();

            for (File image:images){

                String filePath = image.getCanonicalPath();
                String fileUrl = filePath.split("/uploads")[1];
                imagesJ.put(fileUrl);
                //System.out.println(fileUrl);

            }

        }
        JSONObject responseJ = new JSONObject();
        responseJ.put("carouselImages", imagesJ);
        responseJ.put("authentication",true);
        response.getWriter().print(responseJ);
//        System.out.println(caruselScheduleList);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
