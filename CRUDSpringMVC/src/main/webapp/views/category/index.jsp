<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
  </head>
  <body>
    
    <div class="container">
        <div class="row justify-content-center">
        	
        
            <div class="col-lg-6">
            <c:if test="${!empty success}">
		        <div class="alert alert-primary" role="alert">
					<strong>${success}</strong>
				</div>
        	</c:if>
                <table class="table">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Name</th>
                            <th>Status</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="c" varStatus="loop">
                    	 <tr>
                            <td scope="row">${loop.count}</td>
                            <td>${c.categoryName}</td>
                            <td>${c.categoryStatus ? 'Active' :'Hiden'}</td>
                            <td>
                             <a href="deleteCategory/${c.categoryId}" class="btn btn-danger">Delete</a>
                             <a href="editCategory/${c.categoryId}" class="btn btn-primary">Edit</a>
                             </td>
                        </tr>
                       
                    </c:forEach>
                       
                    </tbody>
                </table>
                <a href="addCategory" class="btn btn-success">Thêm mới</a>
            </div>
        </div>
    </div>

</body>
</html>