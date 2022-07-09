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

            <a href="/Chatter" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
                <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
                <span class="fs-4">Chatter</span>
            </a>
            <hr>
            <div class="list-group list-group-flush mx-3 mt-4">
                <ul class="nav nav-pills flex-column mb-auto">
                    <li class="nav-item">
                        <a href="dashboard" class="nav-link link-dark" aria-current="page">
                            <i class="fa-solid fa-house-chimney-window"></i>
                            Home
                        </a>
                    </li>
                    <li>
                        <a href="#collapseDashboard" class="nav-link link-dark list-group-item list-group-item-action py-2 p-3 ripple" id="dashboard_page"
                           data-bs-toggle="collapse" data-bs-target="#collapseDashboard">
                            <i class="fa-solid fa-gauge"></i>
                            <span> Dashboard </span>

                        </a>
                        <!-- Collapsed content -->
                        <ul
                            id="collapseDashboard"
                            class="collapse list-group list-group-flush"
                            >
                            <li class="list-group-item py-1">
                                <a href="/Chatter/admin/dashboard" class="text-reset text-decoration-none ">Dashboard</a>
                            </li>
                            <li class="list-group-item py-1">
                                <a href="/Chatter/admin/order_analysis" class="text-reset text-decoration-none">Order</a>
                            </li>
                            <li class="list-group-item py-1">
                                <a href="" class="text-reset text-decoration-none">...</a>
                            </li>
                            <li class="list-group-item py-1">
                                <a href="" class="text-reset text-decoration-none">...</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="/Chatter/admin/orders" class="nav-link link-dark" id="orders_page">
                            <i class="fa-solid fa-cart-shopping"></i>
                            Orders
                        </a>
                        <!-- Collapsed content -->

                    </li>
                    <li>
                        <a href="/Chatter/admin/booking" class="nav-link link-dark" id="bookings_page">
                           <i class="fa-duotone fa-table-picnic"></i>
                            Bookings list
                        </a>
                        <!-- Collapsed content -->

                    </li>
                    <li>
                        <a href="#collapseProducts" class="nav-link link-dark list-group-item list-group-item-action py-2 p-3 ripple" id="products_page"
                           data-bs-toggle="collapse">
                            <i class="fa-solid fa-bowl-food"></i>
                            Products
                        </a>
                        <!-- Collapsed content -->
                        <ul
                            id="collapseProducts"
                            class="collapse list-group list-group-flush"
                            >
                            <li class="list-group-item py-1">
                                <a href="/Chatter/admin/products" class="text-reset text-decoration-none">Products</a>
                            </li>
                            <li class="list-group-item py-1">
                                <a href="/Chatter/admin/add_product" class="text-reset text-decoration-none">Add Product</a>
                            </li>
                            <li class="list-group-item py-1">
                                <a href="/Chatter/admin/edit_product" class="text-reset text-decoration-none">Edit Product</a>
                            </li>
                            <li class="list-group-item py-1">
                                <a href="" class="text-reset text-decoration-none">...</a>
                            </li>
                        </ul>
                        <!-- Collapse 2 -->
                    </li>
                    <li>
                        <a href="list_category" class="nav-link link-dark" id="categories_page">
                            <i class="fa-solid fa-qrcode"></i>
                            Categories
                        </a>
                    </li>
                    <li>
                        <a href="#collapseUsers" class="nav-link link-dark list-group-item list-group-item-action py-2 p-3 ripple" id="users_page"
                           data-bs-toggle="collapse" data-bs-target="#collapseUsers">
                            <i class="fa-solid fa-person-chalkboard"></i>
                            Users
                        </a>
                        <!-- Collapsed content -->
                        <ul
                            id="collapseUsers"
                            class="collapse list-group list-group-flush"
                            >
                            <li class="list-group-item py-1">
                                <a href="/Chatter/admin/users" class="text-reset text-decoration-none">Users</a>
                            </li>
                            <li class="list-group-item py-1">
                                <a href="/Chatter/admin/add_user" class="text-reset text-decoration-none">Add User</a>
                            </li>
                            <li class="list-group-item py-1">
                                <a href="/Chatter/admin/edit_user" class="text-reset text-decoration-none">Edit User</a>
                            </li>
                            <li class="list-group-item py-1">
                                <a href="/Chatter/admin/user?user_id=0" class="text-reset text-decoration-none">View a user details</a>
                            </li>
                        </ul>
                        <!-- Collapse 2 -->
                    </li>
                </ul>
            </div>
            <hr>
            <div class="dropdown">
                <a href="#" class="d-flex align-items-center link-dark text-decoration-none dropdown-toggle" id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="../${sessionScope.user.avatar}" alt="Avatar" width="32" height="32" class="rounded-circle me-2">
                    <strong>${sessionScope.user_account.username}</strong>
                </a>
                <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser2">
                    <li><a class="dropdown-item" href="#">New project...</a></li>
                    <li><a class="dropdown-item" href="#">Settings</a></li>
                    <li><a class="dropdown-item" href="/Chatter/profile">Profile</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="/Chatter/logout">Sign out</a></li>
                </ul>
            </div>
        </div>

    </body>
</html>
