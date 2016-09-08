<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../static/header.jsp"/>
<div class="bodyBlock">
    <form:form cssClass="formSize" method="post" modelAttribute="groupTbl">
        <form:input type="hidden" path="id" id="id"/>
        <div class="form-group">
            <label for="name">Назва групи</label>
            <form:input autofocus="true" path="name" id="name" cssClass="form-control" placeholder="Назва групи"/>
            <form:errors path="name" cssClass="validError"/>
        </div>
            <div class="form-group">
                <label for="facultet">Факультет</label>
                <form:select path="facultet.id" id="facultet" cssClass="form-control">
                    <form:option value="-1">Виберіть факультет</form:option>
                    <c:forEach items="${facultet}" var="facultet">
                        <form:option value="${facultet.id}">${facultet.name}</form:option>
                    </c:forEach>
                </form:select>
        </div>
        <div class="form-group">
            <label for="stAmount">Кількість студентів</label>
            <form:input path="stAmount" id="stAmount" cssClass="form-control" placeholder="Кількість студентів"/>
            <form:errors path="stAmount" cssClass="validError"/>
        </div>

        <div class="form-group">
            <label for="kurs">Курс</label>
            <form:input  path="kurs" id="kurs" cssClass="form-control" placeholder="Курс"/>
            <form:errors path="kurs" cssClass="validError"/>
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
    <a href="<c:url value='/group/list' />">Назад до списку факультетів</a>
</div>
<jsp:include page="../../static/futter.jsp"/>