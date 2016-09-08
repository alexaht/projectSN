<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../static/header.jsp"/>
<div class="bodyBlock">
    <h2 class="textAC">Редагування кафедр</h2>
    <table class="table table-bordered table-hover">
        <tr class="textAC">
            <td>Назва</td>
            <td>Факультет</td>
            <td>Пошта</td>
            <td>Скорочена назва</td>
            <td>Порядковий номер</td>
            <td>Редагувати</td>
            <td>Видалити</td>
        </tr>
        <c:forEach items="${kafedra}" var="kafedra">
            <tr>
                <td>${kafedra.name}</td>
                <td>${kafedra.facultet.name}</td>
                <td class="textAC">${kafedra.email}</td>
                <td class="textAC">${kafedra.shortKafName}</td>
                <td class="textAC">${kafedra.pn}</td>
                <td class="textAC"><a href="<c:url value='/kafedra/edit-${kafedra.id}-kafedra' />"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
                <td class="textAC"><a href="<c:url value='/kafedra/delete-${kafedra.id}-kafedra' />"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
            </tr>

        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/kafedra/new' />">Додати нову кафедру</a>
    <br/>
    <a href="<c:url value='/kafedra/select' />">Повернутись до вибору факультету</a>
</div>

<jsp:include page="../../static/futter.jsp"/>