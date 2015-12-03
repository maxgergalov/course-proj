<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="base.definition">
    <tiles:putAttribute name="body">
        <!--Adding jQuery rating plug-in-->
        <script type="text/javascript" src="/resources/js/plugins/jquery.raty.js"></script>
        <script src="/resources/js/pages/shop.js"></script>

        <script type="text/javascript" src="/resources/js/test.js"></script>


        <div class="container" style="margin-top: 5%;">
            <div class="row">
                    <%--<div class="col-md-3">

                        <div class="list-group">
                            <p class="list-group-item text-center">Top 5 users</p>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>like</th>
                                    <th>dislike</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${not empty topUsers}">
                                    <c:forEach var="userStatistic" items="${topUsers}" varStatus="userStatisticLoop">
                                        <tr>
                                            <td>${userStatisticLoop.index +1}</td>
                                            <td>${userStatistic.user.name}</td>
                                            <td>${userStatistic.likes}</td>
                                            <td>${userStatistic.dislikes}</td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                </tbody>
                            </table>
                            <hr>
                            <p class="list-group-item text-center" style="">Top 5 Offers</p>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Offer</th>
                                    <th>User</th>
                                    <th>Rating</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${not empty topOffers}">
                                    <c:forEach var="offerStatistic" items="${topOffers}" varStatus="offerStatisticLoop">
                                        <tr>
                                            <td>${offerStatisticLoop.index +1}</td>
                                            <td><a href="/item/${offerStatistic.offer.id}">${offerStatistic.offer.title}</a></td>
                                            <td>${offerStatistic.offer.userId}</td>
                                            <td><div class="offerRatingFixed" data-score="${offerStatistic.rating}"></div></td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                </tbody>
                            </table>
                            <hr>
                        </div>
                    </div>--%>

                <div class="col-md-9">
                    <div class="row">
                        <span data-bind="foreach: lastOffers">
                            <meta name="last_offers" />
                                <div class="col-sm-4 col-lg-4 col-md-4">

                                    <div class="thumbnail" >
                                       <a data-bind="attr : { href : '/item/' + id }">
                                           <img data-bind="attr : { src : mainImageUrl }"  alt="" >
                                       </a>
                                        <div class="caption">

                                            <p class="pull-right"><meta name="price" /><text data-bind="text: price"></text> hours</p>
                                            <a data-bind="attr: {href : '/item/' + id }">
                                                <meta name="title" />
                                                <p data-bind="text: title"></p>
                                            </a>
                                            <p data-bind="text: description" data-max-length="100"><meta name="description" /></p>
                                        </div>
                                        <div class="ratings">
                                            <p class="pull-right"><meta name="comments_count" /><text data-bind="text: commentsCount"></text> comments</p>

                                            <%--&lt;%&ndash;<c:if test="${not empty lastOffers}">
                                            <c:forEach var="offerDescriptions" items="${lastOffers}">
                                              <p>
                                                <div class="offerRatingFixed" data-bind="text: rating"></div>
                                              </p>
                                            </c:forEach>
                                            </c:if>--%>

                                            <p>
                                                <div >read more...</div>
                                            </p>
                                        </div>
                                    </div>

                            </div>
                             </span>
                        <div class="col-sm-4 col-lg-4 col-md-4">

                            <sec:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN" >
                                <p>Thank you for using our service, <sec:authentication
                                        property="principal.user.name"/> </p>
                                <p></p>
                                <a class="btn btn-primary" target="_blank" href="/createOffer" style="margin-bottom: 20px;">Create Offer</a>
                            </sec:authorize>

                            <sec:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN" >
                                <p>If you wonna create offer, you need to <a target="_blank"href="/">Log In
                                </a>  on our service or <a target="_blank" href="/registration"> Registration</a>  on it..</p>
                            </sec:authorize>

                        </div>
                    </div>
                </div>

            </div>

        </div>
        <!-- /.container -->
    </tiles:putAttribute>
</tiles:insertDefinition>