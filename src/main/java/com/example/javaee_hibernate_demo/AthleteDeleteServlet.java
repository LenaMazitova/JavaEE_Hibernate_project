package com.example.javaee_hibernate_demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class AthleteDeleteServlet extends HttpServlet {

    private AthleteDAO athleteDAO;

    public void init() {
        athleteDAO = new AthleteDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        Integer idForDelete = Integer.parseInt(id);

        if (athleteDAO.deleteAthlete(idForDelete)) {
            request.setAttribute("id", id);

            RequestDispatcher dispatcher = request.getRequestDispatcher("delete-success.jsp");
            dispatcher.forward(request, response);
        } else {
            PrintWriter pw = response.getWriter();
            pw.println("<html>" + "<body>Something went wrong</body>" + "</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.sendRedirect("deleteAthlete.jsp");
    }

}
