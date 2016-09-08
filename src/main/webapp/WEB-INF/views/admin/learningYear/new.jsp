<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../static/header.jsp"/>
<div class="bodyBlock">
    <form:form cssClass="formSize" method="post" modelAttribute="learningYear">
        <form:input type="hidden" path="id" id="id"/>
        <div class="form-group">
            <label for="name">Назва навчального року</label>
            <form:input autofocus="true" path="name" id="name" cssClass="form-control" placeholder="Назва навчального року - 2015/2016"/>
            <form:errors path="name" cssClass="validError"/>
        </div>
        <div class="form-group">
            <label for="beginYear">Початок</label>
            <form:input  path="beginYear" id="beginYear" cssClass="form-control" placeholder="2015"/>
            <form:errors path="beginYear" cssClass="validError"/>
        </div>
        <div class="form-group">
            <label for="endYear">Кінець</label>
            <form:input  path="endYear" id="endYear" cssClass="form-control" placeholder="2016"/>
            <form:errors path="endYear" cssClass="validError"/>
        </div>
        <div class="form-group">
            <label for="current">Поточний</label>
            <form:input  path="current" id="current" cssClass="form-control" placeholder="1 чи 0 ( 1 - поточний)"/>
            <form:errors path="current" cssClass="validError"/>
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
    <a href="<c:url value='/ly/' />">Назад до списку користувачів</a>
</div>
<jsp:include page="../../static/futter.jsp"/>