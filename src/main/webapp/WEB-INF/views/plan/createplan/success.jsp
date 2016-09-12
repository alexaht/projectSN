<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../static/header.jsp"/>
<script>
    setTimeout('window.location.href = "/createPlan/select"', 1500);
</script>
<div class="bodyBlock">
    <%--${success}--%>
     Перенаправлення
    <br/>
    <br/>
    <a href="<c:url value='/createPlan/select' />">Назад до редагування плану навантаження</a>
</div>
<jsp:include page="../../static/futter.jsp"/>



