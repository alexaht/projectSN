<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript">
    function doAjax() {

        var facultet = $("#facultet").val();

        $.ajax({
            url : '/showPlan/loadKafedra',
            dataType : 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            data : ({
                facultetId: facultet
            }),
            success: function (data) {
                $('#kafedra').empty();
                $('#kafedra').prop("disabled",false);
                function myfunc(item, index) {
                    $('#kafedra').append('<option value="' + item.id + '">' + item.name + '</option>');
                }
                data.forEach(myfunc);
            }
        });
    }
</script>
${sessionScope}
<div class="bodyBlock">
    <form:form cssClass="filterM" method="post" modelAttribute="learningYear">
        <div style="display: block;float: left;width:30%;">
            <label for="learningYear" style="width: 100%">Навчальний рік</label>
            <form:select name="learningYear" path="" id="learningYear"
                         cssStyle="width:250px; border-radius: 4px; padding: 4px; background: white">
                <c:forEach items="${learningYear}" var="learningYear">
                    <c:choose>
                        <c:when test="${learningYear.id == sessionScope.s_ly}">
                            <form:option selected="selected"
                                         value="${learningYear.id}">${learningYear.name}</form:option>
                        </c:when>
                        <c:otherwise>
                            <form:option value="${learningYear.id}">${learningYear.name}</form:option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        <div style="display: block; float: left; width:30%;">
            <label for="facultet" style="width: 100%">Факультет</label>
            <form:select name="facultet" path="" id="facultet" cssStyle="width: 250px" onchange="doAjax()">
                <form:option value="-1">Виберіть факультет</form:option>
                <c:forEach items="${facultet}" var="facultet">
                    <c:choose>
                        <c:when test="${facultet.id == sessionScope.s_facultet}">
                            <form:option selected="selected" value="${facultet.id}">${facultet.name}</form:option>
                        </c:when>
                        <c:otherwise>
                            <form:option value="${facultet.id}">${facultet.name}</form:option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select>
        </div>
        <div style="display: block; float: left;width:30%;">
            <label for="kafedra" style="width: 100%">Кафедра</label>
            <c:choose>
                <c:when test="${sessionScope.s_kafedra != null}">
                    <form:select path="" name="kafedra" id="kafedra" cssStyle="width: 250px;">
                        <c:forEach items="${kafedra}" var="kafedra">
                            <c:choose>
                                <c:when test="${kafedra.id == sessionScope.s_kafedra}">
                                    <form:option selected="selected" value="${kafedra.id}">${kafedra.name}</form:option>
                                </c:when>
                                <c:otherwise>
                                    <form:option value="${kafedra.id}">${kafedra.name}</form:option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </form:select>
                </c:when>
                <c:otherwise>
                    <form:select name="kafedra" path="" id="kafedra" disabled="true" cssStyle="width: 250px">
                    </form:select>
                </c:otherwise>
            </c:choose>
        </div>
    </form:form>
</div>
<div style="display: block;float: left; margin-left: 35px;width: 100%;">
    <button class="btn btn-primary" type="submit" style="margin: 5px;" form="learningYear">Застосувати</button>
</div>
<script type="text/javascript">
    $('#facultet').select2();
    $('#kafedra').select2();
</script>