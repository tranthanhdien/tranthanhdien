<!DOCTYPE html>
<html>

    <jsp:include page="WEB-INF/head_tag.jsp">
        <jsp:param name="title" value="Login" />
    </jsp:include>

<body>
    <nav class="container-fluid" id="main-nav-login">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <a href="/" id="logo-large">BMAGBOOK</a>
                </div>
            </div>
        </div>
    </nav>

    <section class="container-fluid" style="background-color: #e9ebee; margin-top:-30px;">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form action="ProcessLogin" method="post" id="body-login-form">
                        <label>Login to BMAGBOOK</label>
                        <div class="alert-danger">
                            ${sessionScope.message}
                        </div>
                        <input type="text" name="user-login-id" placeholder="Email address or phone number" />
                        <input type="password" name="user-login-password" placeholder="Password" />
                        <button type="submit" name="action" value="Login" id="btn-login">Login</button>
                        <a href="/">Forgotten password?</a>
                        <a href="/">Signup for BMAGBook?</a>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <footer class="container">
        <ul id="lans">
            <li>English (UK)</li>
            <li>
                <a href="#">Tiếng việt</a>
            </li>
            <li>
                <a href="#">中文(台灣)</a>
            </li>
            <li>
                <a href="#">한국어</a>
            </li>
            <li>
                <a href="#">日本語</a>
            </li>
            <li>
                <a href="#">Français (France)</a>
            </li>
            <li>
                <a href="#">ภาษาไทย</a>
            </li>
            <li>
                <a href="#">Español</a>
            </li>
            <li>
                <a href="#">Português (Brasil)</a>
            </li>
            <li>
                <a href="#">Deutsch</a>
            </li>
            <li>
                <a href="#">Italiano</a>
            </li>
            <li>+</li>
        </ul>
        <ul id="footer-tools">
            <li><a href="/">Sign Up</a></li>
            <li>
                <a href="#">Log In</a>
            </li>
            <li>
                <a href="#">Messenger</a>
            </li>
            <li>
                <a href="#">Facebook Lite</a>
            </li>
            <li>
                <a href="#">Mobile</a>
            </li>
            <li>
                <a href="#">Find Friends</a>
            </li>
            <li>
                <a href="#">Badges</a>
            </li>
            <li>
                <a href="#">People</a>
            </li>
            <li>
                <a href="#">Pages</a>
            </li>
            <li>
                <a href="#">Places</a>
            </li>
            <li>
                <a href="#">Games</a>
            </li>
            <li><a href="/">Locations</a></li>
            <li>
                <a href="#">Celebrities</a>
            </li>
            <li>
                <a href="#">Groups</a>
            </li>
            <li>
                <a href="#">Facebook Lite</a>
            </li>
            <li>
                <a href="#">Mobile</a>
            </li>
            <li>
                <a href="#">Find Friends</a>
            </li>
            <li>
                <a href="#">Badges</a>
            </li>
            <li>
                <a href="#">People</a>
            </li>
            <li>
                <a href="#">Pages</a>
            </li>
            <li>
                <a href="#">Places</a>
            </li>
            <li>
                <a href="#">Games</a>
            </li>
        </ul>
        BMAGBOOK &copy; 2016
    </footer>
</body>

</html>
