<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 09/10/2022
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../../bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../bootstrap-5.2.2-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap5.min.css"/>
    <link rel="stylesheet" href="../../view/family/family.css"/>
</head>
<body>

<div class="header">
    <h1>FAMILY MANAGEMENT APPLICATION IN VIETNAM</h1>
</div>

<div class="topnav">
    <a href="#">Link</a>
    <a href="#">Link</a>
    <a href="#">Link</a>
    <div style="float: right; margin-top:6px; margin-right: 10px">
        <form style="flex: 1;" action="/tent?action=search" method="post"
              class="d-flex justify-content-end m-0 p-0 align-items-center">
            <input class="form-control w-auto mx-2" type="text" placeholder="Search by Tent Id..." name="tentIdSearch">
            <input class="form-control w-auto mx-2" type="text" placeholder="Search by Tenant's Name..."
                   name="tenantNameSearch">
            <input class="form-control w-auto mx-2" type="text" placeholder="Search by Phone Number..."
                   name="phoneNumberSearch">
            <input class="btn btn-outline-success mx-2" type="submit" style="color: white" value="Search"
                   style="margin-right: 0!important;">
        </form>
    </div>
</div>

<div class="row">
    <div class="leftcolumn" style="margin-top: 10px">
        <table id="tableStudent" class="table table-striped table-bordered" style="width:100%">
            <thead>
            <tr>
                <th>N.O</th>
                <th>Host Name</th>
                <th>Initial Date</th>
                <th>Address</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="x" items="${familyList}" varStatus="count">
                <tr>
                    <td>${count.getCount()}</td>
                    <td>${x.getHostName()}</td>
                    <td>${x.getInitialDate()}</td>
                    <td>${x.getAddress()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="rightcolumn">
        <div class="card">
            <h2>About Me</h2>
            <div class="fakeimg" style="height:100px;">Image</div>
            <p>Some text about me in culpa qui officia deserunt mollit anim..</p>
        </div>
        <div class="card">
            <h3>Popular Post</h3>
            <div class="fakeimg"><p>Image</p></div>
            <div class="fakeimg"><p>Image</p></div>
            <div class="fakeimg"><p>Image</p></div>
        </div>
        <div class="card">
            <h3>Follow Me</h3>
            <p>Some text..</p>
        </div>
    </div>
</div>

<div class="footer">
    <h2>Footer</h2>
</div>

</body>
<script src="../../jquery/jquery-3.5.1.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap5.min.js"></script>
<script src="../../bootstrap-5.2.2-dist/js/bootstrap.bundle.min.js"></script>

<script>
    $(document).ready(function () {
        $('#tableTent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });

</script>


</html>
