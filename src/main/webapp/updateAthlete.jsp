<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Update athlete</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    </head>

    <body>
    <div class="container">
        <div class="row text-center" style="color: tomato;">
            <h2>Update athlete with JSP, Servlet and Hibernate</h2>
        </div>
        <hr>
        <div class="row col-md-10 col-md-offset-3">

            <div class="card card-body">

                <h2>Update athlete form</h2>
                    <div>
                    <% if (request.getAttribute("name") !=null && request.getAttribute("surname") !=null) {
                        out.println("<p>Athlete '" +
                                request.getAttribute("name") + "' '" +
                                request.getAttribute("surname")+ "' updated!</p>");
                    }
                    %>
                    </div>
                    <div class="col-md-8 col-md-offset-3">

                        <form action="<%=request.getContextPath()%>/update" method="post">
                            <div class="form-group">
                                <label for="uname">Enter id:</label> <input type="text" class="form-control" id="uname"
                                                                    placeholder="Id" name="id" required>
                            </div>
                            <div class="form-group">
                                <label for="uname">Change name:</label> <input type="text" class="form-control" id="uname"
                                                                    placeholder="Name" name="name" required>
                            </div>

                            <div class="form-group">
                                <label for="uname">Change surname:</label> <input type="text" class="form-control" id="uname"
                                                                       placeholder="Surname" name="surname" required>
                            </div>

                            <div class="form-group">
                                <label for="uname">Change the coach(define id number of coach):</label> <input type="text" class="form-control"
                                                                              id="uname" placeholder="CoachId" name="coach_id" required>
                            </div>

                            <button type="submit" class="btn btn-primary">Submit</button>

                        </form>

                    </div>
            </div>
        </div>
    </div>
    <div>
        <button onclick="location.href='/JavaEE_hibernate_demo_war_exploded'">Back to main</button>
    </div>
    </body>

    </html>