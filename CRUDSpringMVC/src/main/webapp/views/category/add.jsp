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
                <form:form action="insertCategory" method="POST" modelAttribute="category">
					  <div class="form-group">
					    <label for="exampleInputEmail1">Category Name</label>
					    <form:input type="text" path="categoryName" class="form-control"/>
					    
					  </div>
					  <div class="form-group">
					  <label for="exampleInputEmail1">Category Status</label>
					    <div>
					    <div class="form-check form-check-inline">
						  <form:radiobutton  class="form-check-input" path="categoryStatus" checked="checked"   value="1" />
						  <label class="form-check-label" for="inlineRadio1">Active</label>
						</div>
						
						<div class="form-check form-check-inline">
						  <form:radiobutton  class="form-check-input"  path="categoryStatus"  value="0" />
						  <label class="form-check-label" for="inlineRadio2">Hidden</label>
						</div>
					    
					    </div>
					    
					  </div>
					 
					  <button type="submit" class="btn btn-primary">Add</button>
				</form:form>
            </div>
        </div>
    </div>

</body>
</html>