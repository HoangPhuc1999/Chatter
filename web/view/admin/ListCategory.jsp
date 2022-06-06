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
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <!--owl slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
  <!-- nice select  -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
  <!-- font awesome style -->
  <link href="../css/font-awesome.min.css" rel="stylesheet" />

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
    background: #FFF !important;
}
</style>
  <script>
            var cids = [];
            <c:forEach items="${requestScope.categorys}" var="c">
            cids.push(${c.cid});
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
            
            function cancelEdit(cid,cname)
            {
                hideEditmode(cid);
                showViewmode(cid);
                document.getElementById("edit_name"+cid).value = cname;
            }
            
            function deleteCategory(cid)
            {
                var result = confirm("Are you sure?");
                if(result)
                {
                    window.location.href = "delete?cid=" + cid;
                }
            }
            /* 404
            function addCategory(cid){
            var tableX = document.getElementById("tableX");
            var row = tableX.insertRow(${requestScope.categorys.size()+1});
            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);
            var cell3 = row.insertCell(2);
            
            cell1.innerHTML="<input type=\"hidden\" value=\"${cid+1}\"/>"
            ;
            cell2.innerHTML="<input name=\"name\" type=\"text\"  />";
            cell3.innerHTML="";
            }   
            */
            
        </script>
    </head>
    <body>
        <div class="hero_area">
        <div class="bg-box">
        </div>
        <!-- header section strats -->
        <jsp:include page="../../Header.jsp" />
        <!-- end header section -->
      </div>
        <div class="main_content">
        <h2 style="text-align: center;">Modify Categories</h2>
        <div class="d-flex justify-content-center">
        <table class="table table-striped w-50" id="tableX">
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
                        <input name="cname" class="editmode${category.cid}" type="text" id="edit_name${category.cid}" value="${category.cname}" />
                    </td>
                    <td>
                        <input type="hidden" name="cid" value="${category.cid}"/>
                        <input class="btn btn-outline-info btn-sm viewmode${category.cid}" type="button" onclick="showEditmode(${category.cid});hideViewmode(${category.cid});" value="Edit"/>
                        <a class="btn btn-outline-danger btn-sm viewmode${category.cid}"  href="#" onclick="deleteCategory(${category.cid})">Delete</a>
                        <input class="btn btn-outline-success btn-sm editmode${category.cid}" type="submit"  value="Save"/>
                        <input class="btn btn-outline-warning btn-sm editmode${category.cid}" type="button" onclick="cancelEdit(${category.cid},'${category.cname}');" value="Cancel"/>
                    </td>
                </tr>
                </form>
            </c:forEach>
                
                <form action="insert_category" method="post">   
                <tr>
                    <td></td>
                    <td></td>
                    <td><button class="btn btn-outline-success btn-sm"  onclick="addCategory(${category.cid+1})">Add</button></td>
                </tr>
                </form>
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
        </script>
    </body>
</html>
