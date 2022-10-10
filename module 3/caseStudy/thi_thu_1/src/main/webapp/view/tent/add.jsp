<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 10/10/2022
  Time: 04:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Tent</title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
    <link rel="stylesheet" href="view/tent/tent.css" />
</head>
<body>
<div class="header">
    <h1>HỆ THỐNG QUẢN LÝ THUÊ PHÒNG TRỌ</h1>
</div>
<div class="topnav">
    <a href="/tent">Home</a>
    <a href="#">Add New Tent</a>
    <a href="#">Link</a>
</div>
<div class="row">
    <div class="leftcolumn">
        <form action="/tent?action=add" method="post">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5">Add New Tent</h1>
                    </div>
                    <div class="modal-body">

                        <div class="input-group mb-3">
                            <span class="input-group-text">Tenant Name</span>
                            <input type="text" class="form-control" name="tenantName" aria-label="Name"
                                   aria-describedby="basic-addon1">
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">Phone Number</span>
                            <input type="text" class="form-control" name="phoneNumber" aria-label="Name"
                                   aria-describedby="basic-addon1">
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">Start Date</span>
                            <input type="date" class="form-control" name="startDate" aria-label="Name"
                                   aria-describedby="basic-addon1">
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">Phone Number</span>
                            <input type="text" class="form-control" name="phoneNumber" aria-label="Name"
                                   aria-describedby="basic-addon1">
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">Pay Method</span>
                            <select name="payMethodId">
                                <option value="1">Month</option>
                                <option value="2">Quarter</option>
                                <option value="3">Year</option>
                            </select>
                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text">Description</span>
                            <input type="text" class="form-control" name="description" aria-label="v"
                                   aria-describedby="basic-addon1">
                        </div>

                    </div>

                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </form>
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
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
</html>
