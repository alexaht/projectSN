<%@ page import="org.springframework.web.context.request.SessionScope" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../static/header.jsp"/>
<jsp:include page="filter.jsp"/>
<br />
<div class="outer">
    <div class="inner">
        <div class="bodyBlock">
            <table class="table table-bordered  table-hover table-condensed table_text table-striped" id="main_table" >
                <thead class="my_tr_back">
                <tr>
                    <td><strong>Шифр академ-груп</strong></td>
                    <td><strong>Кіл. студентів</strong></td>
                    <td><strong>Читання лекцій</strong></td>
                    <td><strong>Лаб. роб.</strong></td>
                    <td><strong>Практичні заняття</strong></td>
                    <td><strong>Консультації</strong></td>
                    <td><strong>КР</strong></td>
                    <td><strong>КРф/КП</strong></td>
                    <td><strong>КПф</strong></td>
                    <td><strong>Кр</strong></td>
                    <td><strong>Консультація з семестровго екзамену</strong></td>
                    <td><strong>Приймання екзаменів</strong></td>
                    <td><strong>Приймання заліків</strong></td>
                    <td><strong>Консультація з підсумкової атестації</strong></td>
                    <td><strong>Атестація</strong></td>
                    <td><strong>Керівництво, консультування, рецензування ДП</strong></td>
                    <td><strong>Проведення захисту ДП</strong></td>
                    <td><strong>Всього</strong></td>
                </tr>
                </thead>
                <tbody>
                <jsp:include page="tableResult.jsp"/>
                </tbody>
            </table>
        </div>
    </div>
</div>
<jsp:include page="../../static/futter.jsp"/>