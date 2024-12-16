<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

      let aryData = [['어쩔티비ㅣㅣㅣ','댓글수']]
      
      // ajax 비동기 처리방식
      fetch('chartData.do')
      	.then(result => result.json())
		.then(result => {

			result.forEach(item => {
				aryData.push([item.boardNo ,item.cnt])
			}
			)
		      google.charts.load('current', {'packages':['corechart']});
		      google.charts.setOnLoadCallback(drawChart);
		})
		.catch(err => console.log(err));  
      
      function drawChart() {

        var data = google.visualization.arrayToDataTable(aryData);

        var options = {
          title: '123'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
