	google.load("visualization", "1", {packages:["corechart"]});
	google.setOnLoadCallback(drawChart);

	function drawChart() {	
		var b_request = parseInt($('#b_request').val());
		var b_feedback = parseInt($('#b_feedback').val());
		var b_doing = parseInt($('#b_doing').val());
		var b_done = parseInt($('#b_done').val());
		var b_issue = parseInt($('#b_issue').val());
		
		var data = google.visualization.arrayToDataTable(
		    [["type","count"],["요청", b_request],["피드백", b_feedback],["진행",b_doing],["완료",b_done],["보류",b_issue]]
		);
		var options = {
		    title: "업무 리포트"
		};
		var chart = new google.visualization.PieChart(document.getElementById("work_piechart"));
		chart.draw(data, options);
	}

	



