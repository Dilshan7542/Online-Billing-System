<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/assets/lib/boostrap/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/assets/style/util.css">
 <title>Online Billing System</title>
</head>
<body class="">
<div class="container">
 <div class="row justify-content-center align-items-center mt-5">
  <div class="col-md-6 col-lg-4">
   <div class="card shadow-sm">
    <div class="card-body">
     <h2 class="card-title text-center mb-4">Login</h2>
     <!-- Login Form -->
     <form action="${pageContext.request.contextPath}/dashboard" method="get">
      <div class="mb-3">
       <label for="username" class="form-label">Username</label>
       <input type="text" class="form-control" id="username" name="username" placeholder="Enter username" required>
      </div>
      <div class="mb-3">
       <label for="password" class="form-label">Password</label>
       <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
      </div>
      <div class="d-grid">
       <button type="submit" class="btn btn-primary">Login</button>
      </div>
     </form>
     <!-- Link to Home -->
     <div class="text-center mt-3">
      <a href="${pageContext.request.contextPath}/index.jsp" class="text-decoration-none">Back to Home</a>
     </div>
    </div>
   </div>
  </div>
 </div>
</div>

<script src="${pageContext.servletContext.contextPath}/assets/lib/boostrap/js/bootstrap.js" ></script>


</body>
</html>