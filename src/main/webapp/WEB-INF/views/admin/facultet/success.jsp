<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../static/header.jsp"/>
<script>
    setTimeout('window.location.href = "list"', 1500);
</script>
<div class="bodyBlock">
    ${success}
    <br/>
    <br/>
    <a href="<c:url value='/facultet/' />">Назад до списку факультетів</a>
</div>
<jsp:include page="../../static/futter.jsp"/>



