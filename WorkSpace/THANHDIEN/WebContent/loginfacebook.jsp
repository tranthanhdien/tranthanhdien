<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Đăng nhập bằng mạng xã hội</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Nông Lâm University</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Trang chủ</a></li>
      <li><a href="#">Giới thiệu</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><button class="btn btn-info btn-lg" data-toggle="modal" data-target="#id01">Login</button></li>
      <li><a href="#"><span class=""></span> Xin chào!</a></li>
    </ul>
  </div>
</nav>
  
	<div class="container">
		  <h3>Xin chào các bạn!</h3>
		  <p>Tron video này,mình xin giới thiệu về cách đăng nhập bằng các tài khoản mạng xã hội ( face,google+),và cách chèn bình luận bằng face vào trong trang web của mình.</p>
			<p>Nếu bài hướng dẫn có ích thì bạn nhớ <strong>like ,share và đăng ký</strong> kênh youtube của mình để cập nhật những video mới khác nhé.Xin cảm ơn các bạn</p>
		</div>
		<div id="status" style="color:red"> 
		</div>
		<!-- form đăng nhập -->
		<div id="id01" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title" style="text-align: center">Đăng nhập</h4>
		      </div>
		      <div class="modal-body">
		       	 <form class="form-horizontal">
					  <div class="form-group">
					    <label class="control-label col-sm-2" for="email">Email:</label>
					    <div class="col-sm-10">
					      <input type="email" class="form-control" id="email" placeholder="Enter email">
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="control-label col-sm-2" for="pwd">Password:</label>
					    <div class="col-sm-10"> 
					      <input type="password" class="form-control" id="pwd" placeholder="Enter password">
					    </div>
					  </div>
					  <div class="form-group"> 
					    <div class="col-sm-offset-2 col-sm-10">
					     
					    </div>
					  </div>
					  <div class="form-group"> 
					    <div class="col-sm-offset-2 col-sm-10">
					      <center><button type="submit" class="btn btn-default">Login</button></center>
					    </div>
					  </div>
					  <div class="form-group"> 
					    <div class="col-sm-offset-2 col-sm-10">
					    <p style="color:red;text-align: center">Hoặc bạn có thể đăng nhập bằng:</p>
					     <center> <!-- <button  type="button" class="btn btn-sm btn-primary">Facebook</button> -->
					   		  <!-- <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
							</fb:login-button> -->
							<div class="fb-login-button" data-max-rows="7" data-size="medium" data-button-type="login_with" data-show-faces="true" data-auto-logout-link="true" data-use-continue-as="true"></div>
					      <button type="button" class="btn btn-sm btn-danger">Google+</button></center>
					    </div>
					  </div>
					</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		
		  </div>
		</div>




<script>
// Get the modal
var modal = document.getElementById('id01');
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
<!-- script dang nhap bang facebook -->
	<script>
	  function statusChangeCallback(response) {
	    console.log('statusChangeCallback');
	    console.log(response);
	    if (response.status === 'connected') {
	      testAPI();
	    } else {
	      document.getElementById('status').innerHTML = 'Please log ' +
	        'into this app.';
	    }
	  }
	
	  function checkLoginState() {
	    FB.getLoginStatus(function(response) {
	      statusChangeCallback(response);
	    });
	    FB.api('/me',{fields: ' name, email'}, function(response) {
	    	  console.log(response);
	    	  window.location.href = 'Login?action=Face&name='+response.name+'&email='+response.email+'&id='+response.id;
	    });
	  }
	
	  window.fbAsyncInit = function() {
	  FB.init({
	    appId      : '343230853168535',
	    cookie     : true, 
	    xfbml      : true, 
	    version    : 'v2.9' 
	  });
	
	
	  FB.getLoginStatus(function(response) {
	    statusChangeCallback(response);
	  });
	
	  };
	
	  (function(d, s, id) {
	    var js, fjs = d.getElementsByTagName(s)[0];
	    if (d.getElementById(id)) return;
	    js = d.createElement(s); js.id = id;
	    js.src = "//connect.facebook.net/en_US/sdk.js";
	    fjs.parentNode.insertBefore(js, fjs);
	  }(document, 'script', 'facebook-jssdk'));
	
	  function testAPI() {
	    console.log('Welcome!  Fetching your information.... ');
	    FB.api('/me', function(response) {
	      console.log('Successful login for: ' + response.name);
	      document.getElementById('status').innerHTML =
	        'Thanks for logging in, ' + response.name + '!';
	    });
	  }
	</script>

</body>
</html>
