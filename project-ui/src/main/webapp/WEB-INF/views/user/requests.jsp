<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="base.definition">
    <tiles:putAttribute name="body">
    <div class="container" style="margin-top: 5%;">
    <div class="row">

    <div class="col-md-3">

        <div class="list-group">
            <a href="/user/offers" class="list-group-item">My Offers</a>
            <a href="/user/requests" class="list-group-item">Responces</a>
            <hr>
            <div class="list-group">

                <table class="table">
                    <thead>
                    <tr>
                        <th>Responses:</th>

                    </tr>
                    </thead>
                    <tbody style="border-color: rgb(13, 107, 248); border-style: dotted;">
                    <tr>
                        <td style="width:100%">User</td>
                        <td>
                            <p class="btn btn-success">Yes</p>
                            <p>
                            </p>
                            <p class="btn btn-danger">No!</p>
                        </td>

                    </tr>
                    <tr>
                        <td style="width:100%">User</td>
                        <td>
                            <p class="btn btn-success">Yes</p>
                            <p>
                            </p>
                            <p class="btn btn-danger">No!</p>
                        </td>

                    </tr>
                    <tr>
                        <td style="width:100%">User</td>
                        <td>
                            <p class="btn btn-success">Yes</p>
                            <p>
                            </p>
                            <p class="btn btn-danger">No!</p>
                        </td>

                    </tr>

                    </tbody>
                </table>

            </div>


        </div>

    </div>

    <div class="col-md-9">

        <div class="row carousel-holder">

            <div class="col-md-12">

            </div>

        </div>

        <div class="row">

            <div class="col-sm-4 col-lg-4 col-md-4">

            </div>

            <div class="col-sm-4 col-lg-4 col-md-4">

            </div>

            <div class="col-sm-4 col-lg-4 col-md-4">

            </div>

            <div class="col-sm-4 col-lg-4 col-md-4">

            </div>

            <div class="col-sm-4 col-lg-4 col-md-4">

            </div>


        </div>
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">My &nbsp;Responces</h3>
            </div>
            <div class="panel-body">


                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th></th>
                        <th>User name
                        </th>
                        <th>Title</th>
                        <th>Rating</th>
                        <th>Edit</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>Johny</td>
                        <td>
                            Yesterday night
                        </td>
                        <td>* * * * *</td>
                        <td style="width:8%">
                            <p class="btn btn-success">Yes</p>
                            <p>
                            </p>
                            <p class="btn btn-danger">No!</p>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Johny</td>
                        <td>
                            Yesterday night
                        </td>
                        <td>* * * * *</td>
                        <td style="width:8%">
                            <p class="btn btn-success">Yes</p>
                            <p>
                            </p>
                            <p class="btn btn-danger">No!</p>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Johny</td>
                        <td>
                            Yesterday night
                        </td>
                        <td>* * * * *</td>
                        <td style="width:8%">
                            <p class="btn btn-success">Yes</p>
                            <p>
                            </p>
                            <p class="btn btn-danger">No!</p>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Johny</td>
                        <td>
                            Yesterday night
                        </td>
                        <td>* * * * *</td>
                        <td style="width:8%">
                            <p class="btn btn-success">Yes</p>
                            <p>
                            </p>
                            <p class="btn btn-danger">No!</p>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Johny</td>
                        <td>
                            Yesterday night
                        </td>
                        <td>* * * * *</td>
                        <td style="width:8%">
                            <p class="btn btn-success">Yes</p>
                            <p>
                            </p>
                            <p class="btn btn-danger">No!</p>
                        </td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Johny</td>
                        <td>
                            Yesterday night
                        </td>
                        <td>* * * * *</td>
                        <td style="width:8%">
                            <p class="btn btn-success">Yes</p>
                            <p>
                            </p>
                            <p class="btn btn-danger">No!</p>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>

    </div>
    </div>
    <!-- /.container -->

<!-- Core Scripts - Include with every page -->
<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.min.js"></script>

<!-- SB Admin Scripts - Include with every page -->
<script src="js/sb-admin.js"></script>

<!-- Page-Level Demo Scripts - Forms - Use for reference -->
    </tiles:putAttribute>
</tiles:insertDefinition>