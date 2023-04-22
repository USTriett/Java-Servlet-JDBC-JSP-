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
			<form method="post">
				<div class="form-group">
					<label for="yearSelect">Select Year:</label>
					 <select class="form-control" id="yearSelect" name="year">
						<option value="0">All</option>
						
						<c:if test="${!yearlist.isEmpty()}">
							<c:forEach var="i" begin="0" end="${yearlist.size() - 1}">
								
								<option value="${yearlist.get(i)}">${yearlist.get(i)}</option>
		
							</c:forEach>
						</c:if>
					</select>
				</div>
				<button type="submit" class="btn btn-primary" style="display: none;">Submit</button>
			</form>
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
							<th>GPA</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${!studentlist.isEmpty()}">
							<c:forEach var="i" begin="0" end="${studentlist.getSize() - 1}">
								<c:set var="student" value="${studentlist.getStudentScore(i)}" />
								<tr>
									<td>${student.getId()}</td>
									<td>${student.getStudentName()}</td>
									<td>${student.getScore()}</td>
									<td>
											<form method="post" action="./scoreofstudent">
												<input type="text" value="${student.getId()}"
													name="id" style="display: none;" />
												<button class="btn btn-success">Show Score</button>
											</form>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
					</table>
				</div>
			</div>
		</div>
		<button id="sort-btn" class="btn btn-primary">Sort by GPA</button>
	</div>
	
	<div id="sYear" data-my-attribute="${selectedYear}"></div>
	<!-- Include Bootstrap JavaScript -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
</body>
<script>
    $(document).ready(function () {
      $('#sort-btn').click(function () {
        var rows = $('tbody > tr').get();
        rows.sort(function (a, b) {
          var gpaA = parseFloat($(a).find('td:eq(2)').text());
          var gpaB = parseFloat($(b).find('td:eq(2)').text());
          if (gpaA > gpaB) {
            return -1;
          }
          if (gpaA < gpaB) {
            return 1;
          }
          return 0;
        });
        $.each(rows, function (index, row) {
          $('tbody').append(row);
        });
      });
    });
    
    const sYear = document.getElementById("sYear");
    const yearValue = sYear.getAttribute("data-my-attribute");
    const yearSelect = document.getElementById("yearSelect");
    const selectedYear = yearValue; // Replace with desired year
    
    const options = yearSelect.options;
    for (let i = 0; i < options.length; i++) {
      if (options[i].value === selectedYear) {
        yearSelect.selectedIndex = i;
        break;
      }
    }
    yearSelect.addEventListener("change", () => {
    	console.log("click");
      const form = document.querySelector("form");
      form.submit();
      
    });
  </script>
</html>