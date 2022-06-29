<%-- 
    Document   : ListCategory
    Created on : May 31, 2022, 5:13:21 PM
    Author     : Tuan Phong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin menu</title>
        <meta charset="utf-8">
        
    </head>
    <body>
        <div class="d-flex flex-column flex-shrink-0 p-3 bg-light" style="width: 280px;">
            
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
                <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
                <span class="fs-4">Chatter</span>
            </a>
            <hr>
            <ul class="nav nav-pills flex-column mb-auto">
                <li class="nav-item">
                    <a href="dashboard" class="nav-link link-dark" aria-current="page">
                        <i class="fa-solid fa-house-chimney-window"></i>
                        Home
                    </a>
                </li>
                <li>
                    <a href="dashboard" class="nav-link link-dark" id="dashboard_page">
                        <i class="fa-solid fa-gauge"></i>
                        Dashboard
                    </a>
                </li>
                <li>
                    <a href="list_order" class="nav-link link-dark" id="orders_page">
                        <i class="fa-solid fa-cart-shopping"></i>
                        Orders
                    </a>
                </li>
                <li>
                    <a href="list_product" class="nav-link link-dark" id="products_page">
                        <i class="fa-solid fa-bowl-food"></i>
                        Products
                    </a>
                </li>
                <li>
                    <a href="list_category" class="nav-link link-dark" id="categories_page">
                        <i class="fa-solid fa-qrcode"></i>
                        Categories
                    </a>
                </li>
                <li>
                    <a href="list_customer" class="nav-link link-dark" id="customers_page">
                        <i class="fa-solid fa-person-chalkboard"></i>
                        Customers
                    </a>
                </li>
            </ul>
            <hr>
            <div class="dropdown">
                <a href="#" class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle" id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
                    <strong>mdo</strong>
                </a>
                <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser2">
                    <li><a class="dropdown-item" href="#">New project...</a></li>
                    <li><a class="dropdown-item" href="#">Settings</a></li>
                    <li><a class="dropdown-item" href="#">Profile</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="#">Sign out</a></li>
                </ul>
            </div>
        </div>
        <script>
            document.addEventListener("DOMContentLoaded", function (event) {

                const showNavbar = (toggleId, navId, bodyId, headerId) => {
                    const toggle = document.getElementById(toggleId),
                            nav = document.getElementById(navId),
                            bodypd = document.getElementById(bodyId),
                            headerpd = document.getElementById(headerId)

// Validate that all variables exist
                    if (toggle && nav && bodypd && headerpd) {
                        toggle.addEventListener('click', () => {
// show navbar
                            nav.classList.toggle('show')
// change icon
                            toggle.classList.toggle('bx-x')
// add padding to body
                            bodypd.classList.toggle('body-pd')
// add padding to header
                            headerpd.classList.toggle('body-pd')
                        })
                    }
                }

                showNavbar('header-toggle', 'nav-bar', 'body-pd', 'header')

                /*===== LINK ACTIVE =====*/
                const linkColor = document.querySelectorAll('.nav_link')

                function colorLink() {
                    if (linkColor) {
                        linkColor.forEach(l => l.classList.remove('active'))
                        this.classList.add('active')
                    }
                }
                linkColor.forEach(l => l.addEventListener('click', colorLink))

                // Your code to run since DOM is loaded and ready
            });
            
        </script>
    </body>
</html>
