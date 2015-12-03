<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<s:message code="input.placaholder.title" var="Title"/>
<s:message code="input.placaholder.discription" var="Discription"/>
<s:message code="input.placaholder.price" var="Price"/>

<tiles:insertDefinition name="base.definition">
    <tiles:putAttribute name="body">

        <script type="text/javascript" src="/resources/js/test.js"></script>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12" >

        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12" style="margin-top: 3%;">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Create your Offer
                </div>
                <div class="panel-body">
                    <div class="row">

                        <div class="col-lg-5">

                                <div class="form-group">
                                    <meta name="new_title" />
                                    <label>Title</label>
                                    <input class="form-control" placaholder="title" data-bind="value: title" />
                                </div>
                                <div class="form-group">
                                    <meta name="new_description" />
                                    <label>Discription</label>
                                    <textarea class="form-control" rows="3" placaholder="Description" data-bind="value: description"
                                            style="height: 132px; width: 601px;"></textarea>
                                </div>
                                <label >Time</label>
                                <div class="form-group input-group">
                                    <meta name="new_time" />
                                    <input class="form-control" placaholder="time" data-bind="value: price"/>
                                    <span class="input-group-addon">$</span>
                                </div>
                                <div class="form-group">
                                    <label>File input</label>
                                    <meta name="new_file" />
                                    <input data-bind="event: { change: function() { changePhoto($element.files[0]) } }"
                                           class="upload-link-input" name="textbox" type="file" accept=".jpg,.jpeg,.gif" />

                                </div>

                                <p class="submit">
                                    <meta name="create_new_offer" />
                                    <a class="btn btn-primary" data-bind="click: create">Create</a>
                                </p>

                        </div>
                        <!-- /.row (nested) -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- Page-Level Demo Scripts - Forms - Use for reference -->
    </tiles:putAttribute>
</tiles:insertDefinition>