<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="bodyBlock">
    <form:form  cssClass="filterM" method="post" modelAttribute="learningYear">
        <div style="display: block;float: left;width:30%;margin-right: 25px;">
            <label for="learningYear" style="width: 100%" >Навчальний рік</label>
            <form:select name="learningYear" path="" id="learningYear" cssStyle="width:250px; border-radius: 4px; padding: 4px; background: white">
                <c:forEach items="${learningYear}" var="learningYear">
                    <c:choose>
                        <c:when test="${learningYear.id == sessionScope.s_ly}">
                            <form:option selected="selected" value="${learningYear.id}">${learningYear.name}</form:option>
                        </c:when>
                        <c:otherwise>
                        <form:option value="${learningYear.id}">${learningYear.name}</form:option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        <div style="display: block; float: left;">
            <label for="groupTbl" style="width: 100%">Група</label>
            <form:select name="groupTbl" path="" id="groupTbl" cssStyle="width: 250px">
                <c:forEach items="${groupTbl}" var="groupTbl">
                    <c:choose>
                        <c:when test="${groupTbl.id == sessionScope.s_gr}">
                            <form:option selected="selected" value="${groupTbl.id}">${groupTbl.name}</form:option>
                        </c:when>
                        <c:otherwise>
                            <form:option value="${groupTbl.id}">${groupTbl.name}</form:option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
    </form:form>
</div>
<div style="display: block;float: left; margin-left: 35px;width: 100%;">
   <button class="btn btn-primary" type="submit" style="margin: 5px;" form="learningYear">Застосувати</button>
</div>
<script type="text/javascript">
    $('#groupTbl').select2();
</script>
