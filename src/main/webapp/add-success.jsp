<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Success page</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
        <div class="container">
            <div class="row col-md-10 col-md-offset-3">
                <div class="card card-body">
                    <h3>Athlete successfully enrolled into sportschool!</h3>
                    <div>
                        <% if (request.getAttribute("name") !=null && request.getAttribute("surname") !=null) {
                            out.println("<p>Person '" +
                                request.getAttribute("name") + "'  '" + request.getAttribute("surname") +
                                    "' added to our sportschool!</p>");
                        }
                        %>
                        </div>
                </div>
            </div>
        </div>
        <div>
            <button onclick="location.href='/JavaEE_hibernate_demo_war_exploded'">Back to main</button>
        </div>
    </body>
    </html>