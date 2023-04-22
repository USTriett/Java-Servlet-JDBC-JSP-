<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<title>Student in Course</title>
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
	max-height: 500px;
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


	<div class="container">
		<div class="panel panel-primary">
			
				<div class="panel-heading" id="tableHeading">
					<h2 class="text-center">Lecture in course ${cname}</h2>
				</div>
				<div class="panel-body">
					<div class="table-container mt-3" id="myTable">
					<table class="table table-bordered" id="listLecture">
						<thead>
							<tr>
								
								<th>Class ID</th>
								<th>Class year</th>
								<th>Lecture name</th>
								<th>Notes</th>
								<th></th>
								<th></th>
								
							</tr>
						</thead>
						<tbody>
							<c:if test="${!list.isEmpty()}">
								<c:forEach var="i" begin="0" end="${list.getSize() - 1}">
									<c:set var="l" value="${list.getLecture(i)}" />
									<tr>
										
										<td>${l.getClassId()}</td>
										
										<td>${l.getClassYear()}</td>
										<td>${l.getLname()}</td>
										<td>${l.getNotes()}</td>
										<td>
											<form method="get" action="./editlecture">
												<input type="text" value="${l.getClassId()}"
													name="id" style="display: none;" />
												<input type="text" value="${l.getClassYear()}"
													name="year" style="display: none;" />
												<input type="text" value="${l.getLname()}"
													name="name" style="display: none;" />
												<input type="text" value="${l.getNotes()}"
													name="notes" style="display: none;" />
											<button type="submit" class="btn btn-primary" id="editbtn" name="edit">Edit</button>
											</form>
											
										</td>
										<td>
											<form method="post" action="./lectureremove">
												<input type="text" value="${l.getClassId()}"
													name="id" style="display: none;" />
												<input type="text" value="${l.getClassYear()}"
													name="year" style="display: none;" />
												<input type="text" value="${l.getLname()}"
													name="name" style="display: none;" />
												<button class="btn btn-success" name="delete" id="myForm"
												type="submit">Delete</button>
											</form>
										</td>
										
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
			<a href="./addlecture?id=${id}&year=${year}&status=1" class="btn btn-primary mt-3 mb-3" id="newbtn">+ New Lecture</a>
			<button class="btn btn-primary mt-3 mb-3" onclick = "sortByName()" id="sortbtn">Sort by name</button>
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
        	  
        	  const table = document.getElementById("listLecture");
        	
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
      
    </script>
</html>