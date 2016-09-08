<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../static/header.jsp"/>
<div class="bodyBlock">
    <form:form cssClass="formSize" method="post" modelAttribute="discipline">
        <form:input type="hidden" path="id" id="id"/>
        <div class="form-group">
            <label for="name">Назва дисципілни</label>
            <form:input autofocus="true" path="name" id="name" cssClass="form-control" placeholder="Назва дисципліни"/>
            <form:errors path="name" cssClass="validError"/>
        </div>
            <div class="form-group">
                <label for="name">Кафедра</label>
                <form:select path="kafedra.id" id="kafedra" cssClass="form-control">
                    <c:forEach items="${kafedra}" var="kafedra">
                        <c:choose>
                            <c:when test="${f_kafedra == kafedra.id}">
                                <form:option selected="selected" value="${kafedra.id}">${kafedra.name}</form:option>
                            </c:when>
                            <c:otherwise>
                                <form:option value="${kafedra.id}">${kafedra.name}</form:option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </form:select>
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
    <a href="<c:url value='/discipline/list' />">Назад до списку дисциплін</a>
    <br/>
    <a href="<c:url value='/discipline/select' />">Назад до вибору факультету та кафедри</a>
</div>
<jsp:include page="../../static/futter.jsp"/>