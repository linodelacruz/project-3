package web.app.counter;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ldela
 */
@WebServlet("/index")
public class WebAppCounter extends HttpServlet {
    
    protected void incrementSessionCounter(HttpServletRequest request){
        Counter count = (Counter) request.getSession().getAttribute("sessionCounter");
        if (count == null) {
            count = new Counter();
            request.getSession().setAttribute("sessionCounter", count);
        }
        count.incrementCount();
        
    }
    
    protected void incrementApplicationCounter(ServletContext servletContext) {
        Counter count = (Counter)servletContext.getAttribute("globalCounter");
        if (count == null) {
            count = new Counter();
            servletContext.setAttribute("globalCounter", count);
        }
        count.incrementCount();
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       incrementSessionCounter(request);
       incrementApplicationCounter(getServletContext());
       
       getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

   
}
