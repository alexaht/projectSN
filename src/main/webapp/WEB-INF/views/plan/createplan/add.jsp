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
        <div class="fl_left">
            <div class="form-group">
                <label for="kafedra">Кафедра:</label>
                <form:select path="idKafedra" name="kafedra" id="kafedra" cssClass="form-control" onchange="doAjax()">
                    <form:option value="-1">Виберіть кафедру</form:option>
                    <c:forEach items="${kafedra}" var="kafedra">
                        <form:option value="${kafedra.id}">${kafedra.name}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group">
                <label for="discipline">Дисципліна:</label>
                <form:select path="idDiscipline" name="discipline.id" id="discipline" disabled="true" cssClass="form-control">
                </form:select>
            </div>
            <form:input type="hidden" path="id" id="id"/>
            <form:input type="hidden" path="idYear" id="idYear" value="${sessionScope.learningYear}"/>
            <form:input type="hidden" path="idGruppa" id="idGruppa" value="${sessionScope.groupTbl}"/>
        </div>
        <table class="table table-bordered table-hover table-condensed table_text table-striped" id="main_table">
        <thead class="my_tr_back" style="width: 100%;">
        <tr>

            <td rowspan="2" style="border-right: 1px solid #000000;">
                <svg width="12" height="400" class="svg-text">
                    <text x="-400" y="10" font-family="Arial" font-size="14" transform='rotate(-90)'>Кількість аудиторних годин за планом стаціонару</text>
                </svg></td>
            <td style="width:20px;border-right: 1px solid #000000;"> <strong>Настановна сесія</strong></td>
            <td colspan="15" style="border-right: 1px solid #000000;"> <strong>Зимова сесія</strong> </td>
            <td colspan="15" style="border-right: 1px solid #000000;"><strong>Літня сесія</strong> </td>
        </tr>
        <tr>
            <td class="vertical" style="border-right: 1px solid #000000;">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Консультації</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Лекції</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Лабораторні роботи</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Практичні роботи</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'> Консультації</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Курсова робота</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>КРф/КП</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>КПф</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Контрольна робота</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Консультація з семестрового екзамену</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Екзамен</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Залік</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Консультація з підсумкової атестації (комплексний екзамен з фаху)</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Атестація (комплексний екзамен з фаху)</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Керівництво, консультування, та рецензування дипломних проектів (робіт)</text>
                </svg>
            </td>
            <td class="vertical" style="border-right: 1px solid #000000;">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Проведення захисту дипломних робіт (проектів)</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Лекції</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Лабораторні роботи</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Практичні роботи</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Консультації</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Курсова робота</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>КРф/КП</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>КПф</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Контрольна робота</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Консультація з семестрового екзамену</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Екзамен</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Залік</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Консультація з підсумкової атестації (комплексний екзамен з фаху)</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Атестація (комплексний екзамен з фаху)</text>
                </svg>
            </td>
            <td class="vertical">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Керівництво, консультування, та рецензування дипломних проектів (робіт)</text>
                </svg>
            </td>
            <td class="vertical" style="border-right: 1px solid #000000;">
                <svg width="12" height="350" class="svg-text">
                    <text x="-350" y="10" font-family="Arial" font-size="10" transform='rotate(-90)'>Проведення захисту дипломних робіт (проектів)</text>
                </svg>
            </td>
        </tr>
        </thead>
        <tbody>
            <tr>

                <!-- -->
                <td>
                    <form:input path="nPlan" id="nPlan" cssClass="sm_input"/>
                </td>
                <td><form:input path="nConsult" id="nConsult" cssClass="sm_input"/></td>

                <td><form:input path="zLesson" id="zLesson" cssClass="sm_input"/></td>
                <td><form:input path="zLab" id="zLab" cssClass="sm_input"/></td>
                <td><form:input path="zPractice" id="zPractice" cssClass="sm_input"/></td>
                <td><form:input path="zConsult" id="zConsult" cssClass="sm_input"/></td>
                <td><form:input path="zKursWork" id="zKursWork" cssClass="sm_input"/></td>
                <td><form:input path="zKursWorkIngFah" id="zKursWorkIngFah" cssClass="sm_input"/></td>
                <td><form:input path="zKursWorkFah" id="zKursWorkFah" cssClass="sm_input"/></td>
                <td><form:input path="zControlWork" id="zControlWork" cssClass="sm_input"/></td>
                <td><form:input path="zCce" id="zCce" cssClass="sm_input"/></td>
                <td><form:input path="zExam" id="zExam" cssClass="sm_input"/></td>
                <td><form:input path="zZalik" id="zZalik" cssClass="sm_input"/></td>
                <td><form:input path="zCpa" id="zCpa" cssClass="sm_input"/></td>
                <td><form:input path="zAtest" id="zAtest" cssClass="sm_input"/></td>
                <td><form:input path="zCcrDp" id="zCcrDp" cssClass="sm_input"/></td>
                <td><form:input path="zPzdp" id="zPzdp" cssClass="sm_input"/></td>
                <!-- -->
                <td><form:input path="sLesson" id="sLesson" cssClass="sm_input"/></td>
                <td><form:input path="sLab" id="sLab" cssClass="sm_input"/></td>
                <td><form:input path="sPractice" id="sPractice" cssClass="sm_input"/></td>
                <td><form:input path="sConsult" id="sConsult" cssClass="sm_input"/></td>
                <td><form:input path="sKursWork" id="sKursWork" cssClass="sm_input"/></td>
                <td><form:input path="sKursWorkIngFah" id="sKursWorkIngFah" cssClass="sm_input"/></td>
                <td><form:input path="sKursWorkFah" id="sKursWorkFah" cssClass="sm_input"/></td>
                <td><form:input path="sControlWork" id="sControlWork" cssClass="sm_input"/></td>
                <td><form:input path="sCce" id="sCce" cssClass="sm_input"/></td>
                <td><form:input path="sExam" id="sExam" cssClass="sm_input"/></td>
                <td><form:input path="sZalik" id="sZalik" cssClass="sm_input"/></td>
                <td><form:input path="sCpa" id="sCpa" cssClass="sm_input"/></td>
                <td><form:input path="sAtest" id="sAtest" cssClass="sm_input"/></td>
                <td><form:input path="sCcrDp" id="sCcrDp" cssClass="sm_input"/></td>
                <td><form:input path="sPzdp" id="sPzdp" cssClass="sm_input"/></td>
            </tr>
        </tbody>
    </table>
        <form:errors path="nPlan" cssClass="validError"/>
        <form:errors path="nConsult" cssClass="validError"/>

        <form:errors path="zLesson" cssClass="validError"/>
        <form:errors path="zLab" cssClass="validError"/>
        <form:errors path="zPractice" cssClass="validError"/>
        <form:errors path="zConsult" cssClass="validError"/>
        <form:errors path="zKursWork" cssClass="validError"/>
        <form:errors path="zKursWorkIngFah" cssClass="validError"/>
        <form:errors path="zKursWorkFah" cssClass="validError"/>
        <form:errors path="zControlWork" cssClass="validError"/>
        <form:errors path="zCce" cssClass="validError"/>
        <form:errors path="zExam" cssClass="validError"/>
        <form:errors path="zZalik" cssClass="validError"/>
        <form:errors path="zCpa" cssClass="validError"/>
        <form:errors path="zAtest" cssClass="validError"/>
        <form:errors path="zCcrDp" cssClass="validError"/>
        <form:errors path="zPzdp" cssClass="validError"/>

        <form:errors path="sLesson" cssClass="validError"/>
        <form:errors path="sLab" cssClass="validError"/>
        <form:errors path="sPractice" cssClass="validError"/>
        <form:errors path="sConsult" cssClass="validError"/>
        <form:errors path="sKursWork" cssClass="validError"/>
        <form:errors path="sKursWorkIngFah" cssClass="validError"/>
        <form:errors path="sKursWorkFah" cssClass="validError"/>
        <form:errors path="sControlWork" cssClass="validError"/>
        <form:errors path="sCce" cssClass="validError"/>
        <form:errors path="sExam" cssClass="validError"/>
        <form:errors path="sZalik" cssClass="validError"/>
        <form:errors path="sCpa" cssClass="validError"/>
        <form:errors path="sAtest" cssClass="validError"/>
        <form:errors path="sCcrDp" cssClass="validError"/>
        <form:errors path="sPzdp" cssClass="validError"/>

        <button type="submit" class="btn btn-primary">
            <span class="glyphicon glyphicon-save"></span>&nbsp;Додати
        </button>
</form:form>

    <%--${sessionScope}--%>
</div>
<script type="text/javascript">
    $('#kafedra').select2();
</script>
<script type="text/javascript">
    $('#discipline').select2();
</script>
<jsp:include page="../../static/futter.jsp"/>