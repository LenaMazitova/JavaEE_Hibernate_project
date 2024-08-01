package com.example.javaee_hibernate_demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add_new_coach")
public class CoachAddServlet extends HttpServlet {

    private CoachDAO coachDAO;

    public void init() {
        coachDAO = new CoachDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Integer status = Integer.parseInt(request.getParameter("status"));
        Integer speciality_id = Integer.parseInt(request.getParameter("speciality_id"));

        Coach coach = new Coach();
        coach.setName(name);
        coach.setSurname(surname);
        coach.setStatus(status);

        if (coachDAO.saveCoach(coach, speciality_id)) {
            request.setAttribute("name", name);
            request.setAttribute("surname", surname);

            RequestDispatcher dispatcher = request.getRequestDispatcher("add-success.jsp");
            dispatcher.forward(request, response);
        } else {
            PrintWriter pw = response.getWriter();
            pw.println("<html>" + "<body>Something went wrong</body>" + "</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.sendRedirect("addCoach.jsp");
    }

}
