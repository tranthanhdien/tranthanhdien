<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab8</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- <form action="upload" method="post" enctype="multipart/form-data"> -->

	<div class="container">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<form action="upload1" method="post" enctype="multipart/form-data">
				<input type="file" id="files" name="files" multiple="multiple" />
				<p style="text-align: right; margin-top: 20px;">
					<input type="submit" value="Upload Files"
						class="btn btn-lg btn-primary" />
				</p>
			</form>
		</div>
		<div class="col-md-4"></div>
	</div>
	

	<!-- 
	<div class="container">
		<div class="col-md-8 col-md-offset-2">
			<h3>File Input Example</h3>
			<form method="POST" action="upload" enctype="multipart/form-data">
				<!-- COMPONENT START -->
	-->
	<!--  
				<div class="form-group">
					<div class="input-group input-file" name="Fichier1">
						<span class="input-group-btn">
							<button class="btn btn-default btn-choose" type="button">Choose</button>
						</span> <input type="file" class="form-control"
							placeholder='Choose a file...' /> <span class="input-group-btn">
							<button class="btn btn-warning btn-success" type="submit">Upload
								file</button>
						</span>
					</div>
				</div>
			</form>
		</div>
	</div>
	 -->
</body>
</html>