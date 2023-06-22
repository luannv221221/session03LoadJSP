<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
        	
        
            <div class="col-lg-8">
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
                            <th>Price</th>
                            <th>Image</th>
                            <th>Category Name</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="p" varStatus="loop">
                    	 <tr>
                            <td scope="row">${loop.count}</td>
                            <td>${p.productName}</td>
                            <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${p.price}" /></td>
                            <td>${p.category.categoryName}</td>
                            <td>
                            	<img alt="" src="<c:url value="uploads"/>/images/${p.image}" width="100px" />
                            </td>
                            <td>
                            	<a href="editProduct/${p.productId}" class="btn btn-primary">Edit</a>
                             	<a href="deleteProduct/${p.productId}" class="btn btn-danger">Delete</a>
                             
                             </td>
                        </tr>
                       
                    </c:forEach>
                       
                    </tbody>
                </table>
                <a href="addProduct" class="btn btn-success">Thêm mới</a>
            </div>
        </div>
    </div>

</body>
</html>