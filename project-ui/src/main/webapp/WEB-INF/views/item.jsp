<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<tiles:insertDefinition name="base.definition">
    <tiles:putAttribute name="body">
        <div class="container">
            <style scoped="scoped">
                <%@include file='/resources/css/white.css' %>
                <%@include file='/resources/css/shop-item.css' %>
                .offerRating img,.offerRatingFixed img {
                    width: auto !important;
                }
            </style>
            <!--Adding jQuery rating plug-in-->
            <script type="text/javascript" src="/resources/js/plugins/jquery.raty.js"></script>
            <script src="/resources/js/pages/shop.js"></script>

            <div class="row">

                <div class="col-md-9">
                    <div class="thumbnail">
                        <meta name="offer_id" />
                        <input hidden="true" style="display: none" id="offerId" value="${offerDescription.offer.id}"/>
                        <img class="img-responsive" src="${offerDescription.imageUrl}" alt="">

                        <div class="caption-full">
                            <meta name="offer_price" />
                            <h4 class="pull-right">${offerDescription.offer.price} hours</h4>
                            <h4><a>${offerDescription.offer.title}</a>
                            </h4>
                                ${offerDescription.offer.description}
                            <p></p>
                            <p class="btn btn-block btn-lg btn-primary text-muted"
                               style="width:200px" onclick="makeDeal(${offerDescription.offer.id});"> Take the job </p>
                        </div>
                        <div class="ratings">
                            <meta name="rating" />
                            <c:if test="${not empty offerDescription.comments}">
                                <p class="pull-right">${fn:length(offerDescription.comments)} reviews</p>
                            </c:if>
                            <p>
                            <security:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN" >
                                     <div class="offerRating" data-score="${offerDescription.rating}"></div>
                            </security:authorize>
                            <security:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN" >
                                <div class="offerRatingFixed" data-score="4"></div>
                            </security:authorize>
                            </p>
                        </div>
                    </div>
                    <div class="well">

                        <security:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN" >
                            <textarea style="width: 100%"></textarea>
                            <div class="text-right">
                                <a class="btn btn-success">Leave a Comment</a>
                            </div>
                        </security:authorize>
                        <security:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN" >
                            <p>If you wonna comment, you need to <a target="_blank"href="/">Log In
                            </a>  on our service or <a target="_blank" href="/registration"> Registration</a>  on it..</p>
                        </security:authorize>






                        <hr>
                        <c:if test="${not empty offerDescription.comments}">
                            <c:forEach var="comment" items="${offerDescription.comments}">
                                <div class="row">
                                    <div class="col-md-12">
                                        <meta name="comment_description" />
                                        name${comment.userId}
                                        <span class="pull-right">${comment.creationDate}</span>
                                        <p>${comment.description}</p>
                                    </div>
                                </div>
                                <hr>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>