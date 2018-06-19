package servlets;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebFilter(filterName = "ImageFilter",
urlPatterns = "/img/*")
public class ImageFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request  = (HttpServletRequest) req;
        String URI = System.getProperty("upload.dir")+request.getRequestURI();
        File image = new File(URI);
        if(!image.exists()){
            image = new File(System.getProperty("upload.dir")+"/img/default.jpg");
        }
        resp.setContentType(new MimetypesFileTypeMap().getContentType(image));

        try(BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream())) {
            FileInputStream fis = new FileInputStream(image);

            int c;

            while ((c = fis.read()) != -1){
                bos.write(c);
            }

            bos.flush();

        }catch (FileNotFoundException e){

            chain.doFilter(req,resp);

        }
        System.out.println(new MimetypesFileTypeMap().getContentType(image));

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
