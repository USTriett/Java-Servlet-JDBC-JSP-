<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Homepage</title>
<!--Add Bootstrap 4 CSS link -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
/* Custom styles */
.navbar-brand {
	font-size: 2rem;
	font-weight: bold;
	color: #333;
}

.navbar-nav .nav-link {
	font-size: 1.2rem;
	color: #333;
}

.jumbotron {
	background-color:#04aa6d;
	background-size: cover;
	color: #fff;
	text-shadow: 1px 1px #333;
}

.jumbotron h1 {
	font-size: 4rem;
	font-weight: bold;
}

.jumbotron p {
	font-size: 1.5rem;
	font-weight: bold;
}

.card {
	margin-bottom: 1rem;
}

.card img {
	height: 200px;
	object-fit: cover;
}

.card-title {
	font-size: 1.5rem;
	font-weight: bold;
}

.card-text {
	font-size: 1.2rem;
}
</style>
</head>
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

<!--Jumbotron -->
<div class="jumbotron">
	<div class="container">
		<h1>Welcome to Student Management Website</h1>
		<p>Create by 21120577 Huỳnh Công Triết</p>
		<a class="btn btn-primary btn-lg" target="_blank" href="https://www.facebook.com/triet.triet.14/" role="button">Learn
			more</a>
	</div>
</div>

<!--Main content -->
<div class="container">
  <h2>Đồ án trong môn Lập trình ứng dụng Java</h2>
  <p>Hướng dẫn: </p>
</div>

<!-- Author information -->
<div class="container">
  <hr>
  <p>Author: Huỳnh Công Triết</p>
  <p>Email: 21120577@student.hcmus.edu.vn</p>
</div>

<!--Add Bootstrap 4 JS links -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>