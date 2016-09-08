<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../static/header.jsp"/>
<div class="bodyBlock">
    <h2 class="textAC">Редагування факультетів</h2>
    <table class="table table-bordered table-hover">
        <tr class="textAC">
            <td>Назва</td>
            <td>Скорочена назва</td>
            <td>Редагувати</td>
            <td>Видалити</td>
        </tr>
        <c:forEach items="${facultets}" var="facultets">
            <tr>
                <td>${facultets.name}</td>
                <td class="textAC">${facultets.shortFacName}</td>
                <td class="textAC"><a href="<c:url value='/facultet/edit-${facultets.id}-facultet' />"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
                <td class="textAC"><a href="<c:url value='/facultet/delete-${facultets.id}-facultet' />"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/facultet/new' />">Додати новий факультет</a>
</div>
<jsp:include page="../../static/futter.jsp"/>