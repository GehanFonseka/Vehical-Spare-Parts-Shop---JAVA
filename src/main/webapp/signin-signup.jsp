<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Motor Mart</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Molla - Bootstrap Template</title>
<meta name="keywords" content="HTML5 Template">
<meta name="description" content="Molla - Bootstrap eCommerce Template">
<meta name="author" content="p-themes">
<!-- Favicon -->
<link rel="apple-touch-icon" sizes="180x180" href="assets/images/icons/apple-touch-icon.png">
<link rel="icon" type="image/png" sizes="32x32" href="assets/images/icons/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="assets/images/icons/favicon-16x16.png">
<link rel="manifest" href="assets/images/icons/site.html">
<link rel="mask-icon" href="assets/images/icons/safari-pinned-tab.svg" color=" #ADD8E6;">
<link rel="shortcut icon" href="assets/images/icons/favicon.ico">
<meta name="apple-mobile-web-app-title" content="Molla">
<meta name="application-name" content="Molla">
<meta name="msapplication-TileColor" content="#cc9966">
<meta name="msapplication-config" content="assets/images/icons/browserconfig.xml">
<meta name="theme-color" content=" #ADD8E6;">
<!-- Plugins CSS File -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<!-- Main CSS File -->
<link rel="stylesheet" href="assets/css/style.css">

<style>
    body {
        background-color: #ADD8E6; /* Light blue background */
    }
</style>
</head>
<body>
	
	
    <div class="login-page bg-image pt-8 pb-8 pt-md-12 pb-md-12 pt-lg-17 pb-lg-17" style="background-image: url('bg.jpg')">
        <div class="container">
            <div class="form-box">
                <div class="form-tab">
                    <ul class="nav nav-pills nav-fill" role="tablist">
                        <a href="home.jsp" >Home</a>
                        <li class="nav-item">
                            <a class="nav-link active" id="signin-tab-2" data-toggle="tab" href="#signin-2" role="tab" aria-controls="signin-2" aria-selected="true">Sign In</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="register-tab-2" data-toggle="tab" href="#register-2" role="tab" aria-controls="register-2" aria-selected="false">Register</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane fade show active" id="signin-2" role="tabpanel" aria-labelledby="signin-tab-2">
                            <form action="login" method="post">
                                <div class="form-group">
                                    <label for="singin-email-2">Email address *</label>
                                    <input type="text" class="form-control" id="email" name="email" required>
                                </div><!-- End .form-group -->
                            
                                <div class="form-group">
                                    <label for="singin-password-2">Password *</label>
                                    <input type="password" class="form-control" id="password" name="password" required>
                                </div><!-- End .form-group -->
                            
                                <div class="form-footer">
                                    <button type="submit" class="btn btn-outline-primary-2">
                                        <span>LOG IN</span>
                                        <i class="icon-long-arrow-right"></i>
                                    </button>
                            
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input" id="signin-remember-2">
                                        <label class="custom-control-label" for="signin-remember-2">Remember Me</label>
                                    </div><!-- End .custom-checkbox -->
                            
                                    
                                </div><!-- End .form-footer -->
                            </form>

                          <!-- End .form-choice -->
                        </div><!-- .End .tab-pane -->
                        <div class="tab-pane fade" id="register-2" role="tabpanel" aria-labelledby="register-tab-2">
                            <form action="register" method="post">                                      
                            
                                <fieldset class="form-group">
                                    <label>Name</label>
                                    <input type="text"  class="form-control" name="name" required="required">
                                </fieldset>
                            
                                <fieldset class="form-group">
                                    <label>Email</label>
                                    <input type="email"  class="form-control" name="email" required="required">
                                </fieldset>
                            
                                <fieldset class="form-group">
                                    <label>Phone Number</label>
                                    <input type="text"  class="form-control" name="phoneNumber" required="required" pattern="[0-9]{10}" title="Please enter a 10-digit phone number">
                                </fieldset>
                            
                                <fieldset class="form-group">
                                    <label>Address</label>
                                    <input type="text"  class="form-control" name="address" required="required">
                                </fieldset>
                            
                                <fieldset class="form-group">
                                    <label>Password</label>
                                    <input type="password" class="form-control" name="password" required="required" pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{1,6}$" title="Password must contain at least one letter, one number, and be at most 6 characters long">
                                </fieldset>
                            
                                <div class="form-footer">
                                    <button type="submit" class="btn btn-outline-primary-2">
                                        <span>SIGN UP</span>
                                        <i class="icon-long-arrow-right"></i>
                                    </button>
                            
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input" id="register-policy-2" required>
                                        <label class="custom-control-label" for="register-policy-2">I agree to the <a href="#">privacy policy</a> *</label>
                                    </div><!-- End .custom-checkbox -->
                                </div><!-- End .form-footer -->
                            </form>

                           <!-- End .form-choice -->
                        </div><!-- .End .tab-pane -->
                    </div><!-- End .tab-content -->
                </div><!-- End .form-tab -->
            </div><!-- End .form-box -->
        </div><!-- End .container -->
    </div><!-- End .login-page section-bg -->
            
<!-- Plugins JS File -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/jquery.hoverIntent.min.js"></script>

<!-- Main JS File -->
<script src="assets/js/main.js"></script>
</body>
</html>
