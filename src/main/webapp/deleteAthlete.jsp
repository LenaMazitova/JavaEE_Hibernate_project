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
            <h2>Delete athlete with JSP, Servlet and Hibernate</h2>
        </div>
        <hr>
        <div class="row col-md-10 col-md-offset-3">

            <div class="card card-body">

                <h2>Delete athlete form</h2>
                <div class="col-md-8 col-md-offset-3">

                    <form action="<%=request.getContextPath()%>/delete" method="post">

                        <div class="form-group">
                            <label for="uname">Enter id-number of expelling athlete:</label>
                            <input type="text" class="form-control" id="uname" placeholder="Id" name="id" required>
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