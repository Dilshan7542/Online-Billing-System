
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <title>Dashboard</title>
 <link rel="stylesheet" type="text/css"
       href="${pageContext.servletContext.contextPath}/assets/lib/boostrap/css/bootstrap.min.css">
 <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/assets/style/util.css">
 <style>
     .maunuBtn>.active{
         background-color: #0a58ca;
     }
 </style>
</head>
<body>
<main class="">
 <header style="height: 8vh" class="border-bottom w-100">
  <nav class="w-100 d-flex justify-content-end align-items-center h-100">
   <div class="flex-grow-1">
    <h1 class="m-0 text-center" id="headerTitle">Customer Management</h1>
   </div>
   <div class="p-2">
    <a class="btn btn-sm btn-outline-secondary" href="${pageContext.request.contextPath}/">Logout</a>
   </div>
  </nav>
 </header>
 <main class="row" style="min-height: 92vh">
  <section class="col-2 d-flex flex-column mh-100 border-end">
   <section class="w-100 bg-base-1" style="height: 100px"></section>
   <section class="w-100 d-flex flex-column flex-grow-1 justify-content-center gap-1 p-2" id="maunuBtn">
    <button class="btn btn-outline-primary" data-url="/user">User Management</button>
    <button class="btn btn-outline-primary" data-url="/bill">Bill Management</button>
    <button class="btn btn-outline-primary" data-url="/api/v1/auth">Customer Management</button>
   </section>
  </section>
  <section class="col-10" id="content-area">

  </section>
 </main>
</main>
<script src="${pageContext.servletContext.contextPath}/assets/lib/JQuery/jquery-3.6.0.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/assets/lib/boostrap/js/bootstrap.bundle.min.js"></script>
<script>
    $(document).ready(function () {
        $("#maunuBtn>button").click(function () {
            $("#maunuBtn>button").removeClass("active");
            const button = $(this);
            button.addClass("active")
            console.log(button.data("url"));
            $("#content-area").load("/api/v1/auth");
            $("#headerTitle").text(button.text())
        });
    });
</script>
</body>
</html>
