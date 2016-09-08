<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../static/header.jsp"/>
<div class="bodyBlock">
    <form:form cssClass="formSize" method="post" modelAttribute="user">
        <form:input type="hidden" path="id" id="id"/>
        <div class="form-group">
            <label for="lastName">Фамілія</label>
            <form:input autofocus="true" path="lastName" id="lastName" cssClass="form-control" placeholder="Фамілія"/>
            <form:errors path="lastName" cssClass="validError"/>
        </div>
        <div class="form-group">
            <label for="firstName">Ім'я</label>
            <form:input  path="firstName" id="firstName" cssClass="form-control" placeholder="Ім'я"/>
            <form:errors path="firstName" cssClass="validError"/>
        </div>
        <div class="form-group">
            <label for="otch">По батькові</label>
            <form:input  path="otch" id="otch" cssClass="form-control" placeholder="По батькові"/>
            <form:errors path="otch" cssClass="validError"/>
        </div>
        <div class="form-group">
            <label for="email">Пошта</label>
            <form:input  type="email" path="email" id="email" cssClass="form-control" placeholder="Пошта"/>
            <form:errors path="email" cssClass="validError"/>
        </div>
        <div class="form-group">
            <label for="password">Пароль</label>
            <form:input type="password" path="password" id="password" cssClass="form-control" placeholder="Пароль"/>
            <form:errors path="password" cssClass="validError"/>
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
    <a href="<c:url value='/users/' />">Назад до списку користувачів</a>
</div>
<jsp:include page="../../static/futter.jsp"/>