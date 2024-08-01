package com.example.javaee_hibernate_demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {

    private AthleteDAO athleteDAO;
    private CoachDAO coachDAO;

    public void init() {
        coachDAO = new CoachDAO();
        athleteDAO = new AthleteDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Athlete> athletes = athleteDAO.allAthletes();
        List<Coach> coaches = coachDAO.allCoaches();

        request.setAttribute("athletes", athletes);
        request.setAttribute("coaches", coaches);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }
}