<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../static/header.jsp"/>
<div class="bodyBlock">
    <h2 class="textAC">Редагування навчальних років</h2>
    <table class="table table-bordered table-hover">
        <tr class="textAC">
            <td>Назва навчального року</td>
            <td>Початок</td>
            <td>Кінець</td>
            <td>Поточний</td>
            <td>Редагувати</td>
            <td>Видалити</td>
        </tr>
                   <c:forEach items="${learningYear}" var="learningYear">
                <tr>
                    <td class="textAC">${learningYear.name}</td>
                    <td class="textAC">${learningYear.beginYear}</td>
                    <td class="textAC">${learningYear.endYear}</td>
                    <td class="textAC">${learningYear.current}</td>
                    <td class="textAC"><a href="<c:url value='/ly/edit-${learningYear.id}-ly' />"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
                    <td class="textAC"><a href="<c:url value='/ly/delete-${learningYear.id}-ly' />"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
                </tr>
            </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/ly/new' />">Додати новий навчальний рік</a>
</div>
<jsp:include page="../../static/futter.jsp"/>