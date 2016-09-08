<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../static/header.jsp"/>
<div class="bodyBlock">
    <form:form cssClass="formSize" method="post" modelAttribute="kafedra">
        <form:input type="hidden" path="id" id="id"/>
        <div class="form-group">
            <label for="name">Назва кафедри</label>
            <form:input autofocus="true" path="name" id="name" cssClass="form-control" placeholder="Назва кафедри"/>
            <form:errors path="name" cssClass="validError"/>
        </div>
            <div class="form-group">
                <label for="name">Факультет</label>
                <form:select path="facultet.id" id="facultet" cssClass="form-control" placeholder="Назва факультету">
                    <c:forEach items="${facultet}" var="facultet">
                        <c:choose>
                            <c:when test="${f_kaf_facultet == facultet.id}">
                                <form:option selected="selected" value="${facultet.id}">${facultet.name}</form:option>
                            </c:when>
                            <c:otherwise>
                                <form:option value="${facultet.id}">${facultet.name}</form:option>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </form:select>
        </div>
        <div class="form-group">
            <label for="name">Пошта</label>
            <form:input path="email" id="email" cssClass="form-control" placeholder="knutd@knutd.com.ua"/>
            <form:errors path="email" cssClass="validError"/>
        </div>

        <div class="form-group">
            <label for="shortKafName">Скорочена назва факультету: </label>
            <form:input  path="shortKafName" id="shortKafName" cssClass="form-control" placeholder="Скорочена назва кафедри"/>
            <form:errors path="shortKafName" cssClass="validError"/>
        </div>
        <div class="form-group">
            <label for="name">Порядковий номер</label>
            <form:input path="pn" id="pn" cssClass="form-control" placeholder="Порядковий номер"/>
            <form:errors path="pn" cssClass="validError"/>
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
    <a href="<c:url value='/kafedra/list' />">Назад до списку кафедр</a>
    <br/>
    <a href="<c:url value='/kafedra/select' />">Назад до вибору факультету</a>
</div>
<jsp:include page="../../static/futter.jsp"/>