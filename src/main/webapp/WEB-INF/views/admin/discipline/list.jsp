<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../static/header.jsp"/>

<div class="bodyBlock">
    <h2 class="textAC">Редагування дисциплін</h2>
    <table class="table table-bordered table-hover">
        <tr class="textAC">
            <td>Назва дисципліни</td>
            <td>Кафедра</td>
            <td>Редагувати</td>
            <td>Видалити</td>
        </tr>
        <c:forEach items="${discipline}" var="discipline">
            <tr>
                <td class="textAC">${discipline.name}</td>
                <td class="textAC">${discipline.kafedra.name}</td>
                <td class="textAC"><a href="<c:url value='/discipline/edit-${discipline.id}-discipline' />"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
                <td class="textAC"><a href="<c:url value='/discipline/delete-${discipline.id}-discipline' />"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
            </tr>

        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/discipline/new' />">Додати нову дисципліну</a>
    <br/>
    <a href="<c:url value='/discipline/select' />">Повернутись до вибору дисципліни</a>
</div>

<jsp:include page="../../static/futter.jsp"/>