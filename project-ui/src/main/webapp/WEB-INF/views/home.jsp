<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<s:message code="home.message.pleaseSignIn" var="pleaseSignIn"/>
<s:message code="home.message.sellYourTime" var="sellYourTime"/>
<s:message code="home.message.rememberMe" var="rememberMe"/>
<s:message code="home.message.registration" var="registration"/>
<s:message code="input.placaholder.mail" var="mailPlaceHolder"/>
<s:message code="input.placaholder.password" var="passwordPlaceHolder"/>

<tiles:insertDefinition name="base.definition">
    <tiles:putAttribute name="body">
        <style>
            <%@include file='/resources/css/white.css' %>
            <%@include file='/resources/font-awesome/css/font-awesome.min.css' %>
            <%@include file='/resources/css/landing-page.css' %>
            <%@include file='/resources/css/googleapis.css' %>
        </style>
        <div class="intro-header" style="background: url('/resources/img/intro-bg.jpg')">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-message" style="padding-top: 10%;padding-bottom: 0px;">
                            <meta name="site_name" />
                            <h1 >${sellYourTime}</h1>

                            <sec:authorize ifNotGranted="ROLE_USER,ROLE_ADMIN" >
                            <div class="login-panel panel panel-default" style="width: 30%; margin-left: 35%;
                                                                        margin-bottom: 0px; background: rgba(255, 255, 255, 0)">
                                <div class="panel-heading"
                                     style="color: #FFF; background-color: rgba(150, 255, 171, 0.5)">
                                    <meta name="panel_title" />
                                    <h3 class="panel-title">${pleaseSignIn}</h3>
                                </div>
                                <div class="panel-body">

                                    <form role="form" action='<c:url value="/j_spring_security_check"></c:url>'
                                          method="post">
                                        <meta name="user_credentials" />
                                        <fieldset>
                                            <div class="form-group">
                                                <meta name="user_email" />
                                                <input class="form-control" placeholder="${mailPlaceHolder}" name="j_username"
                                                       type="email"
                                                       autofocus>
                                            </div>
                                            <div class="form-group">
                                                <meta name="user_password" />
                                                <input class="form-control" placeholder="${passwordPlaceHolder}" name="j_password"
                                                       type="password" value="">
                                            </div>
                                            <%--<div class="checkbox">
                                                <label>
                                                    <input name="_spring_security_remember_me" type="checkbox"
                                                           value="Remember Me">${rememberMe}
                                                </label>
                                            </div>--%>
                                            <!-- Change this to a button or input when using this as a form -->
                                            <button value="Login" class="btn btn-lg btn-success btn-block"
                                                    type="submit">Login
                                            </button>
                                            <row>
                                                <a href="/registration" class="btn">${registration}</a>
                                            </row>
                                        </fieldset>
                                    </form>
                                </div>
                            </div>
                            </sec:authorize>

                            <sec:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN" >
                                <p>Thank you for using our service, <sec:authentication
                                        property="principal.user.name"/> </p>
                                <p></p>
                                <a class="btn btn-primary" target="_blank" href="/logout">Log out</a>
                            </sec:authorize>

                            <hr class="intro-divider">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="content-section-a">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5 col-sm-6">
                        <hr class="section-heading-spacer">
                        <div class="clearfix"></div>
                        <h2 class="section-heading">Leave your request or will respond to someone else.
                        </h2>

                        <p class="lead">Choose! confirmed! Enjoy!</p>
                    </div>
                    <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                        <img class="img-responsive" src="/resources/img/ipad.png" alt="">
                    </div>
                </div>
            </div>


        </div>

        <div class="content-section-b">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
                        <hr class="section-heading-spacer">
                        <div class="clearfix"></div>
                        <h2 class="section-heading">Go to the movies or stay home?</h2>

                        <p class="lead">Just 10 minutes and you'll find something to do for the evening ..
                            or night =)</p>
                    </div>
                    <div class="col-lg-5 col-sm-pull-6  col-sm-6">
                        <img class="img-responsive" src="/resources/img/doge.png" alt="">
                    </div>
                </div>
            </div>
        </div>

        <div class="content-section-a">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5 col-sm-6">
                        <hr class="section-heading-spacer">
                        <div class="clearfix"></div>
                        <h2 class="section-heading">You choose with whom and
                            how to spend your time</h2>

                        <p class="lead">You can sell your time to even walk your dog with someone, or sleeping with him
                            or her
                            on the couch</p>
                    </div>
                    <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                        <img class="img-responsive" src="/resources/img/phones.png" alt="">
                    </div>
                    <a class="btn btn-primary" target="_blank" href="javascript:scroll(0,0);" style="margin-left: 48%">To top</a>
                </div>
            </div>
        </div>


        <script>
            var Page = function(model){
                var self = this;
                self.name = ko.observable(model.name);
            }

            $(function(){
                var model = {
                    name : 'vasa'
                };
                var vm = new Page(model);
                ko.applyBindings(vm);
            })

        </script>
    </tiles:putAttribute>
</tiles:insertDefinition>
