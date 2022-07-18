<%-- 
    Document   : Header
    Created on : May 26, 2022, 1:11:46 AM
    Author     : 84384
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- header section starts -->
<header class="header_section">
    <div class="container">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
            <a class="navbar-brand" href="home">
                <span>
                    Chat
                </span>
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class=""> </span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav  mx-auto ">
                    <c:if test="${sessionScope.user_account.role eq 'admin'}">
                        <li class="nav-item">
                            <a class="nav-link" href="admin/dashboard">Admin</a>
                        </li>
                    </c:if>
                    <li class="nav-item active">
                        <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="menu">Menu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="About.jsp">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Book.jsp">Book Table</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Chatting.jsp">Chatting</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="getreview">Review</a>
                    </li>
                </ul>
                <div class="user_option">
                    <a href="profile" class="user_link">
                        <i class="fa fa-user" aria-hidden="true"></i>
                    </a>
                    <a class="cart_link" href="cart">
                        <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 456.029 456.029" style="enable-background:new 0 0 456.029 456.029;" xml:space="preserve">
                        <g>
                        <g>
                        <path d="M345.6,338.862c-29.184,0-53.248,23.552-53.248,53.248c0,29.184,23.552,53.248,53.248,53.248
                              c29.184,0,53.248-23.552,53.248-53.248C398.336,362.926,374.784,338.862,345.6,338.862z" />
                        </g>
                        </g>
                        <g>
                        <g>
                        <path d="M439.296,84.91c-1.024,0-2.56-0.512-4.096-0.512H112.64l-5.12-34.304C104.448,27.566,84.992,10.67,61.952,10.67H20.48
                              C9.216,10.67,0,19.886,0,31.15c0,11.264,9.216,20.48,20.48,20.48h41.472c2.56,0,4.608,2.048,5.12,4.608l31.744,216.064
                              c4.096,27.136,27.648,47.616,55.296,47.616h212.992c26.624,0,49.664-18.944,55.296-45.056l33.28-166.4
                              C457.728,97.71,450.56,86.958,439.296,84.91z" />
                        </g>
                        </g>
                        <g>
                        <g>
                        <path d="M215.04,389.55c-1.024-28.16-24.576-50.688-52.736-50.688c-29.696,1.536-52.224,26.112-51.2,55.296
                              c1.024,28.16,24.064,50.688,52.224,50.688h1.024C193.536,443.31,216.576,418.734,215.04,389.55z" />
                        </g>
                        </g>

                        </svg>
                    </a>
                    <form action="search" method="post" id="search-box" class="form-row">
                        <input type="search" name="txt" id="search-text"
                               placeholder="Bạn muốn ăn gì?"
                               required>
                        <button class="btn  my-2 my-sm-0 nav_search-btn" type="submit" id="search-btn">
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </button>
                    </form>
                    <%User x = (User) request.getSession().getAttribute("user");%>
                    <% if (x != null) {
                    %>
                    <nav class="navbar navbar-dark bg-dark navbar-expand-sm">

                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-list-4" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbar-list-4">
                            <ul class="navbar-nav">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <img src="<%=x.getAvatar()%>" width="40" height="40" class="rounded-circle">
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                        <a class="dropdown-item" href="profile">Profile</a>
                                        <a class="dropdown-item" href="logout">Log Out</a>
                                    </div>
                                </li>   
                            </ul>
                        </div>
                    </nav>
                    <%                } else if (x == null) {
                    %>
                    <a href="login" class="order_online">
                        Sign in
                    </a>
                    <a href="SignUp.jsp" class="order_online">
                        Sign up
                    </a>
                    <%
                        }

                    %>

                </div>
            </div>
        </nav>
    </div>
</header>
<!-- end header section -->
