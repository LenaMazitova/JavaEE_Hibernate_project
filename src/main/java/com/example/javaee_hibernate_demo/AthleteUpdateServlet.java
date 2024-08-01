package com.example.javaee_hibernate_demo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/update")
public class AthleteUpdateServlet extends HttpServlet {

    private AthleteDAO athleteDAO;

    public void init() {
        athleteDAO = new AthleteDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer idForUpdate = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String coach_id = request.getParameter("coach_id");

        if (athleteDAO.updateAthlete(idForUpdate, name, surname, coach_id)){
            request.setAttribute("name", name);
            request.setAttribute("surname", surname);

            RequestDispatcher dispatcher = request.getRequestDispatcher("update-success.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.sendRedirect("updateAthlete.jsp");
    }

}
