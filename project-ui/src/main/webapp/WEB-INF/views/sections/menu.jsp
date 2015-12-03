<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<s:message code="input.placaholder.mail" var="mailPlaceHolder"/>
<s:message code="input.placaholder.name" var="namePlaceHolder"/>
<s:message code="input.placaholder.phone" var="phonePlaceHolder"/>
<s:message code="input.placaholder.password" var="passwordPlaceHolder"/>
<s:message code="input.placaholder.confirmition.password" var="cPasswordPlaceHolder"/>
<s:message code="input.message.imputPassword" var="imputPassword"/>
<s:message code="form.register.title" var="formTitle"/>

<s:message code="home.message.sellYourTime" var="siteName"/>

<s:message code="menu.sellYourTime" var="sellYourTime"/>
<s:message code="menu.cabinet" var="cabinet"/>
<s:message code="menu.logOut" var="logOut"/>
<s:message code="menu.main" var="main"/>
<s:message code="menu.hello" var="hello"/>

<body>

<script type="text/javascript" src="/resources/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/knockout-3.1.0.js"></script>

<link rel="shortcut icon" href="/resources/favicon.ico">

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <style scoped="scoped">
        <c:set var="path"><s:theme code="styleSheet"/>
        </c:set>
        <c:import url="${path}"/>
        <%@include file='/resources/css/landing-page.css' %>
    </style>
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/shop">${siteName}</a>
        </div>

        <div class="collapse navbar-collapse navbar-right navbar-ex1-collapse">

            <ul class="nav navbar-nav">
                <li><a href="/shop">${siteName}</a>
                </li>
                <sec:authorize ifNotGranted="ROLE_ADMIN,ROLE_ANONYMOUS">
                    <li><a href="/user/offers" ><sec:authentication
                            property="principal.user.name"/>
                        <b class="caret"></b></a>
                    </li>
                </sec:authorize>
                <sec:authorize ifAnyGranted="ROLE_ADMIN">
                    <li><a href="/admin/tasks"><sec:authentication
                            property="principal.user.name"/>
                        <b class="caret"></b></a>
                    </li>
                </sec:authorize>
                <li>
                    <a href="/">${main}</a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Settings <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${requestScope['javax.servlet.forward.request_uri']}?theme=dark">
                            <img src="/resources/img/dark.png">Dark theme</a>
                        </li>
                        <li><a href="${requestScope['javax.servlet.forward.request_uri']}?theme=white">
                            <img src="/resources/img/white.png">Light theme</a>
                        </li>
                        <li><a href="${requestScope['javax.servlet.forward.request_uri']}?language=ru">
                            <img src="/resources/img/ru.png">Russian</a>
                        </li>
                        <li><a href="${requestScope['javax.servlet.forward.request_uri']}?language=en">
                            <img src="/resources/img/en.png">English</a>
                        </li>

                        <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_USER">
                        <li class="divider"></li>
                        <li><a href="/logout">${logOut}</a>
                        </li>
                        </sec:authorize>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

</nav>