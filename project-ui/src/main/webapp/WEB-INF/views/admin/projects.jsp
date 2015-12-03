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
                        <a href="/admin/projects" class="list-group-item">Projects</a>
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
                                        <c:if test="${not empty howUsers}">
                                            ${howUsers}
                                        </c:if>
                                    </td>

                                </tr>
                                <tr>
                                    <td>Offers</td>
                                    <td>
                                        <c:if test="${not empty howOffers}">
                                            ${howOffers}
                                        </c:if>
                                    </td>

                                </tr>
                                </tbody>

                                <div class="panel panel-primary">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">Create project</h3>
                                    </div>
                                    <div class="panel-body">
                                        <form role="form" draggable="true">
                                            <div class="form-group">
                                                <label class="control-label" >Title</label>
                                                <input class="form-control" placaholder="Title" data-bind="value: title" />
                                            </div>
                                            <div class="form-group" draggable="true">
                                                <label class="control-label" >Description</label>
                                                <textarea style="width:100%;height: 140px" placeholder="  Description" data-bind="value: description"></textarea>
                                            </div>
                                            <label >Time</label>
                                                <div class="form-group input-group">
                                                  <input placeholder="Time" class="form-control" placaholder="time" data-bind="value: price"/>
                                                </div>
                                            <div class="form-group">
                                                <label>File input</label>

                                                <input data-bind="event: { change: function() { changePhoto($element.files[0]) } }"
                                                       class="upload-link-input" name="textbox" type="file" accept=".jpg,.jpeg,.gif" />

                                            </div>
                                            <p class="submit">
                                                <a class="btn btn-primary" data-bind="click: create">Create</a>
                                            </p>

                                        </form>
                                    </div>
                                </div>
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
                            <h3 class="panel-title text-center">Edit Offers</h3>
                        </div>
                        <div class="panel-body">


                            <table class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th>Username</th>
                                    <th>Title</th>
                                    <th>Offer</th>
                                    <th>likes</th>
                                    <th>Edit</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>"Bla"</td>
                                    <td>
                                        <textarea style="width:100%"></textarea>
                                    </td>
                                    <td>2738</td>
                                    <td>
                                        <p class="btn btn-primary" style="margin-left:18%">Save</p>
                                        <p class="btn btn-danger text-danger">Delete</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>"Bla"</td>
                                    <td>
                                        <textarea style="width:100%"></textarea>
                                    </td>
                                    <td>2738</td>
                                    <td>
                                        <p class="btn btn-primary" style="margin-left:18%">Save</p>
                                        <p class="btn btn-danger text-danger">Delete</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>"Bla"</td>
                                    <td>
                                        <textarea style="width:100%"></textarea>
                                    </td>
                                    <td>2738</td>
                                    <td>
                                        <p class="btn btn-primary" style="margin-left:18%">Save</p>
                                        <p class="btn btn-danger text-danger">Delete</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>"Bla"</td>
                                    <td>
                                        <textarea style="width:100%"></textarea>
                                    </td>
                                    <td>2738</td>
                                    <td>
                                        <p class="btn btn-primary" style="margin-left:18%">Save</p>
                                        <p class="btn btn-danger text-danger">Delete</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>"Bla"</td>
                                    <td>
                                        <textarea style="width:100%"></textarea>
                                    </td>
                                    <td>2738</td>
                                    <td>
                                        <p class="btn btn-primary" style="margin-left:18%">Save</p>
                                        <p class="btn btn-danger text-danger">Delete</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td>1</td>
                                    <td>Mark</td>
                                    <td>"Bla"</td>
                                    <td>
                                        <textarea style="width:100%"></textarea>
                                    </td>
                                    <td>2738</td>
                                    <td>
                                        <p class="btn btn-primary" style="margin-left:18%">Save</p>
                                        <p class="btn btn-danger text-danger">Delete</p>
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
    </tiles:putAttribute>
</tiles:insertDefinition>