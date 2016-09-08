<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../static/header.jsp"/>
<div class="bodyBlock">
    <form:form cssClass="formSize" method="post" modelAttribute="facultet">
        <div class="form-group">
            <label for="facultet">Факультет</label>
            <form:select name="facultet.id" path="" id="facultet" cssClass="form-control" placeholder="Назва факультету">
                <form:option value="-1">Виберіть факультет</form:option>
                <c:forEach items="${facultet}" var="facultet">
                    <form:option value="${facultet.id}">${facultet.name}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <button class="btn btn-primary" type="submit">Застосувати</button>
    </form:form>
    <br/>
    <a href="/kafedra/list">До списку всіх кафедр</a>
</div>
<jsp:include page="../../static/futter.jsp"/>