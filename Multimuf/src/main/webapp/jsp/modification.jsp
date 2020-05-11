<%-- 
    Document   : modification
    Created on : 19 oct. 2017, 11:20:08
    Author     : nacer
--%>

<%@page import="DAO.UserDAO"%>
<%@page import="DAO.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>MultiVote</title>

        <!-- Bootstrap Core CSS -->
        <link href="../vendor/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Theme CSS -->
        <link href="../css/freelancer.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    </head>
    <body id="page-top" class="index">



        <!--recuperation des mail et mot de passe de la session    -->
        <%

            if (request.getAttribute("modif_success") != null) {
                request.setAttribute("info", "Update SUCCESS");
            }

            if (request.getParameter("modifier") != null) {
                String mail = request.getParameter("email");
                String pass = request.getParameter("password");
                String pseudo = request.getParameter("pseudo");
                String confi = request.getParameter("confirmation");
                if (mail != null && !"".equals(mail) && pass != null && !"".equals(pass)
                        && pseudo != null && !"".equals(pseudo) && confi != null && confi != "") {
                    Database db = new Database("testMu");
                    UserDAO user = new UserDAO(db);
                    if (user.getUserByEmail(mail) != null) {
                        request.setAttribute("info", "le mail existe deja");
                    } else {
                        if (pass.equals(confi)) {
                            String email_session = session.getAttribute("email").toString();
                            request.setAttribute("mail", email_session);
                            request.getRequestDispatcher("../UserUpdate").forward(request, response);
                        } else {
                            request.setAttribute("info", "le deux mots de passe sont differents");
                        }

                    }

                } else {
                    request.setAttribute("info", "Vous devez renseigner tous les champs");
                }

            }

            if (request.getAttribute("modif_success") != null) {
                request.setAttribute("info", "Update SUCCESS");
                session.setAttribute("email", request.getParameter("email"));
                session.setAttribute("password", request.getParameter("password"));
            }

        %>

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
                            <a href="../index.html">Deconnexion</a>
                        </li>

                    </ul>
                </div>
            </div>
        </nav>

        <!-- Header -->
        <header>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-text">
                            <span class="name2">Modification</span>

                            <form class="navbar-form inline-form" action="modification.jsp" method="post">
                                <div class="form-group">
                                    <input type="search" class="input-sm form-control" name="pseudo" id="pseudo" placeholder="Pseudo" margin-right="0"><br><br>
                                    <input type="email" class="input-sm form-control" name="email" id="email" placeholder="Email" margin-right="0"><br><br>
                                    <input type="password" class="input-sm form-control" name="password" id="mdp" placeholder="Mot de passe" margin-right="0"><br><br>
                                    <input type="password" class="input-sm form-control" name="confirmation" id="confirmation" placeholder="Confirmer le mot de passe" margin-right="0"><br><br>
                                    <input type="submit"class="btn btn-success btn-lg" value="Modifier" name="modifier">
                                    <%                                        if (request.getAttribute("info") != null) {
                                            out.println("<br><br><h4>" + request.getAttribute("info").toString() + "</h4>");
                                        }%>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </header>




        <!-- Footer -->
        <footer class="text-center" id="contact">
            <div class="footer-below">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            Copyright &copy; Multivote
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
        <script src="../vendor/jquery/jquery.min.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

        <!-- Contact Form JavaScript -->
        <script src="../js/jqBootstrapValidation.js"></script>
        <script src="../js/contact_me.js"></script>

        <!-- Theme JavaScript -->
        <script src="../js/freelancer.min.js"></script>

    </body>

</html>


