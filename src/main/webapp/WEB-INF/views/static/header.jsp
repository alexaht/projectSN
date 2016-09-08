<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>${title}</title>

    <!-- JQuery -->
    <script src="<c:url value="/resources/jquery-3.1.0.min.js"/>"></script>

    <!-- Bootstrap -->
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" media="screen">
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.js"/> "></script>

    <!-- Select2 -->
    <link href="<c:url value="/resources/select/css/select2.min.css"/>" rel="stylesheet">
    <script src="<c:url value="/resources/select/js/select2.min.js"/>"></script>


    <link href="<c:url value="/resources/main.css"/>" rel="stylesheet" media="screen">
    <link href="/resources/favicon.ico" rel="icon" type="image/x-icon">
</head>
<body>
<jsp:include page="topMenu.jsp"/>