<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<s:message code="menu.sellYourTime" var="sellYourTime"/>
<s:message code="menu.cabinet" var="cabinet"/>
<s:message code="menu.main" var="main"/>
<s:message code="menu.logOut" var="logOut"/>
<s:message code="menu.hello" var="hello"/>

<s:message code="home.message.sellYourTime" var="sellYourTime"/>

<footer style="background: url('/resources/img/banner-bg.jpg') no-repeat center center;">
    <style scoped="scoped">
        <c:set var="path"><s:theme code="styleSheet"/>
        </c:set>
        <c:import url="${path}"/>
        <%@include file='/resources/css/landing-page.css' %>
    </style>
    <div class="container" >
        <div class="row">
            <div class="col-lg-12">
                <ul class="list-inline">


                    <li><a href="/shop">${sellYourTime}</a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>

                    <sec:authorize ifNotGranted="ROLE_ADMIN,ROLE_ANONYMOUS" >
                    <li><a href="/user/offers"><sec:authentication
                            property="principal.user.name"/>
                        <b class="caret"></b></a>
                    </li>
                    </sec:authorize>
                    <sec:authorize ifAnyGranted="ROLE_ADMIN">
                        <li><a href="/admin/offers"><sec:authentication
                                property="principal.user.name"/>
                            <b class="caret"></b></a>
                        </li>
                    </sec:authorize>

                    <li class="footer-menu-divider">&sdot;</li>
                    <li><a href="/">${main}</a>
                    </li>
                    <li class="footer-menu-divider">&sdot;</li>

                    <li><a href="<c:url value="/logout"/>" style="margin-right: 40px;">${logOut}</a>
                    </li>
                </ul>
                <p class="copyright text-muted small">Create by <a href="http://vk.com/maxgergalov">Max Gergalov</a> ;
                    ${sellYourTime} 2014. All Rights Reserved</p>
            </div>
        </div>
    </div>
</footer>