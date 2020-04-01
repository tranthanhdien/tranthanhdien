<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"
	crossorigin="anonymous">
<style>
body {
	
}

/* Full-width input fields */
input[type=text] {
	width: 100%;
	padding: 5px 5px;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal1-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 48%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}
@
keyframes click-wave { 0% {
	height: 40px;
	width: 40px;
	opacity: 0.35;
	position: relative;
}

100%
{
height














:







 







200
px














;
width














:







 







200
px














;
margin-left














:







 







-80
px














;
margin-top














:







 







-80
px














;
opacity














:







 







0;
}
}
.option-input {
	-webkit-appearance: none;
	-moz-appearance: none;
	-ms-appearance: none;
	-o-appearance: none;
	appearance: none;
	position: relative;
	top: 13.33333px;
	right: 0;
	bottom: 0;
	left: 0;
	height: 40px;
	width: 40px;
	transition: all 0.15s ease-out 0s;
	background: #cbd1d8;
	border: none;
	color: #fff;
	cursor: pointer;
	display: inline-block;
	margin-right: 0.5rem;
	outline: none;
	position: relative;
}

.option-input:hover {
	background: #9faab7;
}

.option-input:checked {
	background: #40e0d0;
}

.option-input:checked::before {
	height: 40px;
	width: 40px;
	position: absolute;
	content: '✔';
	display: inline-block;
	font-size: 26.66667px;
	text-align: center;
	line-height: 40px;
}

.option-input:checked::after {
	-webkit-animation: click-wave 0.65s;
	-moz-animation: click-wave 0.65s;
	animation: click-wave 0.65s;
	background: #40e0d0;
	content: '';
	display: block;
	position: relative;
	z-index: 100;
}

.option-input.radio {
	border-radius: 50%;
}

.option-input.radio::after {
	border-radius: 50%;
}

label {
	font-size: 16px;
	display: block;
	line-height: 25px;
	float: left;
	margin-right: .5rem;
	font-weight: 100;
}

input[type=number] {
	display: block;
	line-height: 20px;
	float: left;
	margin-right: .5rem;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
/*upload */
%
vertical_align {
	justify-content: center;
	align-items: center;
}

$
primary_color: rgb (244, 67, 54); html, body {
	height: 100%;
	width: 100%; . wrapper { display : flex; @ extend %vertical_align;
	height: 100%;
}

}
.editor-wrapper {
	display: flex;
	justify-content: center; . editor-container { display : flex;
	flex-direction: column; . editor { text-align : center;
	display: block;
	width: 500px;
	height: 500px;
	line-height: 500px;
	position: relative; . resize-container { position : relative;
	display: inline-flex;
	cursor: move;
	margin: 0 auto;
	line-height: normal;
	vertical-align: middle;
	img
	{
	display
	:
	block;
}

&
:hover, &:active {img { outline:2pxdashed $primary_color;
	
}

}
}
}
}
}
.upload {
	display: flex;
	background-color: $primary_color;
	color: white;
	padding: 20px; form { @extend %vertical_align;
	display: flex;
	justify-content: space-between;
	width: 100%;
	input
	{
	display
	:
	none;
}

.edit-button {
	display: none;
}

button {
	border: 0;
	padding: 10px 15px;
	box-sizing: content-box;
	width: auto;
	height: auto;
	border-radius: 0;
	color: $primary_color;
	font-weight: bold;
}

.upload-button {label { cursor:pointer;
	
}

.upload-icon {
	display: inline-block;
	background-color: $primary-color;
	color: white;
	border: 2px solid white;
	padding: 8px 12px;
}

.label-text {
	display: inline-block;
	color: $primary_color;
	background-color: white;
	padding: 10px 15px;
	margin: 0;
	&:
	hover
	{
	color
	:
	#333;
}

}
}
}
}
%
extend_1 {
	position: absolute;
	display: block;
	width: 10px;
	height: 10px;
	background: $primary_color;
	z-index: 999;
}

.resize-handle-nw { @extend %extend_1;
	top: -5px;
	left: -5px;
	cursor: nw-resize;
}

.resize-handle-sw { @extend %extend_1;
	bottom: -5px;
	left: -5px;
	cursor: sw-resize;
}

.resize-handle-ne { @extend %extend_1;
	top: -5px;
	right: -5px;
	cursor: ne-resize;
}

.resize-handle-se { @extend %extend_1;
	bottom: -5px;
	right: -5px;
	cursor: se-resize;
}

$
overlay_height: 350px ; $overlay_width: 350px ; .overlay {
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translateX(-50%) translateY(-50%);
	z-index: 999;
	width: $overlay_width;
	height: $overlay_height;
	border: solid 2px rgba(222, 60, 80, 0.9);
	box-sizing: content-box;
	pointer-events: none;
	vertical-align: middle;
	display: inline-block; &: after , & : before {
    content : '';
	position: absolute;
	display: block;
	width: $overlay_width +4px;
	height: $overlay_height/5;
	border-left: dashed 2px rgba(222, 60, 80, 0.9);
	border-right: dashed 2px rgba(222, 60, 80, 0.9);
	box-sizing: border-box;
}

&
:before {
	top: 0;
	margin-left: -2px;
	margin-top: -40px;
}

&
:after {
	bottom: 0;
	margin-left: -2px;
	margin-bottom: -40px;
}

}
.overlay-inner { &:after , &:before {
    content : '';
	position: absolute;
	display: block;
	width: $overlay_width/4;
	height: $overlay_height+ 4px;
	border-top: dashed 2px rgba(222, 60, 80, 0.9);
	border-bottom: dashed 2px rgba(222, 60, 80, 0.9);
	box-sizing: border-box;
}

&
:before {
	left: 0;
	margin-left: -40px;
	margin-top: -2px;
}

&
:after {
	right: 0;
	margin-right: -40px;
	margin-top: -2px;
}

}
.overlay-preview {
	display: none;
	border: 0; &: before , & : after {
    height : 90px;
	background-color: white;
	border: 0;
	left: -150px;
	width: 650px;
	z-index: 9999;
}

&
:before {
	margin-top: -90px;
}

&
:after {
	margin-bottom: -90px;
}

.overlay-inner { &:before , &:after {
      background-color : white;
	border: 0;
	width: 150px;
	z-index: 9999;
}

&
:before {
	margin-left: -150px;
}

&
:after {
	margin-right: -150px;
}

}
}
.editor-modal { .modal-header { display:none;
	text-align: center;
	background-color: $primary-color;
	color: white;
	border-bottom: 0; . close { color : white;
	opacity: 0.8;
}

.close:focus, .close:hover {
	color: white;
	opacity: 1;
}

}
.modal-body {
	display: none;
	border: 2px solid$primary_color;
	border-top: 0;
	border-bottom: 0;
	overflow: hidden;
}

.modal-footer {
	padding: 0;
	border: 0;
}

}
.editing-Image { &.editor-modal { .modal-header { display:block;
	
}

.modal-body {
	display: block;
}

}
.upload {form { .edit-button { display:block;
	
}

}
}
}
.btn.active.focus, .btn.focus, .btn:active.focus, .btn:focus, .btn:active:focus
	{
	outline: transparent;
}

.btn






.active






.focus
,
.btn






.focus
,
.btn






:active






.focus
,
.btn






:focus
,
.btn






:active






:focus
,
{
outline






:



 



transparent






;
background-color






:



 



whitesmoke






;
}
.change-icon {a { &:hover {
            opacity : 0.90;
	
}

display: flex ; flex-direction:column-reverse ; text-decoration: none ;
	border-radius: 5px ; .change-icon-text {
	padding: 17px 30px;
	background-color: $primary_color;
	color: white;
	border-radius: 0 0 10px 10px;
}

.icon-container {
	display: flex;
	justify-content: space-around;
	border: 3px solid$primary_color;
	padding: 20px 20px;
	color: $primary_color;
	background-color: white;
	border-radius: 10px 10px 0 0;
}

}
}
.reference {
	right: 10px;
	bottom: 10px;
	position: absolute;
}

.wrapper {
	float: left;
	padding: 1rem 1rem;
}
</style>
</head>
<body>

	<button onclick="document.getElementById('id01').style.display='block'"
		style="width: auto;">Add</button>

	<div id="id01" class="modal">
		<form class="modal1-content animate" action="#">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span>
				<h2>Thêm Khách hàng</h2>
			</div>

			<div class="container">
				<div class="input-group" style="display: grid; width: 610px;">
					<label for="ma"><b>Mã khách hàng</b></label> <input type="text"
						name="ma" required>
				</div>
				<div class="input-group" style="display: grid; width: 610px;">
					<label for="ten"><b>Tên khách hàng</b></label> <input type="text"
						name="ten" required>
				</div>
				<div class="input-group" style="display: grid; width: 610px;">
					<label for="mota"><b>Email</b></label> <input type="text"
						name="email" required>
				</div>
				<div class="input-group " style="display: grid; width: 610px;">
					<label for="gia"><b>Password</b></label> <input type="text"
						name="pass" required>
				</div>
				<div class="input-group" style="width: 610px; margin-bottom: 8px;">
					<label><b>Ảnh đại diện</b></label><input type="file" name="file"
						required>

				</div>

				<button type="submit" class="input-group"
					style="display: grid; width: 610px; margin-bottom: 8px;">Thêm</button>
		</form>
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
		function myFunction() {
			var x = document.getElementById("id02");
			if (x.style.display === "none") {
				x.style.display = "block";
				var el = document.getElementById("show")
				el.value = '<i class="fas fa-minus-square"></i>Thu nhỏ';
				el.innerHTML = '<i class="fas fa-minus-square"></i>Thu nhỏ';
				return false;

			} else {
				x.style.display = "none";

				var el = document.getElementById("show")
				el.value = '<i class="fas fa-plus-square"></i>Mở rộng';
				el.innerHTML = '<i class="fas fa-plus-square"></i>Mở rộng';

			}
		}
	</script>
	<script type="text/javascript"
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script type="text/javascript"
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$('document')
				.ready(
						function() {
							//    Resizes and crops image
							var resizableImage = function(image_target_init) {
								var $container, $orig_src = new Image(), image_target = $(
										image_target_init).get(0), $event_state = {}, $constrain = true, $min_width = 350, $min_height = 350, $max_width = 1200, $max_height = 1200, $intial_width = 450, $intial_height = 450, $resize_canvas = document
										.createElement('canvas');

								//        Wraps the image into container and adds Handles and intial calls for action
								init = function() {

									$orig_src.src = image_target.src;
									initialResize();

									$container = $(image_target).parent(
											'.resize-container');
									if (!$container
											.hasClass("resizing-the-image")) {
										$container
												.addClass("resizing-the-image");
										$container.on('mousedown touchstart',
												'.resize-handle', startResize);
										$container.on('mousedown touchstart',
												'img', startMoving);
										$('.js-crop').on('click', crop);
									}
								};
								//        Resizing Before Loading
								initialResize = function() {
									var height, width;
									if (image_target.height > $intial_height
											&& image_target.width > $intial_width) {
										height = $intial_height;
										width = height
												* (image_target.width / image_target.height);
										if (width < $min_width) {
											width = $intial_width;
											height = width
													* (image_target.height / image_target.width);
										}
										resizeImage(width, height);
									} else if (image_target.height > $intial_height) {
										height = $intial_height;
										width = height
												* (image_target.width / image_target.height);
										if (width < $min_width) {
											width = $intial_width;
											height = width
													* (image_target.height / image_target.width);
										}
										resizeImage(width, height);
									} else if (image_target.width > $intial_width) {
										width = $intial_width;
										height = width
												* (image_target.height / image_target.width);
										if (height < $min_height) {
											height = $intial_height;
											width = height
													* (image_target.width / image_target.height);
										}
										resizeImage(width, height);
									}
								};

								//        Saving The Image after resizing
								resizeImage = function(width, height) {
									$resize_canvas.width = width;
									$resize_canvas.height = height;
									$resize_canvas.getContext('2d').drawImage(
											$orig_src, 0, 0, width, height);
									$(image_target).attr(
											'src',
											$resize_canvas
													.toDataURL("image/png"));
								};

								//        starts moving the image
								startMoving = function(e) {
									e.preventDefault();
									e.stopPropagation();
									saveEventState(e);
									$(document).on('mousemove touchmove',
											moving);
									$(document).on('mouseup touchend',
											endMoving);
									console.log("Move");
								};
								init();
							};

							//    Loading Uploaded Image
							function loaduploadedImage($image) {

								if ($image.files && $image.files[0]) {
									$imageFile = new Image();

									$imageFile.onload = function() {
										var $this = this;
										var height, width;

										//                To check for Image of low resolution
										if ($this.height < 350
												|| $this.width < 350) {
											alert("Image should be greater than 350px*350px");
											return;
										}
										$('.editor-modal').addClass(
												'editing-Image');
										$('.resize-image').attr('src',
												$this.src);
										resizableImage($('.resize-image'));

									};
									var reader = new FileReader();
									$imageFile.src = window.URL
											.createObjectURL($image.files[0]);
								}
							}

							//    Validation For Image

							function isImage(file) {
								var name, extension, $file = $(file);
								if (file.files) {
									name = $file.val().toLowerCase();
									extension = name.substring(name
											.lastIndexOf('.'));

									if ([ '.png', '.jpeg', '.gif', '.jpg',
											'.bmp' ].indexOf(extension) >= 0) {
										console.log("Valid image file");
										return 1;
									}
									alert("Not a Valid Image file");
									return 0;
								}
							}

							//  Preview the Edited Image;
							$('.preview-crop').on('click', function(e) {
								e.preventDefault();
								e.stopPropagation();
								var $this = $(this);

								if (!$this.hasClass('preview')) {
									$this.addClass('preview');
									$this.text("Cancel Preview");
									$('.overlay-preview').fadeIn(100);
								} else {
									$this.removeClass('preview');
									$this.text("Preview");
									$('.overlay-preview').fadeOut(50);

								}
							});
							//    Event Triggers on file upload
							$('body').on('change', '#uploaded-img', function() {
								var $this = this;
								if (isImage($this)) {
									loaduploadedImage($this);
								}
							});

						});
	</script>
</body>
</html>