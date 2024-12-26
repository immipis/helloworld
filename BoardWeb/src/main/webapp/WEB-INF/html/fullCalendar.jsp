<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='./dist/index.global.js'></script>
<script>

  document.addEventListener('DOMContentLoaded', function() {
	let eventDate;
	fetch('fullData.do')
  	.then(result => result.json())
	.then(result => {
		eventDate=result
		var calendarEl = document.getElementById('calendar');

	    var calendar = new FullCalendar.Calendar(calendarEl, {
	      headerToolbar: {
	        left: 'prev,next today',
	        center: 'title',
	        right: 'dayGridMonth,timeGridWeek,timeGridDay'
	      },
	      initialDate: '2024-12-16',
	      navLinks: true, // can click day/week names to navigate views
	      selectable: true,
	      selectMirror: true,
	      select: function(arg) {
	    	
	  		var title = prompt('이벤트를 등록하세요:');
	  			if (title) {
	  	        
	  	    fetch('AddEvent.do?a='+title+'&b='+arg.startStr+'&c='+arg.endStr)
	  	        .then(result => result.json())
	  	  		.then(result => {
	  	  			if(result.retCode=="OK"){
		  		          calendar.addEvent({
			  		            title: title,
			  		            start: arg.start,
			  		            end: arg.end,
			  		            allDay: arg.allDay
			  		          })
	  	  			}
	  	  		})
	  	  		.catch(err => console.log(err)); 
	        }
	        calendar.unselect()
	      },
	      eventClick: function(arg) {
	    	  console.log(arg)
	        if (confirm('삭제하겟습니까?')) {
	        	fetch('DelEvent.do?a='+arg.event.title)
	  	        .then(result => result.json())
	  	  		.then(result => {
	  	  			arg.event.remove()
	  	  			console.log("삭제완료");
	  	  		})
	  	  		.catch(err => console.log(err)); 
	        }
	        else{
	        	confirm('수정하겟습니까?')
	        }
	      },
	      editable: true,
	      dayMaxEvents: true, // allow "more" link when too many events
	      events: eventDate //[{},{},{},{}...{}]
	    });
	    calendar.render();
	  })
	.catch(err => console.log(err));  
	});

</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<div id='calendar'></div>

</body>
</html>
