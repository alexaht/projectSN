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

                <table class="table table-bordered table-hover table-condensed table_text table-striped" id="main_table">
                <thead class="my_tr_back" style="width: 100%;">
                <tr>
                    <td rowspan="2">
                        <svg width="12" height="400" class="svg-text">
                            <text x="-400" y="10" font-family="Arial" font-size="14" transform='rotate(-90)'>Скорочена назва кафедри</text>
                        </svg>
                    </td>
                    <td rowspan="2"> <svg width="12" height="400" class="svg-text">
                        <text x="-400" y="10" font-family="Arial" font-size="14" transform='rotate(-90)'>Назва дисципліни</text>
                    </svg></td>
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
                <tr id="AddTableRow">
                    <td align="left"  colspan="35">
                        <c:choose>
                            <c:when test="${(!empty sessionScope.s_ly) && (!empty sessionScope.s_gr)}">
                                <a class="btn btn-primary" href="/createPlan/new/${sessionScope.s_ly}/${sessionScope.s_gr}">
                                    <span class="glyphicon glyphicon-plus"></span>Додати план
                                </a>
                            </c:when>
                        </c:choose>
                    </td>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${planHistory}" var="planHistory">
                        <tr>
                            <td>${planHistory.kafedra.shortKafName}</td>
                            <td>${planHistory.discipline.name}</td>

                            <td>${planHistory.nPlan}</td>
                            <td>${planHistory.nConsult}</td>

                            <td>${planHistory.zLesson}</td>
                            <td>${planHistory.zLab}</td>
                            <td>${planHistory.zPractice}</td>
                            <td>${planHistory.zConsult}</td>
                            <td>${planHistory.zKursWork}</td>
                            <td>${planHistory.zKursWorkIngFah}</td>
                            <td>${planHistory.zKursWorkFah}</td>
                            <td>${planHistory.zControlWork}</td>
                            <td>${planHistory.zCce}</td>
                            <td>${planHistory.zExam}</td>
                            <td>${planHistory.zZalik}</td>
                            <td>${planHistory.zCpa}</td>
                            <td>${planHistory.zAtest}</td>
                            <td>${planHistory.zCcrDp}</td>
                            <td>${planHistory.zPzdp}</td>

                            <td>${planHistory.sLesson}</td>
                            <td>${planHistory.sLab}</td>
                            <td>${planHistory.sPractice}</td>
                            <td>${planHistory.sConsult}</td>
                            <td>${planHistory.sKursWork}</td>
                            <td>${planHistory.sKursWorkIngFah}</td>
                            <td>${planHistory.sKursWorkFah}</td>
                            <td>${planHistory.sControlWork}</td>
                            <td>${planHistory.sCce}</td>
                            <td>${planHistory.sExam}</td>
                            <td>${planHistory.sZalik}</td>
                            <td>${planHistory.sCpa}</td>
                            <td>${planHistory.sAtest}</td>
                            <td>${planHistory.sCcrDp}</td>
                            <td>${planHistory.sPzdp}</td>
                            <td><a href="/createPlan/edit-${planHistory.id}-planHistory"><span class="glyphicon glyphicon-edit"></span></a></td>
                            <td><a href="/createPlan/delete-${planHistory.id}-planHistory"><span class="glyphicon glyphicon-floppy-remove"></span></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
<jsp:include page="../../static/futter.jsp"/>