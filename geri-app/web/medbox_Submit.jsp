<%-- 
    Document   : medbox
    Created on : Nov 2, 2016, 4:57:52 AM
    Author     : ASUS
--%>

<%@page import="org.apache.http.impl.client.CloseableHttpClient"%>
<%@page import="org.apache.http.impl.client.HttpClientBuilder"%>
<%@page import="java.io.IOException"%>
<%@page import="org.apache.http.client.HttpClient"%>
<%@page import="org.apache.http.HttpResponse"%>
<%@page import="org.apache.http.client.methods.HttpGet"%>
<%@page import="com.twilio.sdk.resource.instance.Account"%>
<%@page import="com.twilio.sdk.TwilioRestClient"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.twilio.sdk.resource.factory.SmsFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Timer"%>
<%@page import="java.util.TimerTask"%>
<%@page import="geriapp.controller.MedboxEventController"%>
<%@page import="org.apache.http.client.ClientProtocolException"%>"

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //MedboxEventController medboxEventController = (MedboxEventController) session.getAttribute("medboxEventController");
    ArrayList<String> valuesList = (ArrayList<String>) session.getAttribute("values");
    String patientId = valuesList.get(0);
    String thresholdNo = valuesList.get(1);
    String numDosage = valuesList.get(2);
    String numMissed = valuesList.get(3);

    //String toPhone = "+6586568835";
    //String TWILIO_ACCOUNT_SID = "ACec01a875b5cc448f2b2e903087059d29";
    //String TWILIO_AUTH_TOKEN = "16f2063d70f35433fb14a141c308becf";
    //String TWILIO_NUMBER = "+447481337150";
    //TwilioRestClient twilioClient = new TwilioRestClient(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
    //Account userAccount = twilioClient.getAccount();

%>
<html lang="en">
    <head>
        <title>Gerification | Medbox</title>
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
    <script type="text/javascript">
        // set minutes
        var mins = 1;

        // calculate the seconds (don't change this! unless time progresses at a different speed for you...)
        var secs = mins * 60;
        function countdown() {
            setTimeout('Decrement()', 1000);

        }

        <%  

            //SmsFactory smsFactory = userAccount.getSmsFactory();
            //Map<String, String> smsParams = new HashMap<String, String>();
            //smsParams.put("To", toPhone);
            //smsParams.put("From", TWILIO_NUMBER);
            //smsParams.put("Body", checkAlarm);
            //smsFactory.create(smsParams);

        %>

        function Decrement() {
            if (document.getElementById) {
                //minutes = document.getElementById("minutes");
                seconds = document.getElementById("seconds");
                // if less than a minute remaining
                if (seconds < 59) {
                    seconds.value = secs;
                } else {
                    minutes.value = getminutes();
                    seconds.value = getseconds();
                }

                if (seconds.value > 0) {
                    secs--;
                    setTimeout('Decrement()', 1000);
                } else {
                    exit;
                }

            }
        }
        function getminutes() {
            // minutes is seconds divided by 60, rounded down
            mins = Math.floor(secs / 60);
            return mins;
        }
        function getseconds() {
            // take mins remaining (as seconds) away from total seconds remaining
            return secs - Math.round(mins * 60);
        }
    </script>
    <body>
        <script>
            countdown();
        </script>
        <%  
            
            int threshold = Integer.parseInt(thresholdNo)*1000;
            int numOfTakes = Integer.parseInt(numDosage);
            int numOfMissed = Integer.parseInt(numMissed);
            /*
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpGet newRequest = new HttpGet("http://default-environment.bxypxxac43.ap-southeast-1.elasticbeanstalk.com/MedboxTimer?threshold="+threshold+"&numOfTakes="+numOfTakes+"&numOfMissed="+numOfMissed);
            try{
                HttpResponse thisResponse = client.execute(newRequest);
            }catch(ClientProtocolException e){
                e.printStackTrace();
            }
            */
        %>
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
                            <li class="active"><a href="dashboard.html"><i class="fa fa-tachometer fa-fw">
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
                <div id="page-wrapper">
                    <!--BEGIN TITLE & BREADCRUMB PAGE-->
                    <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
                        <div class="page-header pull-left">
                            <div class="page-title">
                                Medication Box Rule</div>
                        </div>
                        <ol class="breadcrumb page-breadcrumb pull-right">
                            <li><i class="fa fa-home"></i>&nbsp;<a href="dashboard.html">Home</a>&nbsp;&nbsp;<i
                                    class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                            <li class="hidden"><a href="#">Forms</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                            <li class="active">Medication Box Rule</li>
                        </ol>
                        <div class="clearfix">
                        </div>
                    </div>
                    <!--END TITLE & BREADCRUMB PAGE-->
                    <!--BEGIN CONTENT-->
                    <div class="page-content">
                        <div id="tab-general">
                            <div class="row mbl">
                                <div class="col-lg-12">
                                    <div class="col-md-12">
                                        <div id="area-chart-spline" style="width: 100%; height: 300px; display: none;">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="row">
                                        <div class="col-lg-4">

                                        </div>
                                        <div class="col-lg-4">
                                            <div class="panel panel-yellow">
                                                <div class="panel-heading">
                                                    Medication Rule - Timer
                                                </div>

                                                <div class="panel-body pan">
                                                    <form action="#" class="form-horizontal">
                                                        <div class="form-body pal">
                                                            <div class="form-group">
                                                                <label for="patientId" class="col-md-3 control-label">
                                                                    Patient Id</label>
                                                                <div class="col-md-9">
                                                                    <div class="input-icon right">
                                                                        <label name="patientId" placeholder="" class="form-control"><%=patientId%></label></div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="thresholdNo" class="col-md-3 control-label">
                                                                    Threshold (hours)</label>
                                                                <div class="col-md-9">
                                                                    <div class="input-icon right">
                                                                        <label name="thresholdNo" placeholder="" class="form-control"><%=thresholdNo%></label></div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="NumDosage" class="col-md-3 control-label">
                                                                    No.  of Dosage</label>
                                                                <div class="col-md-9">
                                                                    <div class="input-icon right">
                                                                        <label name="NumDosage" placeholder="" class="form-control"><%=numOfTakes%></label></div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="NumMissed" class="col-md-3 control-label">
                                                                    No. of Missed</label>
                                                                <div class="col-md-9">
                                                                    <div class="input-icon right">
                                                                        <label name="NumMissed" placeholder="" class="form-control"><%=numOfMissed%></label></div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <div class="col-md-12">

                                                                    <div id="timer"> 
                                                                        This is only valid for the next <input id="minutes" type="text" /> minutes and <input id="seconds" type="text" /> seconds.
                                                                    </div>


                                                                </div>
                                                            </div>
                                                        </div>


                                                    </form>
                                                </div>
                                            </div>


                                        </div>
                                        <div class="col-lg-4">


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
        <script src="script/jquery.flot.js"></script>
        <script src="script/jquery.flot.categories.js"></script>
        <script src="script/jquery.flot.pie.js"></script>
        <script src="script/jquery.flot.tooltip.js"></script>
        <script src="script/jquery.flot.resize.js"></script>
        <script src="script/jquery.flot.fillbetween.js"></script>
        <script src="script/jquery.flot.stack.js"></script>
        <script src="script/jquery.flot.spline.js"></script>
        <script src="script/zabuto_calendar.min.js"></script>
        <script src="script/index.js"></script>
        <!--LOADING SCRIPTS FOR CHARTS-->
        <script src="script/highcharts.js"></script>
        <script src="script/data.js"></script>
        <script src="script/drilldown.js"></script>
        <script src="script/exporting.js"></script>
        <script src="script/highcharts-more.js"></script>
        <script src="script/charts-highchart-pie.js"></script>
        <script src="script/charts-highchart-more.js"></script>
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
