package servlets;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import services.FilesUtil;
import spring.entity.EntityCaruselSchedule;
import spring.interfaces.CaruselScheduleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "AddCarusel",urlPatterns = "/AddCarusel")
@MultipartConfig

public class AddCarusel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        String remark = request.getParameter("remark");
        String dateStart = request.getParameter("dateStart");
        String dateFinish = request.getParameter("dateFinish");

        WebApplicationContext ctx= WebApplicationContextUtils.getWebApplicationContext(getServletContext());

        CaruselScheduleDao caruselScheduleDao = ctx.getBean("jpaCarouselSchedule",CaruselScheduleDao.class);

        EntityCaruselSchedule caruselSchedule = new EntityCaruselSchedule();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {

            Date datef = new Date(dateFormat.parse(dateFinish).getTime());
            Date dates = new Date(dateFormat.parse(dateStart).getTime());

            caruselSchedule.setDateF(datef);
            caruselSchedule.setDateS(dates);

            caruselSchedule.setRemark(remark);

            caruselScheduleDao.save(caruselSchedule);

            System.out.println(remark+"|"+dateStart+"|"+dateFinish);

            List<Part> fileParts = request.getParts().stream().filter(part -> "images".equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
            int i=0;

            for (Part filePart : fileParts) {

                i++;
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

                FilesUtil.setImageName(i + ".");

                String path = System.getProperty("upload.dir") + "/img/carusel/" + caruselSchedule.getId() + "/";
                System.out.println(path);

                FilesUtil.saveLogo(filePart, path);

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
