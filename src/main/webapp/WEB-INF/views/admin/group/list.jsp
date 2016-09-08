<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../static/header.jsp"/>
<div class="bodyBlock">
    <h2 class="textAC">Редагування груп</h2>
    <table class="table table-bordered table-hover">
        <tr class="textAC">
            <td>Назва</td>
            <td>Факультет</td>
            <td>Кількість студентів</td>
            <td>Курс</td>
            <td>Редагувати</td>
            <td>Видалити</td>
        </tr>
        <c:forEach items="${groupTbl}" var="groupTbl">
            <tr>
                <td>${groupTbl.name}</td>
                <td>${groupTbl.facultet.name}</td>
                <td class="textAC">${groupTbl.stAmount}</td>
                <td class="textAC">${groupTbl.kurs}</td>
                <td class="textAC"><a href="<c:url value='/group/edit-${groupTbl.id}-group' />"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
                <td class="textAC"><a href="<c:url value='/group/delete-${groupTbl.id}-group' />"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
            </tr>

        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/group/new' />">Додати нову групу</a>
</div>

<jsp:include page="../../static/futter.jsp"/>