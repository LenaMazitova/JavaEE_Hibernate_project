<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Add athlete</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    </head>

    <body>
        <div class="container">
            <div class="row text-center" style="color: tomato;">
                <h2>Add athlete with JSP, Servlet and Hibernate</h2>
            </div>
            <hr>
            <div class="row col-md-10 col-md-offset-3">

                <div class="card card-body">

                    <h2>Enroll athlete form</h2>
                    <div class="col-md-8 col-md-offset-3">

                        <form action="<%=request.getContextPath()%>/add_athlete" method="post">

                            <div class="form-group">
                                <label for="uname">Name:</label> <input type="text" class="form-control" id="uname"
                                    placeholder="Name" name="name" required>
                            </div>

                            <div class="form-group">
                                <label for="uname">Surname:</label> <input type="text" class="form-control" id="uname"
                                    placeholder="Surname" name="surname" required>
                            </div>

                            <div class="form-group">
                                <label for="uname">Enter coach id:</label> <input type="text" class="form-control"
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