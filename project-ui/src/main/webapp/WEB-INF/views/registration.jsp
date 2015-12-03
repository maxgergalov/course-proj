<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


<tiles:insertDefinition name="base.definition">
    <tiles:putAttribute name="body">
        <style scoped="scoped">
            <%@include file='/resources/css/style.css' %>
        </style>
        <div  class="intro-header" style="background: url('/resources/img/intro-bg.jpg');background-size: cover; " >
            <div scoped class="container" style="margin-top: 8%; " >
                <section class="register">
                    <h1>${formTitle}</h1>
                    <f:form method="post" action="/registration/create" commandName='registrationForm'
                            id="registration-form">
                        <div class="reg_section personal_info">
                            <p><f:input path="mail" placeholder="${mailPlaceHolder}" /></p>
                            <p><f:errors path="mail" cssStyle="color: rgb(43, 112, 84);"/></p>

                            <p> <f:input path="name" placeholder="${namePlaceHolder} "/></p>
                            <p><f:errors path="name" cssStyle="color: rgb(43, 112, 84);"/></p>
                            <p> <f:input path="phone" placeholder="${phonePlaceHolder}"/></p>
                        </div>
                        <div class="reg_section password">
                        <p><h3 style="color: rgb(54, 90, 59)">${imputPassword}</h3></p>
                        <p> <f:input path="password" placeholder="${passwordPlaceHolder}"/></p>
                            <p><f:errors path="password" cssStyle="color: rgb(43, 112, 84);"/></p>
                        <p><f:input path="confirmationPassword" placeholder="${cPasswordPlaceHolder}"/></p>
                            <p><f:errors path="confirmationPassword" cssStyle="color: rgb(43, 112, 84);"/></p>
                        </div>
                        <p class="submit">
                            <input type="submit" name="commit" value="${formTitle}">
                        </p>
                        <input type="hidden" name="action" value="registration">
                    </f:form>
                </section>
            </div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>