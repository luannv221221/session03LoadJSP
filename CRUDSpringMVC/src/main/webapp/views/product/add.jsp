<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <form:form action="insertProduct" method="POST" modelAttribute="product" enctype="multipart/form-data">
					  <div class="form-group">
					    <label for="exampleInputEmail1">Product Name</label>
					    <form:input type="text" path="ProductName" class="form-control"/>
					    
					  </div>
					  <div class="form-group">
					    <label for="exampleInputEmail1">price</label>
					    <form:input type="text" path="price" class="form-control"/>
					    
					  </div>
					  <div class="form-group">
					    <label for="exampleInputEmail1">Image</label>
					    <input type="file" name="image" class="form-control"/>
					    
					  </div>
					 <div class="form-group">
					    <label for="exampleInputEmail1">Category</label>
					    <form:select path="category.categoryId" class="form-control">
					    	<form:options items="${listCategory}" itemLabel="categoryName" itemValue="categoryId"/>
					    </form:select>
					    
					  </div>
					  <div class="form-group">
					    <label for="exampleInputEmail1">Description</label>
					    
					    <form:textarea path="description" class="form-control"/>
					  </div>
					  <button type="submit" class="btn-block btn-primary">Add</button>
				</form:form>
            </div>
        </div>
    </div>

</body>
</html>