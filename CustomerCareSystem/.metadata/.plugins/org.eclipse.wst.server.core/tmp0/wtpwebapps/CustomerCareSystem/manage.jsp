<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Manager Dashboard</title>
  <link rel="stylesheet" href="Style.css" />
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
</head>
<body>
  <div class="dashboard">
    <aside class="sidebar">
     <h2>P.D.Kalindu</h2>
      <nav>
        <ul>
          <li><a href="manage.jsp">🧾 Dashboard</a></li>
          <li><a href="team.jsp">👥 Team</a></li>
          
          <li><a href="reports.jsp">📈 Report</a></li>
          <li><a href="signin.jsp" style="color: darkgray; margin-top: 25px;">⏻ Logout</a></li>
        </ul>
      </nav>
    </aside>

    <main class="main-content">
      <section class="cards">
        <a href="ticket.jsp" class="card-link">
          <div class="card sales">
            <div class="card-icon">🏛</div>
            <div class="card-info">
              <h3>Institute</h3>
              <p>Malabe</p>
            </div>
          </div>
        </a>

        <a href="courses.jsp" class="card-link">
          <div class="card projects">
            <div class="card-icon">📒</div>
            <div class="card-info">
              <h3>Courses</h3>
              <p>120+</p>
            </div>
          </div>
        </a>

        <a href="students.jsp" class="card-link">
          <div class="card employees">
            <div class="card-icon">👩🏼‍🎓</div>
            <div class="card-info">
              <h3>Students</h3>
              <p>1000 Students</p>
            </div>
          </div>
         
        </a>

        <a href="reports.jsp" class="card-link">
          <div class="card reports">
            <div class="card-icon">📊</div>
            <div class="card-info">
              <h3>Report</h3>
              <p>Last 30 days</p>
            </div>
          </div>
        </a>
      </section>
    </main>
  </div>
</body>
</html>
