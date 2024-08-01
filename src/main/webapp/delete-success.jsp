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
            <h3>Athlete expelled from sportschool!</h3>
            <div>
                <% if (request.getAttribute("id") !=null) {
                    out.println("<p>Athlete with id-number '" +
                            request.getAttribute("id")  +
                            "' expelled from sportschool!</p>");
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
