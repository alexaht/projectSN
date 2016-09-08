<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../static/header.jsp"/>
<div class="bodyBlock">
    <h2 class="textAC">Редагування користувачів</h2>
    <table class="table table-bordered table-hover">
        <tr class="textAC">
            <td>Фамілія</td>
            <td>І'мя</td>
            <td>По батькові</td>
            <td>Пошта</td>
            <td>Редагувати</td>
            <td>Видалити</td>
        </tr>
        <c:forEach items="${users}" var="users">
            <tr>
                <td class="textAC">${users.lastName}</td>
                <td class="textAC">${users.firstName}</td>
                <td class="textAC">${users.otch}</td>
                <td class="textAC">${users.email}</td>
                <td class="textAC"><a href="<c:url value='/users/edit-${users.id}-users' />"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
                <td class="textAC"><a href="<c:url value='/users/delete-${users.id}-users' />"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/users/new' />">Додати нового користувача</a>
</div>
<jsp:include page="../../static/futter.jsp"/>