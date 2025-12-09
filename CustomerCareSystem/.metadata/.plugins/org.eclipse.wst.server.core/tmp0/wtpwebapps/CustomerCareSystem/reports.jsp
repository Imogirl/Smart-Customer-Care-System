<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Dashboard Report</title>
  <link rel="stylesheet" href="Style.css">
  <!-- Chart.js library -->
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>


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
          <li><a href="login.jsp" style="color: darkgray; margin-top: 25px; margin-left: ;">⏻ Logout</a></li>
        </ul>
      </nav>
    </aside>

    <main class="main-chart">
      <h1 class="chart-title">Enrollments(Last 30 days 2025)</h1>
       <canvas id="pieChart"></canvas>
    </main>
 </div>  
 
 <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>



<script>
window.addEventListener('DOMContentLoaded', () => {
  new Chart(document.getElementById('pieChart'), {
    type: 'pie',
    data: {
      labels: ['Registered', 'In‑progress', 'On hold', 'Resolved', 'Closed'],
      datasets: [{
        data: [35, 22, 9, 48, 71],
        backgroundColor: [
          '#4caf50', '#2196f3', '#ff9800', '#9c27b0', '#f44336'
        ],
        borderWidth: 1
      }]
    },
    options: {
      responsive: false,
      maintainAspectRatio: false,
      plugins: {
        legend: {
          position: 'bottom',
          labels: { boxWidth: 14, padding: 16 }
        },
        tooltip: {
          callbacks: {
            label: (ctx) => `${ctx.label}: ${ctx.formattedValue} Enrollments`
          }
        }
      }
    }
  });
});
</script>

</body>
</html>

    