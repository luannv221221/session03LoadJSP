<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container">
<div class="col-lg-6">
<f:form action="insertAccount" method="POST" modelAttribute="acc" enctype="multipart/form-data">
 <div class="form-group">
    <label for="exampleInputEmail1">FullName</label>
    <f:input type="text" class="form-control" path="fullName"/>
    <f:errors cssClass="text-danger" path="fullName">
    	
    </f:errors>
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <f:input type="text" class="form-control" path="email"/>
    <f:errors cssClass="text-danger" path="email">
    	
    </f:errors>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <f:input type="password" class="form-control" path="password" />
    <f:errors cssClass="text-danger" path="password">
    	
    </f:errors>
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Phone</label>
    <f:input type="text" class="form-control" path="phone"/>
     <f:errors cssClass="text-danger" path="phone">
    	
    </f:errors>
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Birthday</label>
    <f:input type="date" class="form-control" path="birthday"/>
    <f:errors cssClass="text-danger" path="birthday">
    	
    </f:errors>
  </div>
  <input type="file" name="imageName"/>
  <button type="submit" class="btn btn-primary">Submit</button>
</f:form>
</div>
</div>
	
</body>
</html>