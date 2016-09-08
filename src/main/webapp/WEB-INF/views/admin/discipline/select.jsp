<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../../static/header.jsp"/>
<script type="text/javascript">
    function doAjax() {

        var facultet = $("#facultet select").val();

        $.ajax({
            url : '/discipline/loadKafedra',
            dataType : 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            data : ({
                facultetId: facultet
            }),
            success: function (data) {
                $('#kafedra select').empty();
                $('#kafedra select').prop("disabled",false);
               function myfunc(item, index) {
                   $('#kafedra select').append('<option value="' + item.id + '">' + item.name + '</option>');
               }
                data.forEach(myfunc);
            }
        });
    }
</script>
<div class="bodyBlock">
    <div>
    <form:form cssClass="formSize" method="post" modelAttribute="facultet">
            <div class="form-group">
                <label for="facultet">Факультет</label>
                <form:select name="facultet.id" path="" id="facultet" cssClass="form-control" onchange="doAjax()">
                    <form:option value="-1">Виберіть факультет</form:option>
                    <c:forEach items="${facultet}" var="facultet">
                        <form:option value="${facultet.id}">${facultet.name}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </form:form>
        <form:form cssClass="formSize" method="post" modelAttribute="kafedra">
            <div class="form-group">
                <label for="kafedra">Кафдера</label>
                <form:select disabled="true" name="kafedra.id" path="" id="kafedra" cssClass="form-control">
                </form:select>
            </div>
        <button class="btn btn-primary" type="submit">Застосувати</button>
    </form:form>
    </div>
    <br/>
    <a href="/discipline/list">До списку всіх кафедр</a>
</div>
${id}

<jsp:include page="../../static/futter.jsp"/>