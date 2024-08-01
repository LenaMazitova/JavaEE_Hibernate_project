<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Sportschool</title>
    </head>

    <body>
        <div>
            <h1>Welcome to our sportschool!</h1>
        </div>
        <div>
            <button onclick="location.href='/JavaEE_hibernate_demo_war_exploded/list'">List of all athletes and coaches</button>
            <button onclick="location.href='/JavaEE_hibernate_demo_war_exploded/add_athlete'">Enroll the athlete</button>
            <button onclick="location.href='/JavaEE_hibernate_demo_war_exploded/add_new_coach'">Add new coach</button>
            <button onclick="location.href='/JavaEE_hibernate_demo_war_exploded/update'">Update the athlete</button>
            <button onclick="location.href='/JavaEE_hibernate_demo_war_exploded/delete'">Delete the athlete</button>
        </div>

    </body>
</html>