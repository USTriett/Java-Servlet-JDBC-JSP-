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
				  <label for="id">ID:</label>
                                  <input type="text" class="form-control" value="${c.getId()}"  readonly id="id" name="id"/>
				</div>
				<div class="form-group">
				  <label for="year">Year:</label>
                                  <input type="text" class="form-control" value="${c.getYear()}"  readonly id="year" name="year"/>
				</div>
				<div class="form-group">
				  <label for="name">Name:</label>
                                  <input type="text" class="form-control" value="${c.getName()}"  required id="name" name="name"/>
				
				  <label for="notes">Notes:</label>
                                  <input type="text" class="form-control" id="notes" value="${c.getNotes()}" name="notes"/>
				</div>
				<button class="btn btn-success">Submit</button>
                            </form>
			</div>
		</div>
	</div>
</body>
<script>

</script>
</html>
