<%-- 
    Document   : ListProduct
    Created on : Jun 15, 2022, 11:09:38 AM
    Author     : Tuan Phong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> <!-- Basic -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas -->
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="shortcut icon" href="images/favicon.png" type="">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>

        <!--owl slider stylesheet -->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <!-- nice select  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
        <!-- font awesome style -->
        <link href="https://cdn.staticaly.com/gh/hung1001/font-awesome-pro-v6/18657a9/css/all.min.css" rel="stylesheet" type="text/css" />
        <script src="https://kit.fontawesome.com/a141f28961.js" crossorigin="anonymous"></script>
        <style>

            img:hover {
                box-shadow: 0 0 4px 2px rgba(0, 140, 186, 0.5);
            }
        </style>

        <!-- Custom styles for this template -->
        <!--<link href="../css/style.css" rel="stylesheet" />-->
        <!-- responsive style -->
        <link href="../css/responsive.css" rel="stylesheet" />
        <link href="/Chatter/css/adminstyle.css" rel="stylesheet" />
        <title>JSP Page</title>

        <script>
            function deleteUser(uid)
            {
                var result = confirm("Are you sure?");
                if (result)
                {
                    window.location.href = "/Chatter/admin/delete_user?userid=" + pid;
                }
            }
            var usernames = [];

            <c:forEach items="${requestScope.users}" var="user">
            usernames.push('${user.account.username}');
            </c:forEach>
        </script>
    </head>
    <body class="row">

        <div class="offcanvas bg-light offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
            <div class="offcanvas-header">
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
                <jsp:include page="Sidebar.jsp" />
            </div>
        </div>
        <div class="col gy-2">

            <div class="row">
                <div class="col-2">
                    <button class="btn btn-outline-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
                        Menu</button>
                </div>
                <div class="col-sm-3">
                    <button class="btn btn-outline-success"  data-bs-toggle="modal" data-bs-target="#addModal">
                        <i class="fa-solid fa-people-robbery"></i>
                        Add User</button>

                    <!--Add Modal-->
                    <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="addUserModal" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header text-bg-success">
                                    <h5 class="modal-title" id="addProductModalLabel">
                                        <i class="fa-solid fa-people-robbery"></i>
                                        Add new User</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body form_container d-flex g-lg-6">

                                    <form action="users" method="POST" class="row g-3 form-control" id="addFormModal">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label for="inputUsername" class="col-sm-2 col-form-label">Username</label>
                                                <input id="usernameAddModal"  name="username"  type="text" class="form-control" placeholder="Enter username" onkeyup="checkUsername()" required form="addFormModal">
                                                <span id="dumlicate_username"></span>
                                            </div> 
                                            <div class="col-md-6">
                                                <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
                                                <input id="inputPassword" name="password" type="password" class="form-control" placeholder="Enter password" required>
                                            </div>
                                            <div class="col-md-6">
                                                <label for="inputFirstname" class=" col-form-label">First name</label>
                                                <input id="inputFirstname" name="firstname" type="text" class="form-control" placeholder="User's first name">
                                            </div>
                                            <div class="col-md-6">
                                                <label for="inputLastname" class="col-form-label">Last name</label>
                                                <input id="inputLastname" name="lastname" type="text" class="form-control" placeholder="User's last name">
                                            </div>

                                            <div class="col-md-6">
                                                <label for="inputPhonenumber" class="col-form-label">Phone number</label>
                                                <input id="inputPhonenumber" name="phonenumber" type="tel" required class="form-control" placeholder="0906111111" pattern="^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$" title="Please input a phone number in Vietnam (10 digits)">
                                            </div>

                                            <div class="col-md-6">
                                            </div>
                                            <div class="col-md-6">
                                                <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
                                                <input id="inputEmail" name="email" type="email" pattern="^[a-zA-Z0-9.! #$%&'*+=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)+$" class="form-control" placeholder="mee@example.com" required >

                                            </div>
                                            <div class="col-md-6">
                                            </div>

                                            <div class="btn-group col-md-4 p-3 form-check" role="group" aria-label="" id="role">
                                                <label class="form-check-label col-form-label col-lg-2" for="form-check">
                                                    Role
                                                </label>

                                                <input type="radio" class="btn-check" name="role" value="user" id="btnradio1" checked>
                                                <label class="btn btn-outline-primary" for="btnradio1">User</label>

                                                <input type="radio" class="btn-check" name="role" value="seller" id="btnradio2">
                                                <label class="btn btn-outline-primary" for="btnradio2">Seller</label>

                                                <input type="radio" class="btn-check" name="role" value="admin" id="btnradio3">
                                                <label class="btn btn-outline-primary" for="btnradio3">Admin</label>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-outline-success" type="submit" id="add-user"  form="addFormModal"  name="action" value="add_user">
                                        <i class="fa-duotone fa-user-plus"></i>
                                        Add User
                                    </button>
                                    <button type="reset" class="btn btn-outline-danger" data-bs-dismiss="modal" form="addFormModal">
                                        <i class="fa-duotone fa-square-x"></i>
                                        Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <form class="col input-group justify-content-end" action="/Chatter/admin/products" method="get" id="searchForm">
                    <div class="form-floating">
                        <select onchange="selectForm();" class="form-select" name="searchtype" id="floatingSelectGrid" >
                            <option ${requestScope.searchtype eq '0' || requestScope.searchtype == null ? "selected" :"" } value="0">User ID</option>
                            <option ${requestScope.searchtype eq '1'? "selected" :""} value="1">Username</option>
                            <option ${requestScope.searchtype eq '2'? "selected" :""} value="2">First name, Last name</option>
                            <option ${requestScope.searchtype eq '3'? "selected" :""} value="3">Phone, Email</option>
                        </select>


                        <label for="floatingSelectGrid">Search by</label>
                    </div>
                    <div class="form-floating"  id="searchByID" >
                        <input  type="number" class="form-control" name="productid" value="${requestScope.productid}" placeholder="ProductID" aria-label="ProductID" min="0" max="65536"  aria-describedby="button-addon2">
                        <label for="">User ID</label>
                    </div>
                    <div class="form-floating col-sm-3"  id="searchByName" >
                        <input  type="search" class="form-control" name="productname"  value="${requestScope.productname}" placeholder="ProductID" aria-label="ProductID" aria-describedby="button-addon2" >
                        <label for="">User Name</label>
                    </div>
                    <div class="form-floating col-sm-2"  id="searchByMinPrice" >
                        <input  type="number" step="0.01" class="form-control" name="minprice" value="${requestScope.minprice}" placeholder="ProductPrice" aria-label="ProductPrice" min="0" max="65536" aria-describedby="button-addon2">
                        <label for="">First Name</label>
                    </div>
                    <div class="form-floating col-sm-2"  id="searchByMaxPrice" >
                        <input  type="number" step="0.01" class="form-control" name="maxprice" value="${requestScope.maxprice}" placeholder="ProductPrice" aria-label="ProductPrice" min="0" max="65536" aria-describedby="button-addon2">
                        <label for="">Last Name</label>
                    </div>
                    <div class="form-floating col-sm-2"  id="searchByStartDate" >
                        <input  type="tel" value="${requestScope.startdate!=null?requestScope.startdate:""}" class="form-control" name="startdate" placeholder="ProductID" 
                                aria-label="ProductID" aria-describedby="button-addon2">
                        <label for="">Phone</label>
                    </div>
                    <div class="form-floating col-sm-2"  id="searchByEndDate" >
                        <input  type="email" value="${requestScope.enddate!=null?requestScope.enddate:""}"  class="form-control" name="enddate" placeholder="ProductID"
                                aria-label="ProductID"  aria-describedby="button-addon2">
                        <label for="">Email</label>
                    </div>
                    <button class="btn btn-outline-primary fa-2x fa-duotone fa-magnifying-glass-plus" type="submit" id="button-addon2">
                    </button>
                </form>
            </div>

            <c:set value="${requestScope.users}" var="users"/>

            <div class="bg bg-light rounded-3">
                <div class="text-center display-6 text-info">
                    <i class="fa-duotone fa-rectangle-list"></i>
                    List Users</div>
                <table onload="selectForm();" class="table table-hover table-striped table-responsive-md card-body text-center">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th class="text-lg-start">User name</th>
                            <th class=" ">First name</th>
                            <th>Last name</th>
                            <th class=" text-center">Gender</th>
                            <th class=" text-center">Role</th>
                            <th class="">Phone number</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th class=" text-center">Action</th>
                        </tr>
                    </thead>
                    <tbody >
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>${user.users_id}</td>
                                <td class="a text-lg-start"><img class="avatar img-thumbnail" src="/Chatter/${user.avatar}" alt="product ${product.name} image"/>
                                    <a href="/Chatter/admin/user?user_id=${user.users_id}" class="text-decoration-none text-primary" >${user.account.username}</a></td>
                                </td>
                                <td>${user.firstname}</td>
                                <td>${user.lastname}</td>
                                <td>${user.gender}</td>
                                <td>${user.role}</td>
                                <td>${user.phonenumber}</td>
                                <td>${user.email}</td>
                                <td class="text-center col-3">${user.home_address}${", "}${user.district}${", "}${user.city}</td>

                                <td class="text-lg-center">

                                    <!-- Edit Modal -->
                                    <div class="modal modal-xl fade" id="editModal${user.users_id}" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header text-bg-warning">
                                                    <h5 class="modal-title" id="editModalLabel">
                                                        <i class="fa-solid fa-person-circle-question"></i>
                                                        Edit User</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="blockquote">
                                                        <div class="display-6">
                                                            <img src="/Chatter/${user.avatar}" class="avatar" alt="avatar">  ${user.account.username}
                                                            <em class="display-6 blockquote-footer">(User ID: ${user.users_id})</em></div></div>

                                                    <div class="form_container g-lg-6">
                                                        <form class=" form-control" id="editFormModal${user.users_id}" action="edit_user" method="POST"  enctype="multipart/form-data">
                                                            <div class="container-content border border-light rounded row" id="UserDetails">
                                                                <div class="col-6 row g-2">
                                                                    <div class="col-11">
                                                                        <div class="card border-info ">
                                                                            <div class=" card-header">
                                                                                <i class="fa-duotone fa-ballot"></i>
                                                                                General Info</div>

                                                                            <div class="card-body row row-cols-7 row-cols-lg-2 g-2 g-lg-3">
                                                                                <div class="col">
                                                                                    <i class="fa-duotone fa-square-1"></i>
                                                                                    First name
                                                                                </div>
                                                                                <div class="col">
                                                                                    <input type="text" class="form-control" autofocus pattern="([A-Z][a-z]+)( [A-Z][a-z]+)*$" value="${user.firstname}" name="firstname"/>
                                                                                </div>

                                                                                <div class="col">
                                                                                    <i class="fa-duotone fa-circle-0"></i>
                                                                                    Last name
                                                                                </div>
                                                                                <div class="col">
                                                                                    <input type="text" class="form-control" pattern="([A-Z][a-z]+)( [A-Z][a-z]+)*$"  value="${user.lastname}" name="lastname"/>
                                                                                </div>

                                                                                <div class="col">
                                                                                    <i class="fa-duotone fa-venus-mars"></i>
                                                                                    Gender<br>
                                                                                </div>
                                                                                <div class="col">
                                                                                    <div class="form-check form-check-inline">
                                                                                        <input class="form-check-input" type="radio" name="gender" id="genderMale${user.users_id}"
                                                                                               ${user.gender eq 'male'?'checked':''} value="male">
                                                                                        <label class="form-check-label" for="genderMale${user.users_id}">Male</label>
                                                                                    </div>
                                                                                    <div class="form-check form-check-inline">
                                                                                        <input class="form-check-input" ${user.gender eq 'female'?'checked':''} type="radio" name="gender" id="genderFemale${user.users_id}" value="female">
                                                                                        <label class="form-check-label" for="genderFemale${user.users_id}">Female</label>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="row g-0 justify-content-between">
                                                                                    <div class="col-6 col-md-8 g-3">
                                                                                        <i class="fa-solid fa-person-military-pointing"></i>
                                                                                        Role
                                                                                    </div>
                                                                                    <div class="col-6 col-md-1 p-1 ">
                                                                                        <div class="btn-group col-md-0 form-check" role="group" aria-label="" id="role${user.users_id}">

                                                                                            <input type="radio" class="btn-check" ${user.role eq 'user'?'checked':''} name="role${user.users_id}" value="user" id="btnradio1${user.users_id}">
                                                                                            <label class="btn btn-outline-primary" for="btnradio1${user.users_id}">User</label>

                                                                                            <input type="radio" class="btn-check" ${user.role eq 'seller'?'checked':''} name="role${user.users_id}" value="seller" id="btnradio2${user.users_id}">
                                                                                            <label class="btn btn-outline-primary" for="btnradio2${user.users_id}">Seller</label>

                                                                                            <input type="radio" class="btn-check" ${user.role eq 'admin'?'checked':''} name="role${user.users_id}" value="admin" id="btnradio3${user.users_id}">
                                                                                            <label class="btn btn-outline-primary" for="btnradio3${user.users_id}">Admin</label>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="col"></div>

                                                                                <div class="col">
                                                                                    <i class="fa-solid fa-mobile-retro"></i>
                                                                                    Phone number
                                                                                </div>
                                                                                <div class="col">
                                                                                    <input id="inputPhonenumber" name="phonenumber" type="tel" value="${user.phonenumber}"  required class="form-control"
                                                                                           placeholder="0906111111" pattern="^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$" title="Please input a phone number in Vietnam (10 digits)" value=${phone} >
                                                                                </div>

                                                                                <div class="col">
                                                                                    <i class="fa-duotone fa-envelopes"></i>                                   
                                                                                    Email
                                                                                </div>
                                                                                <div class="col">
                                                                                    <input id="inputEmail" name="email" pattern="^[a-zA-Z0-9.! #$%&'*+=? ^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)+$" type="email" value="${user.email}" class="form-control" placeholder="mee@example.com" required value=${email}>
                                                                                </div>

                                                                                <div class="col">
                                                                                    <i class="fa-duotone fa-camera-retro"></i>
                                                                                    Avatar
                                                                                </div>
                                                                                <div class="col">
                                                                                    <input accept="image/*" class="form-control" type="file" id="formFile${user.users_id}" name="image">
                                                                                    <p class=" text-dark"><em>Preview avatar</em><img id="img-preview${user.users_id}" alt="preview avatar" class="avatar rounded-circle me-2 justify-content-lg-end" src="/Chatter/${user.avatar}"/>
                                                                                    </p>

                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>


                                                                <!--Address-->

                                                                <div class="col-6 row g-2">
                                                                    <div class="col-12">
                                                                        <div class="card border-info ">
                                                                            <div class=" card-header">
                                                                                <i class="fa-duotone fa-address-book"></i>
                                                                                Address</div>

                                                                            <div class="card-body row row-cols-6 row-cols-lg-2 g-2 g-lg-3">
                                                                                <div class="col">
                                                                                    <i class="fa-duotone fa-house-tree"></i>
                                                                                    Home address
                                                                                </div>
                                                                                <div class="col">
                                                                                    <input type="text" class="form-control"  value="${user.home_address}" name="homeAddress"/>
                                                                                </div>

                                                                                <div class="col">
                                                                                    <i class="fa-duotone fa-house-building"></i>
                                                                                    District
                                                                                </div>
                                                                                <div class="col">
                                                                                    <input type="text" class="form-control"  value="${user.district}" name="district"/>
                                                                                </div>

                                                                                <div class="col">
                                                                                    <i class="fa-duotone fa-city"></i>
                                                                                    City
                                                                                </div>
                                                                                <div class="col">
                                                                                    <input type="text" class="form-control"  value="${user.city}" name="city"/>
                                                                                </div>

                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <input type="hidden" name="userid" value="${user.users_id}"/>
                                                            <input type="hidden" name="username" value="${user.account.username}"/>

                                                        </form>
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-outline-warning" form="editFormModal${user.users_id}">
                                                        <i class="fa-duotone fa-floppy-disk-pen "></i>
                                                        Save changes</button>
                                                    <button type="reset" class="btn btn-outline-danger" form="editFormModal${user.users_id}" data-bs-dismiss="modal">
                                                        <i class="fa-duotone fa-circle-xmark"></i>
                                                        Close</button>
                                                </div>

                                            </div>
                                        </div>
                                    </div>



                                    <button type="button" class="btn btn-outline-warning btn-box"  data-bs-toggle="modal" data-bs-target="#editModal${user.users_id}">
                                        <i class="fa-duotone fa-file-lines"></i>
                                        Edit
                                    </button>

                                    <button type="reset" class="btn btn-outline-danger btn-box" onclick="deleteProduct(${product.id});">
                                        <i class="fa-duotone fa-eraser"></i>
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>



            <!--pagination-->

            <nav aria-label="pages" class="d-flex justify-content-center">
                <ul class="pagination">
                    <li class="page-item">
                        <button type="submit" name="page" form="searchForm" class="page-link btn"  ${requestScope.currentpage le 2? "hidden":""} value="1">First page</button>
                    </li>
                    <li class="page-item ${requestScope.currentpage eq 1? "disabled":""}">
                        <button class="page-link" type="submit" name="page" form="searchForm"  value="${requestScope.currentpage-1}"  ><<</button>
                    </li>
                    <li class="page-item">
                        <button class="page-link" name="page" form="searchForm" type="submit" value="${requestScope.currentpage-1}" ${requestScope.currentpage eq 1? "hidden":""}>${requestScope.currentpage-1}
                        </button>
                    </li>
                    <li class="page-item active" aria-current="page">
                        <a class="page-link">${requestScope.currentpage}</a>
                    </li>
                    <li class="page-item">
                        <button class="page-link btn" form="searchForm" name="page" ${requestScope.currentpage+1 gt requestScope.totalpage? "hidden":""} value="${requestScope.currentpage + 1}" >
                            ${requestScope.currentpage + 1}</button>
                    </li>
                    <li class="page-item">
                        <a class="page-link disabled "  ${requestScope.currentpage+3 gt requestScope.totalpage? "hidden":""}>...</a></li>

                    <li class="page-item">
                        <button class="page-link"  type="submit" name="page" form="searchForm"  value="${requestScope.totalpage}" ${requestScope.currentpage + 2 gt requestScope.totalpage? "hidden":""} >${requestScope.totalpage}</button>
                    </li>
                    <li class="page-item ${requestScope.currentpage eq requestScope.totalpage? "disabled":""}">
                        <button class="page-link" type="submit" name="page" form="searchForm"  value="${requestScope.currentpage+1}" >>></button>
                    </li>
                </ul>
            </nav>
        </div>
        <script>
            document.getElementById('products_page').classList.add('active');
            document.getElementById('products_page').classList.remove('link-dark');


            selectForm();


            function selectForm() {
                var type = document.getElementById("floatingSelectGrid").value;

                document.getElementById("searchByID").style.display = type == 0 ? "inline" : "none";
                document.getElementById("searchByName").style.display = type == 1 ? "inline" : "none";
                document.getElementById("searchByMinPrice").style.display = type == 2 ? "inline" : "none";
                document.getElementById("searchByMaxPrice").style.display = type == 2 ? "inline" : "none";
                document.getElementById("searchByStartDate").style.display = type == 3 ? "inline" : "none";
                document.getElementById("searchByEndDate").style.display = type == 3 ? "inline" : "none";
                document.getElementById("searchForm").reset();
                document.getElementById("floatingSelectGrid").value = type;

            }

            function checkUsername() {
                let username = document.getElementById('usernameAddModal').value;
                const isDumlicate = usernames.some(element => {
                    return element === username;
                });

                if (isDumlicate) {
                    document.getElementById('dumlicate_username').style.color = 'red';
                    document.getElementById('dumlicate_username').innerHTML =
                            'Username already exist!';
                    document.getElementById('add-user').disabled = true;
                    document.getElementById('add-user').style.opacity = (0.4);
                } else if (username === '') {
                    document.getElementById('dumlicate_username').style.color = 'red';
                    document.getElementById('dumlicate_username').innerHTML =
                            'Please enter a username!';
                    document.getElementById('add-user').disabled = true;
                    document.getElementById('add-user').style.opacity = (0.4);
                } else
                {
                    document.getElementById('dumlicate_username').style.color = 'green';
                    document.getElementById('dumlicate_username').innerHTML =
                            'Valid Username ';
                    document.getElementById('add-user').disabled = false;
                    document.getElementById('add-user').style.opacity = (1);
                }
            }

            const input = document.getElementById('formFile${user.users_id}');
            const image = document.getElementById('img-preview${user.users_id}');

            input.addEventListener('change', (e) => {
                if (e.target.files.length) {
                    const src = URL.createObjectURL(e.target.files[0]);
                    image.src = src;
                }
            });
            function previewImage(userid) {
                var output = document.getElementById('img-preview' + userid);
                output.src = URL.createObjectURL(event.target.files[0]);
                output.onload = function () {
                    URL.revokeObjectURL(output.src) // free memory
                }
            }




        </script>  
    </body>
</html>
