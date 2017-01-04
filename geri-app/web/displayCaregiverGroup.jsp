<%-- 
    Document   : displayCaregiverGroup
    Created on : Dec 22, 2016, 4:13:46 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "geriapp.entity.Patient"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Gerification | Display Caregiver Group</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="images/icons/favicon.ico">
        <link rel="apple-touch-icon" href="images/icons/favicon.png">
        <link rel="apple-touch-icon" sizes="72x72" href="images/icons/favicon-72x72.png">
        <link rel="apple-touch-icon" sizes="114x114" href="images/icons/favicon-114x114.png">
        <!--Loading bootstrap css-->
        <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,700">
        <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,700,300">
        <link type="text/css" rel="stylesheet" href="styles/jquery-ui-1.10.4.custom.min.css">
        <link type="text/css" rel="stylesheet" href="styles/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="styles/bootstrap.min.css">
        <link type="text/css" rel="stylesheet" href="styles/animate.css">
        <link type="text/css" rel="stylesheet" href="styles/all.css">
        <link type="text/css" rel="stylesheet" href="styles/main.css">
        <link type="text/css" rel="stylesheet" href="styles/style-responsive.css">
        <link type="text/css" rel="stylesheet" href="styles/zabuto_calendar.min.css">
        <link type="text/css" rel="stylesheet" href="styles/pace.css">
        <link type="text/css" rel="stylesheet" href="styles/jquery.news-ticker.css">

    </head>
    <body>
        <div>
            <!--BEGIN THEME SETTING-->
            <div id="theme-setting">
                <a href="#" data-toggle="dropdown" data-step="1" data-intro=""
                   data-position="left" class="btn-theme-setting"><i class="fa fa-cog"></i></a>
                <div class="content-theme-setting">
                    <select id="list-style" class="form-control">
                        <option value="style1">Flat Squared style</option>
                        <option value="style2">Flat Rounded style</option>
                        <option value="style3" selected="selected">Flat Border style</option>
                    </select>
                </div>
            </div>
            <!--END THEME SETTING-->
            <!--BEGIN BACK TO TOP-->
            <a id="totop" href="#"><i class="fa fa-angle-up"></i></a>
            <!--END BACK TO TOP-->
            <!--BEGIN TOPBAR-->
            <div id="header-topbar-option-demo" class="page-header-topbar">
                <nav id="topbar" role="navigation" style="margin-bottom: 0;" data-step="3" class="navbar navbar-default navbar-static-top">
                    <div class="navbar-header">
                        <button type="button" data-toggle="collapse" data-target=".sidebar-collapse" class="navbar-toggle"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                        <a id="logo" href="#" class="navbar-brand"><span class="fa fa-rocket"></span><span class="logo-text">Gerification</span><span style="display: none" class="logo-text-icon">µ</span></a></div>
                    <div class="topbar-main">


                        <div class="news-update-box hidden-xs"><span class="text-uppercase mrm pull-left text-white">News:</span>
                            <ul id="news-update" class="ticker list-unstyled">
                                <li>Welcome to Gerification</li>

                            </ul>
                        </div>
                        <ul class="nav navbar navbar-top-links navbar-right mbn">
                            <li class="dropdown"><a data-hover="dropdown" href="#" class="dropdown-toggle"><i class="fa fa-bell fa-fw"></i></a>

                            </li>
                            <li class="dropdown"><a data-hover="dropdown" href="#" class="dropdown-toggle"><i class="fa fa-envelope fa-fw"></i></a>

                            </li>
                            <li class="dropdown"><a data-hover="dropdown" href="#" class="dropdown-toggle"><i class="fa fa-tasks fa-fw"></i></a>

                            </li>
                            <li class="dropdown topbar-user"><a data-hover="dropdown" href="#" class="dropdown-toggle"><img src="images/avatar/48.jpg" alt="" class="img-responsive img-circle"/>&nbsp;<span class="hidden-xs">Jessica Bong</span>&nbsp;<span class="caret"></span></a>
                                <ul class="dropdown-menu dropdown-user pull-right">
                                    <li><a href="#"><i class="fa fa-user"></i>My Profile</a></li>
                                    <li><a href="#"><i class="fa fa-calendar"></i>My Calendar</a></li>
                                    <li><a href="#"><i class="fa fa-envelope"></i>My Inbox<span class="badge badge-danger">3</span></a></li>
                                    <li><a href="#"><i class="fa fa-tasks"></i>My Tasks<span class="badge badge-success">7</span></a></li>
                                    <li class="divider"></li>
                                    <li><a href="#"><i class="fa fa-lock"></i>Lock Screen</a></li>
                                    <li><a href="Login.html"><i class="fa fa-key"></i>Log Out</a></li>
                                </ul>
                            </li>
                            <li id="topbar-chat" class="hidden-xs"><a href="javascript:void(0)" data-step="4" data-intro="" data-position="left" class="btn-chat"><i class="fa fa-comments"></i></a></li>
                        </ul>
                    </div>
                </nav>
                <!--BEGIN MODAL CONFIG PORTLET-->
                <div id="modal-config" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" data-dismiss="modal" aria-hidden="true" class="close">
                                    &times;</button>
                                <h4 class="modal-title">
                                    Modal title</h4>
                            </div>
                            <div class="modal-body">
                                <p>
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eleifend et nisl eget
                                    porta. Curabitur elementum sem molestie nisl varius, eget tempus odio molestie.
                                    Nunc vehicula sem arcu, eu pulvinar neque cursus ac. Aliquam ultricies lobortis
                                    magna et aliquam. Vestibulum egestas eu urna sed ultricies. Nullam pulvinar dolor
                                    vitae quam dictum condimentum. Integer a sodales elit, eu pulvinar leo. Nunc nec
                                    aliquam nisi, a mollis neque. Ut vel felis quis tellus hendrerit placerat. Vivamus
                                    vel nisl non magna feugiat dignissim sed ut nibh. Nulla elementum, est a pretium
                                    hendrerit, arcu risus luctus augue, mattis aliquet orci ligula eget massa. Sed ut
                                    ultricies felis.</p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" data-dismiss="modal" class="btn btn-default">
                                    Close</button>
                                <button type="button" class="btn btn-primary">
                                    Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!--END MODAL CONFIG PORTLET-->
            </div>
            <!--END TOPBAR-->
            <div id="wrapper">
                <!--BEGIN SIDEBAR MENU-->
                <nav id="sidebar" role="navigation" data-step="2" data-intro="Template has &lt;b&gt;many navigation styles&lt;/b&gt;"
                     data-position="right" class="navbar-default navbar-static-side">
                    <div class="sidebar-collapse menu-scroll">
                        <ul id="side-menu" class="nav">

                            <div class="clearfix"></div>
                            <li class="active"><a href="home.jsp"><i class="fa fa-tachometer fa-fw">
                                        <div class="icon-bg bg-orange"></div>
                                    </i><span class="menu-title">Dashboard</span></a></li>
                            <li><a href="patientData.jsp"><i class="fa fa-desktop fa-fw">
                                        <div class="icon-bg bg-pink"></div>
                                    </i><span class="menu-title">Patients Data</span></a>

                            </li>
                            <li><a href="medbox.jsp"><i class="fa fa-send-o fa-fw">
                                        <div class="icon-bg bg-green"></div>
                                    </i><span class="menu-title">Medbox</span></a>

                            </li>
                        </ul>
                    </div>
                </nav>
                <!--END SIDEBAR MENU-->
                <!--BEGIN CHAT FORM-->
                <!--END CHAT FORM-->
                <!--BEGIN PAGE WRAPPER-->
                <div id="page-wrapper">
                    <!--BEGIN TITLE & BREADCRUMB PAGE-->
                    <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
                        <div class="page-header pull-left">
                            <div class="page-title">
                                Caregiver Group</div>
                        </div>
                        <ol class="breadcrumb page-breadcrumb pull-right">
                            <li><i class="fa fa-home"></i>&nbsp;<a href="home.jsp">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                            <li class="hidden"><a href="#">Caregiver Group</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                            <li class="active">Caregiver Group</li>
                        </ol>
                        <div class="clearfix">
                        </div>
                    </div>
                    <!--END TITLE & BREADCRUMB PAGE-->
                    <!--BEGIN CONTENT-->
                    <%
                        Patient patient = (Patient) request.getAttribute("patient");
                        System.out.println("Display" + patient);
                    %>
                    <div class="page-content">
                        <div id="tab-general">
                            <div id="sum_box" class="row mbl"> 
                                <div class="col-md-2 col-lg-2"></div>
                                <div class="col-md-6 col-lg-8">
                                    <div class="panel panel-grey">
                                        <div class="panel-heading">
                                            <div class="row">
                                                <div class="col-lg-12 text-center">
                                                    <div class="form-group">
                                                        <img src="http://www.clacksweb.org.uk/images/icons/elderly.gif" alt="" class="Patient_Img"/>                                                            
                                                    </div>                                                    
                                                        <label name="inputPatientName"><%=patient.getName()%></label>
                                                        <label name="inputPatientNRIC">(<%=patient.getNRIC()%>)</label><br/>
                                                        <label name="inputPatientPhone"><%=patient.getPhone()%></label><br/>
                                                        <label name="inputPatientAddress"><%=patient.getAddress()%></label><br/>
                                                        <label name="inputPatientNotes"><%=patient.getNotes()%></label><br/>
                                                        <label name="inputPatientName"><%=patient.getPhoto()%></label><br/>                                                    
                                                </div>

                                            </div>
                                        </div>

                                        <div class="panel-body pan">
                                            <form action="caregiverGroupServlet" method ="get" >
                                                <div class="form-body pal">
                                                    <div class="row">                                                        
                                                        <div class="col-lg-8">
                                                            <div class="form-group">
                                                                <div class="input-icon">
                                                                    <i class="fa fa-book"></i>
                                                                    <label name="inputPatientNRIC" class="form-control"/>
                                                                </div>                                                            
                                                            </div>                                                            
                                                            <div class="form-group">
                                                                <div class="input-icon">
                                                                    <i class="fa fa-list"></i>
                                                                    <label name="inputPatientInformation" class="form-control"/>
                                                                </div>                                                            
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="input-icon">
                                                                    <i class="fa fa-ambulance"></i>
                                                                    <label name="inputCaregivers" class="form-control"/>
                                                                </div> 
                                                            </div>
                                                            <div class="form-group"> 
                                                                <button type="submit" class="btn btn-block btn-primary">Create Group</button>                                                                
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-4">
                                                            <div class="form-group">
                                                                <div class="text-center mbl"><img src="http://www.clacksweb.org.uk/images/icons/elderly.gif" alt="" class="Patient_Img"/></div>
                                                                <div class="text-center mbl"><a href="#" class="btn btn-success"><i class="fa fa-plus"></i>&nbsp; Add New Rule</a></div>
                                                            </div>
                                                        </div>                                          
                                                    </div>
                                                    <div class="row"> 
                                                        <div class="col-lg-4">
                                                            <div class="form-group">
                                                                <label name="inputCaregivers" class="form-control"/>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-4">
                                                            <div class="col-lg-4">
                                                                <div class="form-group">
                                                                    <label name="inputCaregivers" class="form-control"/>
                                                                </div>
                                                            </div> 
                                                        </div>
                                                    </div>
                                                </div>
                                            </form>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--END CONTENT-->
                    <!--BEGIN FOOTER-->
                    <div id="footer">
                        <div class="copyright">
                            <a href="#">2016 © Gerification</a></div>
                    </div>
                    <!--END FOOTER-->
                </div>
                <!--END PAGE WRAPPER-->
            </div>
        </div>
        <script src="script/jquery-1.10.2.min.js"></script>
        <script src="script/jquery-migrate-1.2.1.min.js"></script>
        <script src="script/jquery-ui.js"></script>
        <script src="script/bootstrap.min.js"></script>
        <script src="script/bootstrap-hover-dropdown.js"></script>
        <script src="script/html5shiv.js"></script>
        <script src="script/respond.min.js"></script>
        <script src="script/jquery.metisMenu.js"></script>
        <script src="script/jquery.slimscroll.js"></script>
        <script src="script/jquery.cookie.js"></script>
        <script src="script/icheck.min.js"></script>
        <script src="script/custom.min.js"></script>
        <script src="script/jquery.news-ticker.js"></script>
        <script src="script/jquery.menu.js"></script>
        <script src="script/pace.min.js"></script>
        <script src="script/holder.js"></script>
        <script src="script/responsive-tabs.js"></script>
        <!--<script src="script/jquery.flot.js"></script>
        <script src="script/jquery.flot.categories.js"></script>
        <script src="script/jquery.flot.pie.js"></script>
        <script src="script/jquery.flot.tooltip.js"></script>
        <script src="script/jquery.flot.resize.js"></script>
        <script src="script/jquery.flot.fillbetween.js"></script>
        <script src="script/jquery.flot.stack.js"></script>
        <script src="script/jquery.flot.spline.js"></script> 
        <script src="script/index.js"></script> -->
        <script src="script/zabuto_calendar.min.js"></script>

        <!--LOADING SCRIPTS FOR CHARTS-->
        <!-- <script src="script/highcharts.js"></script>
        <script src="script/data.js"></script>
        <script src="script/drilldown.js"></script>
        <script src="script/exporting.js"></script>
        <script src="script/highcharts-more.js"></script>
        <script src="script/charts-highchart-pie.js"></script>
        <script src="script/charts-highchart-more.js"></script> -->
        <!--CORE JAVASCRIPT-->
        <script src="script/main.js"></script>
        <script>        (function (i, s, o, g, r, a, m) {
                i['GoogleAnalyticsObject'] = r;
                i[r] = i[r] || function () {
                    (i[r].q = i[r].q || []).push(arguments)
                }, i[r].l = 1 * new Date();
                a = s.createElement(o),
                        m = s.getElementsByTagName(o)[0];
                a.async = 1;
                a.src = g;
                m.parentNode.insertBefore(a, m)
            })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
            ga('create', 'UA-145464-12', 'auto');
            ga('send', 'pageview');


        </script>
    </body>
</html>
