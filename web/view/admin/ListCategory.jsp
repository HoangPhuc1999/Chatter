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
        <title>List Category</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <!--owl slider stylesheet -->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
        <!-- nice select  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
        <!-- font awesome style -->
        <script src="https://kit.fontawesome.com/a141f28961.js" crossorigin="anonymous"></script>


        <!-- Custom styles for this template -->
        <link href="../css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="../css/responsive.css" rel="stylesheet" />
        <style>
            body {
                background-color: #121819;
                background-attachment: fixed;
                background-size: auto;
            }
            .main_content {
                background: #e2feff !important;
            }
            .fa-lg {
                font-size: 1.25em;
                line-height: 1em !important;
                vertical-align: -.075em;
            }
            .bdr {
                border-radius: 10px;
                overflow: hidden;
            }
        </style>
        <script>
            var cids = [];
            <c:forEach items="${requestScope.categorys}" var="c">
            cids.push(${c.cid});
            </c:forEach>

            var cates = [];
            <c:forEach items="${requestScope.categorys}" var="cate">
            cates.push('${cate.cname}');
            </c:forEach>

            function hideEditmode(cid)
            {
                var editcomponents = document.getElementsByClassName("editmode" + cid);
                for (var i = 0; i < editcomponents.length; i++)
                {
                    var component = editcomponents[i];
                    component.style.display = "none";
                }
            }
            function showEditmode(cid)
            {
                var editcomponents = document.getElementsByClassName("editmode" + cid);
                for (var i = 0; i < editcomponents.length; i++)
                {
                    var component = editcomponents[i];
                    component.style.display = "inline";
                }
            }
            function hideViewmode(cid)
            {
                var editcomponents = document.getElementsByClassName("viewmode" + cid);
                for (var i = 0; i < editcomponents.length; i++)
                {
                    var component = editcomponents[i];
                    component.style.display = "none";
                }
            }
            function showViewmode(cid)
            {
                var editcomponents = document.getElementsByClassName("viewmode" + cid);
                for (var i = 0; i < editcomponents.length; i++)
                {
                    var component = editcomponents[i];
                    component.style.display = "inline";
                }
            }

            function cancelEdit(cid, cname)
            {
                hideEditmode(cid);
                showViewmode(cid);
                document.getElementById("edit_name" + cid).value = cname;
            }

            function deleteCategory(cid)
            {
                var result = confirm("Are you sure?");
                if (result)
                {
                    window.location.href = "delete_category?category_id=" + cid;
                }
            }
        </script>
    </head>
    <body>

        <div class="main_content row">
            <!-- Button trigger modal -->
            <div class="col-sm-3">
                <jsp:include page="Sidebar.jsp" />

            </div>   
            <div class="col-sm-9">
                <h3 class="text-warning p-2 fa-solid fa-qrcode">  Categories</h3>
                <div class="d-flex p-3 col-sm-12">
                    <button type="button" class="btn btn-box btn-outline-success" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        <i class="fa fa-plus-circle fa-lg" aria-hidden="true"></i> Add category
                    </button>

                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">New category</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <form action="insert_category" method="post">
                                        <div class="mb-3">
                                            <label for="name" class="col-form-label">Category name:</label>
                                            <input type="text" class="form-control" id="category_name" name="category_name"  required="true" onkeyup="validate_category()">
                                        </div> 
                                        <span id="dumlicate_category"></span>

                                </div>
                                <div class="modal-footer">
                                    <button id="add_category" type="submit" class="btn btn-success">Add</button>
                                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                        <table class="bdr table table-striped table-bordered table-hover table-warning">
                            <tr class>
                                <th class="w-auto">Category ID</th>
                                <th class="w-auto">Category Name</th>
                                <th class="w-auto"></th>

                            </tr>
                            <c:forEach items="${requestScope.categorys}" var="category">
                                <form action="update_category" method="post">   
                                    <tr>
                                        <td>${category.cid}</td>
                                        <td>
                                            <span class="viewmode${category.cid}" id="view_name${category.cid}">${category.cname}</span>
                                            <input name="cname" class="form-control editmode${category.cid}" type="text" id="edit_name${category.cid}" value="${category.cname}" />
                                        </td>
                                        <td>
                                            <input type="hidden" name="cid" value="${category.cid}"/>
                                            <a class="btn-outline-info btn-box btn-lg fa fa-pencil-square-o fa-lg viewmode${category.cid}" onclick="showEditmode(${category.cid});
                                                    hideViewmode(${category.cid});"/>
                                            <a class="btn-outline-danger btn-box btn-lg fa fa-trash fa-lg viewmode${category.cid}"  href="#" onclick="deleteCategory(${category.cid})"></a>
                                            <input class="btn btn-outline-success btn-sm editmode${category.cid}" type="submit"  value="Save">
                                            <input class="btn btn-outline-secondary btn-sm editmode${category.cid}" type="button" onclick="cancelEdit(${category.cid}, '${category.cname}');" value="Cancel"/>
                                        </td>
                                    </tr>
                                </form>
                            </c:forEach>
                        </table>
                </div>
            </div>

            <!-- footer section -->
            <jsp:include page="../../Footer.jsp" />
            <!-- footer section -->
            <script>

                for (var i = 0; i < cids.length; i++)
                {
                    hideEditmode(cids[i]);
                }



                function validate_category() {
                    let category = document.getElementById('category_name').value;
                    const includesValue = cates.some(element => {
                        return element.toLowerCase() === category.toLowerCase();
                    });
                    if (includesValue) {
                        document.getElementById('dumlicate_category').style.color = 'red';
                        document.getElementById('dumlicate_category').innerHTML
                                = 'Category already exist!';
                        document.getElementById('add_category').disabled = true;
                        document.getElementById('add_category').style.opacity = (0.4);
                    } else {
                        document.getElementById('dumlicate_category').style.color = 'green';
                        document.getElementById('dumlicate_category').innerHTML =
                                'Valid category';
                        document.getElementById('add_category').disabled = false;
                        document.getElementById('add_category').style.opacity = (1);
                    }
                }


            </script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>
