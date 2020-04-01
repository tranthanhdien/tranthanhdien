<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(document).on("click", "#somebutton", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
		$.get("GetUserServlet", function(responseText) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
			$("#somediv").text(responseText); // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
		});
	});
</script>
</head>
<body>
	<h1>Ajax with Jquery Simple Example</h1>
	<h3>madushankaperera.wordpress.com</h3>
	<br>
	<form name="form1" method="GET" action="GetUserServlet" id="form1">
		<table>
			<tr>
				<td>Number 1</td>
				<td><input type="text" name="n1" /></td>
			</tr>
			<tr>
				<td>Number 2</td>
				<td><input type="text" name="n2" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Calculate" /></td>
			</tr>
			<tr>
				<td>Result</td>
				<td><input type="text" value="" id="result" /></td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		var form = $('#form1');
		form.submit(function() {

			$.ajax({
				type : form.attr('method'),
				url : form.attr('action'),
				data : form.serialize(),
				success : function(data) {
					var result = data;
					$('#result').attr("value", result);

				}
			});

			return false;
		});
	</script>
</body>
</html>