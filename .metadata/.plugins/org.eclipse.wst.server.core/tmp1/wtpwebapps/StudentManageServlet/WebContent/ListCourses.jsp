<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<title>List Courses</title>
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

.custom-select {
	width: 100px;
	position: absolute;
	right: 100px;
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
			<form class="form-inline my-2 my-lg-0" method="get" action="./searchcourse">
				<input class="form-control mr-sm-2 w-200" type="search"
					placeholder="Search" aria-label="Search" name="name">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
		<div class="panel panel-primary">
			<select class="form-control custom-select" onchange="filterTable()">
				<option selected>All</option>
				
				<c:if test="${!yearlist.isEmpty()}">
				<c:forEach var="i" begin="0" end="${yearlist.size() - 1}">
					<option value="${yearlist.get(i)}">${yearlist.get(i)}</option>
				</c:forEach>
				</c:if>
			</select>
			<div class="panel-heading" id="tableHeading">
					<h2 class="text-center">Courses</h2>
				</div>
				<div class="panel-body">
					<div class="table-container mt-3" id="myTable">
					<table class="table table-bordered" id="listCourses">
						<thead>
							<tr>
								<th>ID</th>
								<th>Year</th>
								<th>Name</th>
								<th>Notes</th>
								<th></th>
								<th></th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${not empty list}">
								<c:forEach var="i" begin="0" end="${list.getSize() - 1}">
									<c:set var="course" value="${list.getCourse(i)}" />
									<tr>
										<td>${course.getId()}</td>
										<td>${course.getYear()}</td>
										<td>${course.getName()}</td>
										<td>${course.getNotes()}</td>
										
										<td>
											<form method="post" action="./showlecture">
												<input type="text" value="${course.getId()}"
													name="id" style="display: none;" />
												<input type="text" value="${course.getYear()}"
													name="year" style="display: none;" />
											<button type="submit" class="btn btn-primary" id="showlecturebtn" name="lecture">Show Lecture</button>
											</form>
											
										</td>
										<td>
											<form method="get" action="./editcourse">
												<input type="text" value="${course.getId()}"
													name="id" style="display: none;" />
												<input type="text" value="${course.getYear()}"
													name="year" style="display: none;" />
											<button type="submit" class="btn btn-primary" id="editbtn" name="edit">Edit</button>
											</form>
											
										</td>
										<td>
										<form method="get" action="" id="#changeselected">
										
										</form>
											<form method="post" action="./courseremove" id="myForm">
												<input type="text" value="${course.getId()}"
													name="id" style="display: none;" />
												<input type="text" value="${course.getYear()}"
													name="year" style="display: none;" />
												<button class="btn btn-success" name="delete" 
												>Delete</button>
											</form>
										</td>
										<td>
											<form method="post" action="./showstudentincourse">
												<input type="text" value="${course.getId()}"
													name="id" style="display: none;" />
												<input type="text" value="${course.getYear()}"
													name="year" style="display: none;" />
												<button type="submit" class="btn btn-success" name="student">Show Student</button>
											</form>
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
			<a href="./addcourse" class="btn btn-primary mt-3 mb-3" id="newbtn">+ New Course</a>
			<button class="btn btn-primary mt-3 mb-3" onclick = "sortByName()" id="sortbtn">Sort by name</button>
		</div>
	</div>
</body>
<script>
        // JavaScript to handle toggle functionality
        $(document).ready(function() {
            $('#toggleBtn').click(function() {
                $('#myTable').toggle(); // Toggle the display of the table
                $('#tableHeading').toggle();
                $('#newbtn').toggle();
                $('#sortbtn').toggle();
                if( document.getElementById("toggleBtn").innerText.valueOf() == new String("Show Student List").valueOf())
                {
                	document.getElementById("toggleBtn").innerText = "Hide courses list"
                }
                else{
                	document.getElementById("toggleBtn").innerText = "Show courses List"
                }
            });
        });
        
     
        
           
       
        
        function sortByName() {
        	  // Get the table element
        	  
        	  const table = document.getElementById("listCourses");
        	
        	  // Get the table rows
        	  const rows = table.rows;
        	  console.log(rows);
        	  // Convert the rows to an array for sorting
        	  const rowsArray = Array.from(rows).slice(1);
        	  console.log(1); // Add this line to check the value of rowsArray
        	  // Sort the rows based on the name column
        	  rowsArray.sort((a, b) => {
        	    const nameA = a.cells[2].textContent;
        	    const nameB = b.cells[2].textContent;
        	    return nameA.localeCompare(nameB);
        	  });

        	  // Add the sorted rows back to the table
        	  rowsArray.forEach(row => {
        	    table.appendChild(row);
        	  });
        	}
        
        function filterTable() {
        	  // Get selected option value
        	  var selectedOption = document.querySelector('.custom-select').value;
        	  
        	  // Get table rows
        	  var rows = document.querySelectorAll('#listCourses tbody tr');
        	  
        	  // Loop through rows and hide/show based on selected option
        	  for (var i = 0; i < rows.length; i++) {
        	    var yearCell = rows[i].querySelector('td:nth-child(2)');
        	    if (selectedOption === 'All' || yearCell.textContent === selectedOption) {
        	      rows[i].style.display = '';
        	    } else {
        	      rows[i].style.display = 'none';
        	    }
        	  }
        	}
      
    </script>
</html>