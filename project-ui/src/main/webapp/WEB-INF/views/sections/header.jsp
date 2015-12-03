<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<title><s:message code="label.title"/></title>

<meta charset="UTF-8"/>
<meta name="site_name" content="Sell your time here!.">
<meta name="author" content="Gergalov Maxim">
<meta name="create_year" content="2014">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
    <c:set var="path"><s:theme code="styleSheet"/>
    </c:set>
    <c:import url="${path}"/>
    <%@include file='/resources/font-awesome/css/font-awesome.min.css' %>
    <%@include file='/resources/css/landing-page.css' %>
    <%@include file='/resources/css/googleapis.css' %>
</style>
<!--Adding jQuery library -->

