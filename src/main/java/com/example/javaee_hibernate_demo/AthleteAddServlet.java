package com.example.javaee_hibernate_demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add_athlete")
public class AthleteAddServlet extends HttpServlet {

    private AthleteDAO athleteDAO;

    public void init() {
        athleteDAO = new AthleteDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Integer coach_id = Integer.parseInt(request.getParameter("coach_id"));

        Athlete athlete = new Athlete();
        athlete.setName(name);
        athlete.setSurname(surname);
        athlete.setCoach_id(coach_id);

        boolean flag = athleteDAO.saveAthlete(athlete);
        if (flag) {
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
        response.sendRedirect("add-athlete.jsp");
    }

}
