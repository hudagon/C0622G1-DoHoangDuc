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
    <title>Service</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
    <link rel="stylesheet" type="text/css" href="view/service/service.css">
</head>
<body>

<div class="header">
    <h1>Furama</h1>
    <p>Resize the browser window to see the effect.</p>
</div>

<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/view/home/home.jsp" style="margin-bottom: 2px">Home</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/service">Service</a>
                </li>
                <li class="nav-item">
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addNewModal">
                        Add new service
                    </button>
                </li>
            </ul>
            <form class="d-flex" role="search" action="/service?action=searchByName" method="post">
                <input name="searchName" class="form-control me-2" type="search" placeholder="Search"
                       aria-label="Search">
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
                <th scope="col">Name</th>
                <th scope="col">Area</th>
                <th scope="col">Cost</th>
                <th scope="col">Max People</th>
                <th scope="col">Rent Type Id</th>
                <th scope="col">Facility Type Id</th>
                <th scope="col">Standard Room</th>
                <th scope="col">Description</th>
                <th scope="col">Pool Area</th>
                <th scope="col">Number of floors</th>
                <th scope="col">Facility Free</th>
                <th scope="col">Edit</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody class="table-group-divider">
            <c:forEach var="x" items="${serviceList}">
                <tr>
                    <th>${x.getId()}</th>
                    <th>${x.getName()}</th>
                    <th>${x.getArea()}</th>
                    <th>${x.getCost()}</th>
                    <th>${x.getMaxPeople()}</th>
                    <th>${x.getRentTypeId()}</th>
                    <th>${x.getFacilityTypeId()}</th>
                    <th>${x.getStandardRoom()}</th>
                    <th>${x.getDesriptionOtherConvenience()}</th>
                    <th>${x.getPoolArea()}</th>
                    <th>${x.getNumberOfFloors()}</th>
                    <th>${x.getFacilityFree()}</th>
                    <th>
                        <button onclick="getInfo('${x.getId()}','${x.getName()}','${x.getArea()}',
                                '${x.getCost()}','${x.getMaxPeople()}','${x.getRentTypeId()}','${x.getFacilityTypeId()}',
                                '${x.getStandardRoom()}','${x.getDesriptionOtherConvenience()}','${x.getPoolArea()}',
                                '${x.getNumberOfFloors()}','${x.getFacilityFree()}'
                                )" type="button"
                                class="btn btn-primary"
                                data-bs-toggle="modal"
                                <c:if test="${x.getFacilityTypeId()==1}">
                                    data-bs-target="#editVillaModal">
                                </c:if>
                                <c:if test="${x.getFacilityTypeId()==2}">
                                    data-bs-target="#editRoomModal">
                                </c:if>
                                <c:if test="${x.getFacilityTypeId()==3}">
                                    data-bs-target="#editHouseModal">
                                </c:if>
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
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5">Add new service</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>Please choose type of facility</p>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addNewVilla">
                        Villa
                    </button>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addNewHouse">
                        House
                    </button>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addNewRoom">
                        Room
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="addNewVilla" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/service?action=add" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5">Add new villa</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="input-group mb-3">
                        <span class="input-group-text">ID</span>
                        <input type="text" class="form-control" name="id" aria-label="ID"
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">Name</span>
                        <input type="text" class="form-control" name="name" aria-label="Name"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Area</span>
                        <input type="text" class="form-control" name="area" aria-label="area"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Cost</span>
                        <input type="text" class="form-control" name="cost" aria-label="cost"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Max people</span>
                        <input type="text" class="form-control" name="maxPeople" aria-label="maxPeople"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Rent Type ID</span>
                        <select name="rentTypeId">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Standard room</span>
                        <input type="text" class="form-control" name="standardRoom" aria-label="standardRoom"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Description</span>
                        <input type="text" class="form-control" name="descriptionOtherConvenience"
                               aria-label="descriptionOtherConvenience"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Pool Area</span>
                        <input type="text" class="form-control" name="poolArea" aria-label="poolArea"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Number Of Floors</span>
                        <input type="text" class="form-control" name="numberOfFloors" aria-label="numberOfFloors"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Facility Free</span>
                        <input type="text" class="form-control" name="facilityFree" aria-label="facilityFree"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Facility Type</span>
                        <input value="1" type="text" class="form-control" name="facilityTypeId"
                               aria-label="facilityFree"
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
<div class="modal fade" id="addNewRoom" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/service?action=add" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5">Add New Room</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="input-group mb-3">
                        <span class="input-group-text">ID</span>
                        <input type="text" class="form-control" name="id" aria-label="ID"
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">Name</span>
                        <input type="text" class="form-control" name="name" aria-label="Name"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Area</span>
                        <input type="text" class="form-control" name="area" aria-label="area"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Cost</span>
                        <input type="text" class="form-control" name="cost" aria-label="cost"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Max people</span>
                        <input type="text" class="form-control" name="maxPeople" aria-label="maxPeople"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Rent Type ID</span>
                        <select name="rentTypeId">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Standard room</span>
                        <input type="text" class="form-control" name="standardRoom" aria-label="standardRoom"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Description</span>
                        <input type="text" class="form-control" name="descriptionOtherConvenience"
                               aria-label="descriptionOtherConvenience"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Pool Area</span>
                        <input type="text" class="form-control" name="poolArea" aria-label="poolArea"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Number Of Floors</span>
                        <input type="text" class="form-control" name="numberOfFloors" aria-label="numberOfFloors"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Facility Free</span>
                        <input type="text" class="form-control" name="facilityFree" aria-label="facilityFree"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Facility Type</span>
                        <input value="2" type="text" class="form-control" name="facilityTypeId"
                               aria-label="facilityFree"
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
<div class="modal fade" id="addNewHouse" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/service?action=add" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5">Add new house</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="input-group mb-3">
                        <span class="input-group-text">ID</span>
                        <input type="text" class="form-control" name="id" aria-label="ID"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Name</span>
                        <input type="text" class="form-control" name="name" aria-label="Name"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Area</span>
                        <input type="text" class="form-control" name="area" aria-label="area"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Cost</span>
                        <input type="text" class="form-control" name="cost" aria-label="cost"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Max people</span>
                        <input type="text" class="form-control" name="maxPeople" aria-label="maxPeople"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Rent Type ID</span>
                        <select name="rentTypeId">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Standard room</span>
                        <input type="text" class="form-control" name="standardRoom" aria-label="standardRoom"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Description</span>
                        <input type="text" class="form-control" name="descriptionOtherConvenience"
                               aria-label="descriptionOtherConvenience"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Number Of Floors</span>
                        <input type="text" class="form-control" name="numberOfFloors" aria-label="numberOfFloors"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Pool Area</span>
                        <input value="" type="text" class="form-control" name="poolArea" aria-label="poolArea"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Facility Free</span>
                        <input type="text" class="form-control" name="facilityFree" aria-label="facilityFree"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Facility Type</span>
                        <input value="3" type="text" class="form-control" name="facilityTypeId"
                               aria-label="facilityFree"
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

<div class="modal fade" id="editVillaModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <form action="/service?action=edit" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5">Edit Villa</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Facility Type</span>
                        <input type="text" class="form-control" name="facilityTypeId" id="facilityTypeIdVilla"
                               aria-label="facilityFree"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">ID</span>
                        <input type="text" class="form-control" name="id" id="idVilla" aria-label="ID"
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">Name</span>
                        <input type="text" class="form-control" name="name" id="nameVilla" aria-label="Name"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Area</span>
                        <input type="text" class="form-control" name="area" id="areaVilla" aria-label="area"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Cost</span>
                        <input type="text" class="form-control" name="cost" id="costVilla" aria-label="cost"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Max people</span>
                        <input type="text" class="form-control" name="maxPeople" id="maxPeopleVilla" aria-label="maxPeople"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Rent Type ID</span>
                        <select name="rentTypeId" id="rentTypeIdVilla">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Standard room</span>
                        <input type="text" class="form-control" name="standardRoom" id="standardRoomVilla"
                               aria-label="standardRoom"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Description</span>
                        <input type="text" class="form-control" name="descriptionOtherConvenience"
                               id="descriptionOtherConvenienceVilla"
                               aria-label="descriptionOtherConvenience"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Pool Area</span>
                        <input type="text" class="form-control" name="poolArea" id="poolAreaVilla" aria-label="poolArea"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Number Of Floors</span>
                        <input type="text" class="form-control" name="numberOfFloors" id="numberOfFloorsVilla"
                               aria-label="numberOfFloors"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Facility Free</span>
                        <input type="text" class="form-control" name="facilityFree" id="facilityFreeVilla"
                               aria-label="facilityFree"
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
<div class="modal fade" id="editRoomModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">


    <form action="/service?action=edit" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5">Edit Room</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Facility Type</span>
                        <input type="text" class="form-control" name="facilityTypeId" id="facilityTypeIdRoom"
                               aria-label="facilityFree"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">ID</span>
                        <input type="text" class="form-control" name="id" id="idRoom" aria-label="ID"
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">Name</span>
                        <input type="text" class="form-control" name="name" id="nameRoom" aria-label="Name"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Area</span>
                        <input type="text" class="form-control" name="area" id="areaRoom" aria-label="area"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Cost</span>
                        <input type="text" class="form-control" name="cost" id="costRoom" aria-label="cost"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Max people</span>
                        <input type="text" class="form-control" name="maxPeople" id="maxPeopleRoom" aria-label="maxPeople"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Rent Type ID</span>
                        <select name="rentTypeId" id="rentTypeIdRoom">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Standard room</span>
                        <input type="text" class="form-control" name="standardRoom" id="standardRoomRoom"
                               aria-label="standardRoom"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Description</span>
                        <input type="text" class="form-control" name="descriptionOtherConvenience"
                               id="descriptionOtherConvenienceRoom"
                               aria-label="descriptionOtherConvenience"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Pool Area</span>
                        <input type="text" class="form-control" name="poolArea" id="poolAreaRoom" aria-label="poolArea"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Number Of Floors</span>
                        <input type="text" class="form-control" name="numberOfFloors" id="numberOfFloorsRoom"
                               aria-label="numberOfFloors"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Facility Free</span>
                        <input type="text" class="form-control" name="facilityFree" id="facilityFreeRoom"
                               aria-label="facilityFree"
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
<div class="modal fade" id="editHouseModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">


    <form action="/service?action=edit" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5">Edit House</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Facility Type</span>
                        <input type="text" class="form-control" name="facilityTypeId" id="facilityTypeIdHouse"
                               aria-label="facilityFree"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">ID</span>
                        <input type="text" class="form-control" name="id" id="idHouse" aria-label="ID"
                               aria-describedby="basic-addon1">
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">Name</span>
                        <input type="text" class="form-control" name="name" id="nameHouse" aria-label="Name"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Area</span>
                        <input type="text" class="form-control" name="area" id="areaHouse" aria-label="area"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Cost</span>
                        <input type="text" class="form-control" name="cost" id="costHouse" aria-label="cost"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Max people</span>
                        <input type="text" class="form-control" name="maxPeople" id="maxPeopleHouse" aria-label="maxPeople"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Rent Type ID</span>
                        <select name="rentTypeId" id="rentTypeIdHouse">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </div>

                    <div class="input-group mb-3" >
                        <span class="input-group-text">Standard room</span>
                        <input type="text" class="form-control" name="standardRoom" id="standardRoomHouse"
                               aria-label="standardRoom"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" >
                        <span class="input-group-text">Description</span>
                        <input type="text" class="form-control" name="descriptionOtherConvenience"
                               id="descriptionOtherConvenienceHouse"
                               aria-label="descriptionOtherConvenience"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Pool Area</span>
                        <input type="text" class="form-control" name="poolArea" id="poolAreaHouse" aria-label="poolArea"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" >
                        <span class="input-group-text">Number Of Floors</span>
                        <input type="text" class="form-control" name="numberOfFloors" id="numberOfFloorsHouse"
                               aria-label="numberOfFloors"
                               aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group mb-3" hidden>
                        <span class="input-group-text">Facility Free</span>
                        <input type="text" class="form-control" name="facilityFree" id="facilityFreeHouse"
                               aria-label="facilityFree"
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
    <form action="/service?action=delete" method="post">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Delete employee</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" name="idDelete" id="idDelete" hidden>
                    <p>Are you sure want to delete
                    <p id="nameDelete"></p></p>
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

    function showInfo(id, name) {
        document.getElementById("idDelete").value = id;
        document.getElementById("nameDelete").innerHTML = name;
    }

    function getInfo(id, name, area,
                     cost, maxPeople, rentTypeId, facilityTypeId,
                     standardRoom, desriptionOtherConvenience, poolArea,
                     numberOfFloors, facilityFree) {

        document.getElementById("facilityTypeIdVilla").value = facilityTypeId;
        document.getElementById("idVilla").value = id;
        document.getElementById("nameVilla").value = name;
        document.getElementById("areaVilla").value = area;
        document.getElementById("costVilla").value = cost;
        document.getElementById("maxPeopleVilla").value = maxPeople;
        document.getElementById("rentTypeIdVilla").value = rentTypeId;
        document.getElementById("standardRoomVilla").value = standardRoom;
        document.getElementById("descriptionOtherConvenienceVilla").value = desriptionOtherConvenience;
        document.getElementById("poolAreaVilla").value = poolArea;
        document.getElementById("numberOfFloorsVilla").value = numberOfFloors;
        document.getElementById("facilityFreeVilla").value = facilityFree;

        document.getElementById("facilityTypeIdRoom").value = facilityTypeId;
        document.getElementById("idRoom").value = id;
        document.getElementById("nameRoom").value = name;
        document.getElementById("areaRoom").value = area;
        document.getElementById("costRoom").value = cost
        document.getElementById("maxPeopleRoom").value = maxPeople
        document.getElementById("rentTypeIdRoom").value = rentTypeId
        document.getElementById("standardRoomRoom").value = standardRoom
        document.getElementById("descriptionOtherConvenienceRoom").value = desriptionOtherConvenience
        document.getElementById("poolAreaRoom").value = poolArea
        document.getElementById("numberOfFloorsRoom").value = numberOfFloors
        document.getElementById("facilityFreeRoom").value = facilityFree

        document.getElementById("facilityTypeIdHouse").value = facilityTypeId;
        document.getElementById("idHouse").value = id;
        document.getElementById("nameHouse").value = name;
        document.getElementById("areaHouse").value = area;
        document.getElementById("costHouse").value = cost
        document.getElementById("maxPeopleHouse").value = maxPeople
        document.getElementById("rentTypeIdHouse").value = rentTypeId
        document.getElementById("standardRoomHouse").value = standardRoom
        document.getElementById("descriptionOtherConvenienceHouse").value = desriptionOtherConvenience
        document.getElementById("poolAreaHouse").value = poolArea
        document.getElementById("numberOfFloorsHouse").value = numberOfFloors
        document.getElementById("facilityFreeHouse").value = facilityFree
    }
</script>
</html>