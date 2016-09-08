<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../static/header.jsp"/>
<script type="text/javascript">
    function doAjax() {

        var kafedra = $("#kafedra").val();

        $.ajax({
            url : '/createPlan/loadDiscipline',
            dataType : 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            data : ({
                kafedraId: kafedra
            }),
            success: function (data) {
                $('#discipline').empty();
                $('#discipline').prop("disabled",false);
                function myfunc(item, index) {
                    $('#discipline').append('<option value="' + item.id + '">' + item.name + '</option>');
                }
                data.forEach(myfunc);
            }
        });
    }
</script>
<div class="bodyBlock" style="margin: 5px; padding: 5px;">
    <form:form modelAttribute="planHistory" method="post">
        <div class="form-group" style="float: left;">
            <label for="kafedra" style="width: 100%">Кафедра:</label>
            <form:select path="" name="kafedra" id="kafedra" cssClass="form-control" cssStyle="width: 350px;" onchange="doAjax()">
                <form:option value="-1">Виберіть кафедру</form:option>
                <c:forEach items="${kafedra}" var="kafedra">
                    <form:option value="${kafedra.id}">${kafedra.name}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group" style="float: left;">
            <label for="discipline" style="width: 100%">Дисципліна:</label>
            <form:select path="" name="discipline.id" id="discipline" disabled="true" cssClass="form-control" cssStyle="width: 350px;">
            </form:select>
        </div>

    </form:form>
</div>
<script type="text/javascript">
    $('#kafedra').select2();
</script>
<jsp:include page="../../static/futter.jsp"/>