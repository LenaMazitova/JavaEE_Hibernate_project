<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Add new coach</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
    <div class="container">
        <div class="row text-center" style="color: tomato;">
            <h2>Add new coach with JSP, Servlet and Hibernate</h2>
        </div>
        <hr>
        <div class="row col-md-10 col-md-offset-3">

            <div class="card card-body">

                <h2>Add coach form</h2>
                <div class="col-md-8 col-md-offset-3">

                    <form action="<%=request.getContextPath()%>/add_new_coach" method="post">

                        <div class="form-group">
                            <label for="uname">Name:</label>
                            <input type="text" class="form-control" id="uname" placeholder="Name" name="name" required>
                        </div>

                        <div class="form-group">
                            <label for="uname">Surname:</label>
                            <input type="text" class="form-control" id="uname" placeholder="Surname" name="surname" required>
                        </div>

                        <div class="form-group">
                            <label for="uname">Enter status (1 -resident, 2 - non-resident):</label>
                            <input type="text" class="form-control" id="uname" placeholder="Status" name="status" required>
                        </div>

                        <div class="form-group">
                            <label for="uname">Choose the number of speciality (1 - fitness, 2 - athletics):</label>
                            <input type="text" class="form-control" id="uname" placeholder="Speciality" name="speciality_id" required>
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