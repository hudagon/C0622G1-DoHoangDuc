<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 09/10/2022
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../../bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../bootstrap-5.2.2-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../datatables/css/dataTables.bootstrap5.min.css"/>
    <link rel="stylesheet" href="../../view/tent/tent.css"/>

</head>
<body>

<div class="header">
    <h1>HỆ THỐNG QUẢN LÝ THUÊ PHÒNG TRỌ</h1>
</div>

<div class="topnav">
    <a href="/tent">Home</a>
    <a href="/tent?action=add" style="color: white">Add New Tent</a>
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
        <c:if test="${listCheck == -1}">
            <form action="/tent?action=add" method="post">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5"></h1>
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
                            <button type="submit" class="btn btn-primary" style="margin-right: 10px">Save changes
                            </button>
                            <button type="button" class="btn btn-primary">
                                <a style="color: white" href="/tent">Close</a>
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </c:if>

        <c:if test="${listCheck != -1}">
            <table id="tableTent" class="table table-striped table-bordered" style="width:100%">
                <thead>
                <tr>
                    <th>Number</th>
                    <th>Tenant's Name</th>
                    <th>Phone Number</th>
                    <th>Start Date</th>
                    <th>Pay Method</th>
                    <th>Description</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="x" items="${tentList}" varStatus="count">
                    <tr>
                        <td>${count.getCount()}</td>
                        <td>${x.getTenantName()}</td>
                        <td>${x.getPhoneNumber()}</td>
                        <td>${x.getStartDate()}</td>
                        <c:forEach var="y" items="${payMethodList}">
                            <c:if test="${x.getPayMethodId() == y.getId()}">
                                <td>${y.getName()}</td>
                            </c:if>
                        </c:forEach>
                        <td>${x.getDescription()}</td>
                        <td>
                            <form action="/tent?action=edit" method="post">
                                <input type="text" value="${x.getIdTent()}" name="idTenant" hidden>
                                <input type="text" value="${x.getTenantName()}" name="tenantName" hidden>
                                <input type="text" value="${x.getPhoneNumber()}" name="phoneNumber" hidden>
                                <input type="text" value="${x.getStartDate()}" name="startDate" hidden>
                                <input type="text" value="${x.getPayMethodId()}" name="payMethodId" hidden>
                                <input type="text" value="${x.getDescription()}" name="description" hidden>

                                <button type="submit" class="btn btn-primary">Edit</button>
                            </form>
                        </td>
                        <td>
                            <button onclick="getInfo('${x.getIdTent()}')"
                                    type="button"
                                    class="btn btn-danger"
                                    data-bs-toggle="modal"
                                    data-bs-target="#deleteModal">
                                Delete
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
        <p style="color: red">${mess}</p>
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


<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/tent?action=delete" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Delete Tent</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" name="idDelete" id="idDelete" hidden>
                    <p>Are you sure want to delete tent that has the id of <span id="nameDelete"></span> ?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </form>
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


    function getInfo(id) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerHTML = id;
    }
</script>
</html>
