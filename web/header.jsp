<%-- 
    Document   : header
    Created on : Jul 20, 2013, 2:46:58 PM
    Author     : afonso
--%>

<%@page import="br.uniriotec.tracker.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/libs/bootstrap.min.css">
        <link rel="stylesheet" href="styles/libs/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="styles/style.css">

        <script src="scripts/libs/jquery.js" type="text/javascript" ></script>
        <script src="scripts/libs/bootstrap.min.js" type="text/javascript" ></script>
        <script src="scripts/app.js" type="text/javascript" ></script>

        <title>Bug Tracking System</title>
    </head>
    <body>

        <!-- HEADER -->
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="brand" href="/BugTrackingSystem">Bug Tracking System</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <%
                                if (session.getAttribute("loginStatus") == "LOGGED") {
                            %>
                            <li>
                                <a href="login.jsp">Home</a>
                            </li>
                            <li>
                                <a href="systemList.do">Systems</a>
                            </li>
                            <li>
                                <a href="componentList.do">Components</a>
                            </li>
                            <li>
                                <a href="ticketList.do">Tickets</a>
                            </li>



                            <%
                                User user = (User) session.getAttribute("loginUser");
                                System.out.println("user.getType() :");
                                System.out.println(user.getType().toString());

                                if (user.getType().equalsIgnoreCase("ADM")) {
                            %>

                            <li>
                                <a href="userList.do">Users</a>
                            </li>

                            <%                        }
                            %>




                            <%
                                }
                            %>
                        </ul>
                    </div>

                    <%
                        if (session.getAttribute("loginStatus") == "LOGGED") {
                    %>


                    <div class="pull-right">
                        <ul class="nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <%
                                        User user = (User) session.getAttribute("loginUser");
                                        out.println(user.getName() + " " + user.getLastName());
                                    %>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="nav-header">Last Logon on 
                                        <% out.println(user.getLastLogonTime());%>
                                    </li>
                                    <li><a href="accountEdit.jsp">Edit Account</a></li>
                                    <li><a href="forgotPassword.jsp">Change Password</a></li>
                                    <li><a href="logout.do">Logout</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>

                    <%
                        }
                    %>

                </div>
            </div>
        </div>

        <!-- CONTAINER -->
        <div class="container">
