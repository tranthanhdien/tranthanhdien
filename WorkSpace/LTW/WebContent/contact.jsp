<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liên hệ với chúng tôi</title>
</head>
<body>
	<!-- Include header và footer vào trang index -->
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="contact">
			<h2 class=" contact-in">CONTACT</h2>

			<div class="col-md-6 contact-top">
				<h3>Thông tin</h3>
				<div class="map">
					<iframe src="https://www.google.com/maps/d/u/0/embed?mid=1OFB3xk1875E7i6qxo5cTPY8S1cTzl0tr" width="640" height="480"></iframe>
				</div>

				<p>At vero eos et accusamus et iusto odio dignissimos ducimus
					qui blanditiis praesentium voluptatum deleniti atque corrupti quos
					dolores et quas</p>
				<p>Et harum quidem rerum facilis est et expedita distinctio. Nam
					libero tempore, cum soluta nobis est eligendi optio cumque nihil
					impedit quo minus id</p>
				<ul class="social ">
					<li><span><i> </i>124 Avenue Street, Los
							angeles,California </span></li>
					<li><span><i class="down"> </i>+ 00 123 456 7890</span></li>
					<li><a href="mailto:info@example.com"><i class="mes">
						</i>info@example.com</a></li>
				</ul>
			</div>
			<div class="col-md-6 contact-top">
				<h3>Liên hệ với chúng tôi</h3>
				<div>
					<span>Your Name </span> <input type="text" value="">
				</div>
				<div>
					<span>Your Email </span> <input type="text" value="">
				</div>
				<div>
					<span>Subject</span> <input type="text" value="">
				</div>
				<div>
					<span>Your Message</span>
					<textarea> </textarea>
				</div>
				<input type="submit" value="SEND">
			</div>
			<div class="clearfix"></div>
		</div>

		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>