<%-- 
    Document   : index
    Created on : 19 oct. 2017, 11:54:49
    Author     : thomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html
    <html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MultiVote</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="css/freelancer.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

</head>

<body id="page-top" class="index">



    <!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="./index.html">MultiVote</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="./inscription.html" target="_blank">S'inscire</a>
                    </li>
                    <form class="navbar-form navbar-right inline-form" action="Connexion" method="post">
                        <div class="form-group"">
                            <input type="email" class="input-sm form-control" name="email1" id="email1" placeholder="Email" margin-right="0">
                            <input type="password" class="input-sm form-control" name="password1" id="password1" placeholder="Mot de passe" margin-right="0">
                            <input type="submit" class="btn btn-primary btn-sm"value="Connexion">
                            <%
                                if (request.getAttribute("info") != null) {
                                    out.println("<h5>" + "<font color=\"white\">" + request.getAttribute("info").toString() + "</font>" + "</h4>");
                            }%>

                        </div>
                    </form>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Header -->
    <header>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-text">
                            <span class="name">MultiVote</span>
                            <hr class="star-light">
                            <span class="skills">Le site du vote en ligne</span>
                            <br><br><br><br>
                            <div class="form-group col-xs-12">
                                <a href="./inscription.html" target="_blank"><button type="submit" class="btn btn-success btn-lg"  >S'inscrire</button></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </header>




    <!-- Footer -->
    <footer class="text-center" id="contact">
        <div class="footer-below">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        Copyright &copy; MultiVote
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-top page-scroll hidden-sm hidden-xs hidden-lg hidden-md">
        <a class="btn btn-primary" href="#page-top">
            <i class="fa fa-chevron-up"></i>
        </a>
    </div>



    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="js/freelancer.min.js"></script>

</body>
</html>