<%--
  Created by IntelliJ IDEA.
  User: Xuan Vinh
  Date: 06/10/2022
  Time: 06:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="view/customer/customer.css">
<%--    <style>--%>
<%--        * {--%>
<%--            box-sizing: border-box;--%>
<%--        }--%>

<%--        body {--%>
<%--            font-family: Arial;--%>
<%--            padding: 10px;--%>
<%--            background: #f1f1f1;--%>
<%--        }--%>

<%--        /* Header/Blog Title */--%>
<%--        .header {--%>
<%--            padding: 30px;--%>
<%--            text-align: center;--%>
<%--            background: white;--%>
<%--        }--%>

<%--        .header h1 {--%>
<%--            font-size: 50px;--%>
<%--        }--%>

<%--        /* Style the top navigation bar */--%>
<%--        .topnav {--%>
<%--            overflow: hidden;--%>
<%--            background-color: #333;--%>
<%--        }--%>

<%--        /* Style the topnav links */--%>
<%--        .topnav a {--%>
<%--            float: left;--%>
<%--            display: block;--%>
<%--            color: #f2f2f2;--%>
<%--            text-align: center;--%>
<%--            padding: 14px 16px;--%>
<%--            text-decoration: none;--%>
<%--        }--%>

<%--        /* Change color on hover */--%>
<%--        .topnav a:hover {--%>
<%--            background-color: #ddd;--%>
<%--            color: black;--%>
<%--        }--%>

<%--        /* Create two unequal columns that floats next to each other */--%>
<%--        /* Left column */--%>
<%--        .leftcolumn {--%>
<%--            float: left;--%>
<%--            width: 75%;--%>
<%--        }--%>

<%--        /* Right column */--%>
<%--        .rightcolumn {--%>
<%--            float: left;--%>
<%--            width: 25%;--%>
<%--            background-color: #f1f1f1;--%>
<%--            padding-left: 20px;--%>
<%--        }--%>

<%--        /* Fake image */--%>
<%--        .fakeimg {--%>
<%--            background-color: #aaa;--%>
<%--            width: 100%;--%>
<%--            padding: 20px;--%>
<%--        }--%>

<%--        /* Add a card effect for articles */--%>
<%--        .card {--%>
<%--            background-color: white;--%>
<%--            padding: 20px;--%>
<%--            margin-top: 20px;--%>
<%--        }--%>

<%--        /* Clear floats after the columns */--%>
<%--        .row:after {--%>
<%--            content: "";--%>
<%--            display: table;--%>
<%--            clear: both;--%>
<%--        }--%>

<%--        /* Footer */--%>
<%--        .footer {--%>
<%--            padding: 20px;--%>
<%--            text-align: center;--%>
<%--            background: #ddd;--%>
<%--            margin-top: 20px;--%>
<%--        }--%>

<%--        /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */--%>
<%--        @media screen and (max-width: 800px) {--%>
<%--            .leftcolumn, .rightcolumn {--%>
<%--                width: 100%;--%>
<%--                padding: 0;--%>
<%--            }--%>
<%--        }--%>

<%--        /* Responsive layout - when the screen is less than 400px wide, make the navigation links stack on top of each other instead of next to each other */--%>
<%--        @media screen and (max-width: 400px) {--%>
<%--            .topnav a {--%>
<%--                float: none;--%>
<%--                width: 100%;--%>
<%--            }--%>
<%--        }--%>

<%--    </style>--%>
</head>
<body>

<div class="header">
    <h1>Furama</h1>
    <p>Resize the browser window to see the effect.</p>
</div>

<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#" style="margin-bottom: 2.5px">Home</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Customer</a>
                </li>
                <li class="nav-item">
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addNewModal">
                        Add new customer
                    </button>
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#deleteModal">
                        Delete customer
                    </button>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="row">
    <div class="leftcolumn">
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
                <h1 class="modal-title fs-5">Add new employee</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="input-group mb-3">
                    <span class="input-group-text">@</span>
                    <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>

                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2">
                    <span class="input-group-text" >@example.com</span>
                </div>

                <label for="addNewModal" class="form-label">Your vanity URL</label>
                <div class="input-group mb-3">
                    <span class="input-group-text" >https://example.com/users/</span>
                    <input type="text" class="form-control"  aria-describedby="basic-addon3">
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">$</span>
                    <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
                    <span class="input-group-text">.00</span>
                </div>

                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Username" aria-label="Username">
                    <span class="input-group-text">@</span>
                    <input type="text" class="form-control" placeholder="Server" aria-label="Server">
                </div>

                <div class="input-group">
                    <span class="input-group-text">With textarea</span>
                    <textarea class="form-control" aria-label="With textarea"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5">Add new employee</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="input-group mb-3">
                    <span class="input-group-text">@</span>
                    <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>

                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2">
                    <span class="input-group-text" >@example.com</span>
                </div>

                <label for="addNewModal" class="form-label">Your vanity URL</label>
                <div class="input-group mb-3">
                    <span class="input-group-text" >https://example.com/users/</span>
                    <input type="text" class="form-control"  aria-describedby="basic-addon3">
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">$</span>
                    <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
                    <span class="input-group-text">.00</span>
                </div>

                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="Username" aria-label="Username">
                    <span class="input-group-text">@</span>
                    <input type="text" class="form-control" placeholder="Server" aria-label="Server">
                </div>

                <div class="input-group">
                    <span class="input-group-text">With textarea</span>
                    <textarea class="form-control" aria-label="With textarea"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Delete employee</h1>
                <!--                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>-->
            </div>
            <div class="modal-body">
                <p>Are you sure want to delete this employee?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous">
</script>
</html>

