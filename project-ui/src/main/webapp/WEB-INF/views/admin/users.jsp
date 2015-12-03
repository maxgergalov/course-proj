<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="base.definition">
<tiles:putAttribute name="body">
    <script type="text/javascript" src="/resources/js/test.js"></script>

<div class="container" style="margin-top: 5%;">
<div class="row">

<div class="col-md-3">


    <div class="list-group">
        <a href="/admin/users" class="list-group-item">Users</a>
        <a href="/admin/tasks" class="list-group-item">Tasks</a>
        <hr>
        <div class="list-group">

            <table class="table table-bordered">
                <thead>
                <tr style="background: white">
                    <th></th>
                    <th>On site</th>

                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Users</td>
                    <td>
                        <p data-bind="text: howUsers"></p>
                    </td>
                </tr>
                <tr>
                    <td>Offers</td>
                    <td>
                        <p data-bind="text: howOffers"></p>
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
            <h3 class="panel-title">Users</h3>
        </div>
        <div class="panel-body">


            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>password</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tbody data-bind="foreach: users">
                <tr>

                    <td data-bind="text: id"></td>
                    <td>
                        <meta name="author" />
                        <input data-bind="value: name"/></td>
                    <td meta name="email" data-bind="text: mail"></td>
                    <td>
                        <meta name="password_key" />
                        <input data-bind="value: password"/>
                    </td>
                    <td>
                        <p class="btn btn-primary"  data-bind="click: $parent.saveUser">Save</p>
                        <p class="btn btn-danger text-danger" data-bind="click: $parent.deleteUser">Delete</p>
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




</tiles:putAttribute>
</tiles:insertDefinition>
