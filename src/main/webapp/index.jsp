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
     <form id="loginForm">
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
      <i class="text-negative-700 d-none" id="invalidCredential">invalid credential</i>
     </form>
    </div>
   </div>
  </div>
 </div>
</div>
<script src="${pageContext.servletContext.contextPath}/assets/lib/JQuery/jquery-3.6.0.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/assets/lib/boostrap/js/bootstrap.js" ></script>
<script>
 $('#loginForm').on('submit', function(e) {
  e.preventDefault(); // Prevent default form submission

  const formData = new FormData(this);
  const jsonData = {};
  formData.forEach((value, key) => {
   jsonData[key] = value;
  });
  const data = JSON.stringify(jsonData);
  console.log(data);

  $.ajax({
   url: '${pageContext.servletContext.contextPath}/api/v1/auth',
   type: 'POST',
   contentType: 'application/json',
   data:data,
   success: function(response) {
    console.log('Login successful:', response);
    window.location.href='${pageContext.servletContext.contextPath}/dashboard';
   },
   error: function(err) {
    console.error('Login failed:', err);
    $('#invalidCredential').removeClass("d-none");
   }
  });
 });

</script>

</body>
</html>