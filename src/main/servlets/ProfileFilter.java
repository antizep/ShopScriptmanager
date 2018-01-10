package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebFilter(filterName = "ProfileFilter",
urlPatterns = "/profile/*")

public class ProfileFilter implements Filter {
    private final String  ENCODING_UTF_8 = "UTF-8";
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request  = (HttpServletRequest) req;
        resp.setContentType("text/html;charset=UTF-8");
        String path = request.getServletContext().getRealPath("/WEB-INF/classes/html_templates/");

        String heed = readFileAsString( path+"/heed.html",ENCODING_UTF_8);
        String body = readFileAsString(path+"/profile.html",ENCODING_UTF_8);
        StringBuilder builder = new StringBuilder();

        builder.append(heed);
        builder.append(body);

        resp.getWriter().print(new String(builder));
    }

    public void init(FilterConfig config) throws ServletException {

    }

    private String readFileAsString(String filePath, String fileEncoding) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(filePath));
        try {
            long len = new File(filePath).length();
            if (len > Integer.MAX_VALUE) {
                throw new IOException("File "+filePath+" too large, was "+len+" bytes.");
            }
            byte[] bytes = new byte[(int) len];
            dis.readFully(bytes);
            return new String(bytes, fileEncoding);
        } finally {
            dis.close();
        }
    }

}
