package first21;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/depart")
public class departmentSer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String departmentIdStr = request.getParameter("departmentId");
        String departmentName = request.getParameter("departmentName");

        int departmentId = 0;
        try {
            departmentId = Integer.parseInt(departmentIdStr);
        } catch (NumberFormatException e) {
    
            e.printStackTrace();
           return;
        }

        department.saveDepartment(departmentId, departmentName);
          response.sendRedirect("successful1.jsp");
    }
}