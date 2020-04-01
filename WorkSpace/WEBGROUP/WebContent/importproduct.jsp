<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script src="js/agu.js"></script>
<script src="js/xlsx.js"></script>
<script src="js/xlsx-model.js"></script>
<script src="js/script.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#btnExcel').on('click', function(event) {
			var val = $('pre').text();
			$.post('ProcessFileExcel', {
				data : val,
				chucNang : 'Product'
			});
		});
	});
</script>
</head>

<body ng-app="xlsxApp" ng-controller="xlsxCtrl">
	<div class="container">
		<div class="row">
			<div style="float: right; margin-left: 10px;">
				<button id="btnExcel" class="btn btn-success" name="file">Import
					Excel</button>
			</div>
			<div style="float: right; margin-left: 10px">
				<input type="file" class="form-control" xlsx-model="excel" multiple>
			</div>
			<pre ng-show="excel">{{excel | json}}</pre>
		</div>

	</div>

</body>
</html>