<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title>List Student</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style>
/* Custom CSS to hide the table initially */
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

#tableHeading {
	
}

#newbtn {
	position: relative;
	right: 0;
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



	<div class="container" style="margin-top:20px">
		<div class="d-flex justify-content-center">
			<form class="form-inline my-2 my-lg-0" method="get" action="./searchstudent">
				<input class="form-control mr-sm-2 w-200" type="search"
					placeholder="Search" aria-label="Search" name="name">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
		<div class="panel panel-primary">
				<div class="panel-heading" id="tableHeading">
					<h2 class="text-center">List Student</h2>
				</div>
				<div class="panel-body">
					<div class="table-container mt-3" id="myTable">
					<table class="table table-bordered" id="listStudent">
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Grade</th>
								<th>Birthday</th>
								<th>Address</th>
								<th>Notes</th>
								<th></th>
								<th></th>
								<th></th>
								
							</tr>
						</thead>
						<tbody>
							<c:if test="${!studentlist.isEmpty()}">
								<c:forEach var="i" begin="0" end="${studentlist.getSize() - 1}">
									<c:set var="student" value="${studentlist.getStudent(i)}" />
									<tr>
										<td>${student.getStudentId()}</td>
										<td>${student.getName()}</td>
										<td>${student.getGrade()}</td>
										<td>${student.getBirthday()}</td>
										<td>${student.getAddress()}</td>
										<td>${student.getNotes()}</td>
										<td>
											<form method="get" action="./edit">
												<input type="text" value="${student.getStudentId()}"
													name="id" style="display: none;" />
											<button type="submit" class="btn btn-primary" id="editbtn">Edit</button>
											</form>
											
										</td>
										<td>
											<form method="post" action="./delete">
												<input type="text" value="${student.getStudentId()}"
													name="id" style="display: none;" />
												<button class="btn btn-success"
													>Delete</button>
											</form>
										</td>
										<td>
											<form method="post" action="./showcourseinyear">
												<input type="text" value="${student.getStudentId()}"
													name="id" style="display: none;" />
												<button type="submit" class="btn btn-success">Show Course</button>
											</form>
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
			<a href="./AddStudent" class="btn btn-primary mt-3 mb-3" id="newbtn">+ New Student</a>
			<button class="btn btn-primary mt-3 mb-3" onclick = "sortByName()" id="sortbtn">Sort by name</button>
			<button class="btn btn-primary mt-3 mb-3" onclick = "sortByGrade()" id="sortbtn">Sort by grade</button>
			
		</div>
	</div>
</body>
<script>
        // JavaScript to handle toggle functionality
       
        
        document.querySelector('#myForm').addEventListener('submit', function(event) {
            if (!confirm('Are you sure to delete')) {
                event.preventDefault();
            }
        });
        
        
        function sortByName() {
        	  // Get the table element
        	  
        	  const table = document.getElementById("listStudent");
        	
        	  // Get the table rows
        	  const rows = table.rows;
        	  console.log(rows);
        	  // Convert the rows to an array for sorting
        	  const rowsArray = Array.from(rows).slice(1);
        	  console.log(1); // Add this line to check the value of rowsArray
        	  // Sort the rows based on the name column
        	  rowsArray.sort((a, b) => {
        	    const nameA = a.cells[1].textContent;
        	    const nameB = b.cells[1].textContent;
        	    return nameA.localeCompare(nameB);
        	  });

        	  // Add the sorted rows back to the table
        	  rowsArray.forEach(row => {
        	    table.appendChild(row);
        	  });
        	}
        
        function sortByGrade() {
        	  // Get the table element
        	  
        	  const table = document.getElementById("listStudent");
        	
        	  // Get the table rows
        	  const rows = table.rows;
        	  console.log(rows);
        	  // Convert the rows to an array for sorting
        	  const rowsArray = Array.from(rows).slice(1);
        	  console.log(1); // Add this line to check the value of rowsArray
        	  // Sort the rows based on the name column
        	  rowsArray.sort(function(a, b) {
    			var aGrade = parseFloat(a.cells[2].textContent);
    			var bGrade = parseFloat(b.cells[2].textContent);
    			return aGrade - bGrade;
 				 });

        	  // Add the sorted rows back to the table
        	  rowsArray.forEach(row => {
        	    table.appendChild(row);
        	  });
        	}
        var currentDate = new Date();
        var year = currentDate.getFullYear();
        var month = currentDate.getMonth() + 1;
        var day = currentDate.getDate();

        if (month < 10) {
            month = '0' + month;
        }
        if (day < 10) {
            day = '0' + day;
        }


        document.getElementById('cyear').value = year;
        console.log(document.getElementById('cyear').value);
    </script>
</html>
