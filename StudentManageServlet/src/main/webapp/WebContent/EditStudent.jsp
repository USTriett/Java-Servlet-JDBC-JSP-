<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
	<title>Edit Student</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	
	<style>
	.navbar-brand {
	font-size: 2rem;
	font-weight: bold;
	color: #333;
}

.navbar-nav .nav-link {
	font-size: 1.2rem;
	color: #333;
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
			<div class="panel-heading">
				<h2 class="text-center">Edit</h2>
			</div>
			<div class="panel-body">
                            <form method="post" accept-charset="utf-8">
                 <div class="form-group">
				  <label for="usr">ID:</label>
                                  <input type="text" class="form-control" value="${std.getStudentId()}"  disabled id="usr" name="id"/>
				</div>
				<div class="form-group">
				  <label for="usr">Name:</label>
                                  <input type="text" class="form-control" value="${std.getName()}"  required id="usr" name="name"/>
				</div>
				<div class="form-group">
				  <label for="grade">Grade:</label>
                                  <input type="number" class="form-control" value="${std.getGrade()}"  required id="age" name="grade"/>
				</div>
					<div class="form-group">
				  <label for="birthday">Birthday:</label>
                                  <input type="Date" class="form-control" id="stdBirth" max="2018-12-31" value="${std.getBirthday()}"
       			 name="birthday"  required />
				</div>
				<div class="form-group">
				  <label for="address">Address:</label>
                                  <input type="text" class="form-control" id="address" value="${std.getAddress()}" name="address"  required/>
				</div>
				<div class="form-group">
				  <label for="notes">Notes:</label>
                                  <input type="text" class="form-control" id="notes" value="${std.getNotes()}" name="notes"/>
				</div>
				<button class="btn btn-success">Submit</button>
                            </form>
			</div>
		</div>
	</div>
</body>
<script>
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

var maxDate = year + '-' + month + '-' + day;

document.getElementById('stdBirth').max = maxDate;
</script>
</html>
