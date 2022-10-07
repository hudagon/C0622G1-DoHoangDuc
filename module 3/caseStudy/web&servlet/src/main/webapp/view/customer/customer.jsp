<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 06/10/2022
  Time: 06:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
    <link rel="stylesheet" type="text/css" href="view/employee/employee.css">
</head>
<body>

<div class="header">
    <h1>Furama</h1>
    <p>Resize the browser window to see the effect.</p>
</div>

<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/view/home/home.jsp" style="margin-bottom: 2.5px">Home</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Employee</a>
                </li>
                <li class="nav-item">
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addNewModal">
                        Add new employee
                    </button>
                </li>
            </ul>
            <form class="d-flex" role="search" action="/customer?action=searchByName" method="post">
                <input name="searchName" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="row">
    <div class="leftcolumn">
        <table id="tableCustomer" class="table table-striped table-bordered" style="width:100%">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Customer Type ID</th>
                <th scope="col">Name</th>
                <th scope="col">Date of Birth</th>
                <th scope="col">Gender</th>
                <th scope="col">ID Card</th>
                <th scope="col">Phone Number</th>
                <th scope="col">Email</th>
                <th scope="col">Address</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody class="table-group-divider">
            <c:forEach var="x" items="${customerList}">
                <tr>
                    <th>${x.getId()}</th>
                    <th>${x.getCustomerTypeId()}</th>
                    <th>${x.getName()}</th>
                    <th>${x.getDateOfBirth()}</th>
                    <th>${x.isGender()}</th>
                    <th>${x.getIdCard()}</th>
                    <th>${x.getPhoneNumber()}</th>
                    <th>${x.getEmail()}</th>
                    <th>${x.getAddress()}</th>
                    <th>
                        <button onclick="getInfo('${x.getId()}','${x.getCustomerTypeId()}','${x.getName()}',
                                '${x.getDateOfBirth()}','${x.isGender()}','${x.getIdCard()}','${x.getPhoneNumber()}',
                                '${x.getEmail()}','${x.getAddress()}'
                                )" type="button"
                                class="btn btn-primary"
                                data-bs-toggle="modal"
                                data-bs-target="#editModal">
                            Edit
                        </button>
                    </th>
                    <th>
                        <button onclick="showInfo('${x.getId()}','${x.getName()}')" type="button"
                                class="btn btn-primary"
                                data-bs-toggle="modal"
                                data-bs-target="#deleteModal">
                            Delete
                        </button>
                    </th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p>${mess}</p>
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

<div class="modal fade" id="addNewModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/customer?action=add" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5">Add new employee</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="input-group mb-3">
                        <span class="input-group-text">ID</span>
                        <input type="text" class="form-control" name="id" aria-label="ID"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Customer Type ID</span>
                        <select name="customerTypeID">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Name</span>
                        <input type="text" class="form-control" name="name" aria-label="Name"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Date Of Birth</span>
                        <input type="date" class="form-control" name="dateOfBirth" aria-label="Name"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Gender</span>
                        <select name="gender">
                            <option value="1">Male</option>
                            <option value="0">Female</option>
                        </select>
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">ID Card</span>
                        <input type="text" class="form-control" name="idCard" aria-label="idCard"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Phone Number</span>
                        <input type="text" class="form-control" name="phoneNumber" aria-label="phoneNumber"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Email</span>
                        <input type="text" class="form-control" name="email" aria-label="email"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Address</span>
                        <input type="text" class="form-control" name="address" aria-label="v"
                               aria-describedby="basic-addon1">
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </form>
</div>
<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/customer?action=edit" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5">Edit Employee</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="input-group mb-3">
                        <span class="input-group-text">ID</span>
                        <input id="idEdit"  type="text" class="form-control" name="id" aria-label="ID"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Customer Type ID</span>
                        <select name="customerTypeID" id="customerTypeIdEdit">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Name</span>
                        <input id="nameEdit" type="text" class="form-control" name="name" aria-label="Name"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Date Of Birth</span>
                        <input id="dateOfBirthEdit" type="date" class="form-control" name="dateOfBirth" aria-label="Name"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Gender</span>
                        <select id="genderEdit" name="gender">
                            <option value="1">Male</option>
                            <option value="0">Female</option>
                        </select>
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">ID Card</span>
                        <input id="idCardEdit" type="text" class="form-control" name="idCard" aria-label="idCard"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Phone Number</span>
                        <input id="phoneNumberEdit" type="text" class="form-control" name="phoneNumber" aria-label="phoneNumber"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Email</span>
                        <input id="emailEdit" type="text" class="form-control" name="email" aria-label="email"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Address</span>
                        <input id="addressEdit" type="text" class="form-control" name="address" aria-label="v"
                               aria-describedby="basic-addon1">
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </form>
</div>
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form>
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Delete employee</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" name="idDelete" id="idDelete">
                    <p>Are you sure want to delete <p id="nameDelete"></p></p>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });

    function showInfo(id,name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").text = name;
    }

    function getInfo(id,customerTypeId,name,dateOfBirth,gender,idCard,phoneNumber,email,address) {
        document.getElementById("idEdit").value = id;
        document.getElementById("customerTypeIdEdit").value = customerTypeId;
        document.getElementById("nameEdit").value = name;
        document.getElementById("dateOfBirthEdit").value = dateOfBirth
        document.getElementById("genderEdit").value = gender
        document.getElementById("idCardEdit").value = idCard
        document.getElementById("phoneNumberEdit").value = phoneNumber
        document.getElementById("emailEdit").value = email
        document.getElementById("addressEdit").value = address
    }
</script>
</html>