<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../static/header.jsp"/>
<div class="bodyBlock">
    <form:form cssClass="formSize" method="post" modelAttribute="facultet">
        <form:input type="hidden" path="id" id="id"/>
        <div class="form-group">
            <label for="name">Назва факультету </label>
            <form:input autofocus="true" path="name" id="name" cssClass="form-control" placeholder="Назва факультету"/>
            <form:errors path="name" cssClass="validError"/>
        </div>
        <div class="form-group">
            <label for="shortFacName">Скорочена назва факультету: </label>
            <form:input  path="shortFacName" id="shortFacName" cssClass="form-control" placeholder="Скорочена назва факультету"/>
            <form:errors path="shortFacName" cssClass="validError"/>
        </div>

                    <c:choose>
                        <c:when test="${edit}">
                            <input class="btn btn-primary" type="submit" value="Оновити"/>
                        </c:when>
                        <c:otherwise>
                            <input class="btn btn-primary" type="submit" value="Додати"/>
                        </c:otherwise>
                    </c:choose>


    </form:form>
    <br/>
    <a href="<c:url value='/facultet/' />">Назад до списку факультетів</a>
</div>
<jsp:include page="../../static/futter.jsp"/>