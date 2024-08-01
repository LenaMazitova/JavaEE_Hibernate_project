<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="com.example.javaee_hibernate_demo.Athlete" import="com.example.javaee_hibernate_demo.Coach" import="java.util.List" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <title>All of athletes and coaches</title>
        </head>

        <body>
            <h1>List of athletes</h1>
            <% List<Athlete> athletes = (List<Athlete>) request.getAttribute("athletes");

                if (athletes != null && !athletes.isEmpty()) {
                    out.println("<ui>");
                    for (Athlete a : athletes) {
                        out.println("<li>Athlete: '" + a.getId() + "' '" + a.getName() + "' '" +
                                a.getSurname() + "'; Coach id: '" + a.getCoach_id() + "</li>");
                    }
                    out.println("</ui>");
                } else out.println("<p>There are no athletes yet!</p>");
            %>
            <br />
            <br />
            <h1>List of coaches</h1>
            <% List<Coach> coaches = (List<Coach>) request.getAttribute("coaches");

                if (coaches != null && !coaches.isEmpty()) {
                    out.println("<ui>");
                    for (Coach c : coaches) {
                        out.println("<li>Coach: '" + c.getId() + "' '" + c.getName() + "' '" + c.getSurname() +
                                ". Wards students: '" + c.getAthletes() + "</li>");
                    }
                    out.println("</ui>");
                } else out.println("<p>There are no coaches yet!</p>");
            %>
            <div>
                <button onclick="location.href='/JavaEE_hibernate_demo_war_exploded'">Back to main</button>
            </div>
        </body>

        </html>