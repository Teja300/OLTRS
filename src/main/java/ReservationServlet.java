import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReservationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        response.setContentType("text/html");

        response.getWriter().println(
            "<h1>Reservation Request Received!</h1>"
        );
    }
}