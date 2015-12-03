<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>


<s:message code="answer.yes" var="yes"/>
<s:message code="answer.no" var="no"/>

<tiles:insertDefinition name="base.definition">
<tiles:putAttribute name="body">
<!--Adding jQuery rating plug-in-->
<script type="text/javascript" src="/resources/js/plugins/jquery.raty.js"></script>
<script src="/resources/js/pages/shop.js"></script>
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
                        <p class="btn btn-success">${yes}</p>

                        <p>
                        </p>

                        <p class="btn btn-danger">${no}</p>
                    </td>

                </tr>
                <tr>
                    <td style="width:100%">User</td>
                    <td>
                        <p class="btn btn-success">${yes}</p>

                        <p>
                        </p>

                        <p class="btn btn-danger">${no}</p>
                    </td>

                </tr>
                <tr>
                    <td style="width:100%">User</td>
                    <td>
                        <p class="btn btn-success">${yes}</p>

                        <p>
                        </p>

                        <p class="btn btn-danger">${no}</p>
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
            <h3 class="panel-title">My Offers</h3>
        </div>
        <div class="panel-body">


            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th></th>
                    <th>Title</th>
                    <th>Offer</th>
                    <th>Rating</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${not empty userOffers}">
                    <c:forEach var="offer" items="${userOffers}" varStatus="offerLoop">
                        <tr id="offer_${offer.id}" class="offer-in-table">
                            <td>${offerLoop.index +1}</td>
                            <td style="width:15%">${offer.title}</td>
                            <td style="width:35%">

                            <f:form method="post" action="/user/offers/edit" commandName='EditOfferForm' id="edit-form">
                                <div class="form-group">
                                    <textarea style="width:100%" class="form-control" name="description" rows="3">${offer.description}</textarea>
                                </div>
                            </td>

                            <td style="width:15%">
                                <div class="offerRatingFixed" data-score="5"></div>
                            </td>
                            <td style="width:35%">
                                <input style="display: none" hidden="true" value="${offer.id}" class="offerId">
                                    <input type="hidden" value="${offer.id}" name="id">
                                    <p class="submit">
                                        <input type="submit" name="commit" value="edit">
                                    </p>
                                    <%--<p class="btn btn-primary" style="margin-left:18%" >Save</p>
                                    --%>

                            </f:form>

                                <f:form method="post" action="/user/offers/delete" commandName='DeleteOfferForm' id="delete-form">
                                    <input type="hidden" value="${offer.id}" name="id">
                                    <p class="submit">
                                        <input type="submit" name="commit" value="delete">
                                    </p>
                                </f:form>

                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
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