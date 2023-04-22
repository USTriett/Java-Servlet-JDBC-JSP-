<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>Score Board</title>
	<!-- Include Bootstrap CSS -->
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
/* Define custom CSS rules here */
.navbar-brand {
	font-size: 2rem;
	font-weight: bold;
	color: #333;
}

.navbar-nav .nav-link {
	font-size: 1.2rem;
	color: #333;
}

.table-container {
	overflow-x: auto;
	max-height: 300px;
	/* Set max height to prevent table from overflowing */
}

.table-container table {
	width: 100%;
}

#sort-btn {
	position: relative;
	left: 0px;
	margin-top: 20px;
}

.w-200 {
	width: 80% !important;
}

.form-inline {
	width: 80% !important;
}

.panel {
	margin-top: 10px;
}

 table {
    border-collapse: collapse;
    width: 100%;
  }

  th, td {
    text-align: left;
    padding: 8px;
  }

  th {
    background-color: #4CAF50;
    color: white;
    position: sticky;
	top: -1px;
	background: #04aa6d;
  }

  tr:nth-child(even) {
    background-color: #f2f2f2;
  }
	
tr:hover {
    background-color: #ddd;
  }
</style>
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<!--Brand/logo -->
		<a class="navbar-brand" href="./">Homepage</a> 
		<button class="navbar-toggler " type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!--Menu items -->
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="./ScoreBoard">Score
						Board</a></li>
				<li class="nav-item"><a class="nav-link" href="./ListStudent">Students</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="./courses">Courses</a>
				</li>
			</ul>
		</div>
	</div>
</nav>
	<div class="container" style="margin-top: 20px;">
		<div class="d-flex justify-content-center">
			<select class="form-control custom-select" onchange="filterTable()">
			<option selected>All</option>

			<c:if test="${!yearlist.isEmpty()}">
				<c:forEach var="i" begin="0" end="${yearlist.size() - 1}">
					<option value="${yearlist.get(i)}">${yearlist.get(i)}</option>
				</c:forEach>
			</c:if>
		</select>
		</div>

		<div class="panel panel-primary">
			<div class="panel-heading" id="tableHeading">
				<h2 class="text-center">Score Board</h2>
			</div>
			<div class="panel-body">
				<div class="table-container mt-3" id="myTable">
				<table class="table table-bordered" id="listStudent">
					<thead>
						<tr>
							<th>Student Id</th>
							<th>Student Name</th>
							<th>Class Id</th>
							<th>Class Name</th>
							<th>Year</th>
							<th>Score</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${!list.isEmpty()}">
							<c:forEach var="i" begin="0" end="${list.size() - 1}">
								<c:set var="student" value="${list.get(i)}" />
								<tr>
									<td>${student.getStudentId()}</td>
									<td>${student.getStudentName()}</td>
									<td>${student.getClassId()}</td>
									<td>${student.getClassName()}</td>
									<td>${student.getClassYear()}</td>
									<td>${student.getScore()}</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
					</table>
				</div>
			</div>
		</div>
		
	</div>
	
	<div id="sYear" data-my-attribute="${selectedYear}"></div>
	<!-- Include Bootstrap JavaScript -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
</body>
<script>
function filterTable() {
	  // Get selected option value
	  var selectedOption = document.querySelector('.custom-select').value;
	  
	  // Get table rows
	  var rows = document.querySelectorAll('#listStudent tbody tr');
	  
	  // Loop through rows and hide/show based on selected option
	  for (var i = 0; i < rows.length; i++) {
	    var yearCell = rows[i].querySelector('td:nth-child(5)');
	    if (selectedOption === 'All' || yearCell.textContent === selectedOption) {
	      rows[i].style.display = '';
	    } else {
	      rows[i].style.display = 'none';
	    }
	  }
	}
  </script>
</html>