<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach items="${disciplineList}" var="disciplineList">
    <tr>
        <td colspan="19">${disciplineList.name}</td>
    </tr>
        <c:forEach items="${planCalcList}" var="planCalcList">
            <c:choose>
                <c:when test="${disciplineList.id == planCalcList.disciplineId}">
                    <tr>
                        <td>${planCalcList.groupName}</td>
                        <td>${planCalcList.studentsAmount}</td>
                        <td>${planCalcList.lesson}</td>
                        <td>${planCalcList.lab}</td>
                        <td>${planCalcList.practice}</td>
                        <td>${planCalcList.consult}</td>
                        <td>${planCalcList.kursWork}</td>
                        <td>${planCalcList.kursWorkIngFah}</td>
                        <td>${planCalcList.kursWorkFah}</td>
                        <td>${planCalcList.controlWork}</td>
                        <td>${planCalcList.cce}</td>
                        <td>${planCalcList.exam}</td>
                        <td>${planCalcList.zalik}</td>
                        <td>${planCalcList.cpa}</td>
                        <td>${planCalcList.atest}</td>
                        <td>${planCalcList.ccrDp}</td>
                        <td>${planCalcList.pzDp}</td>
                        <td>${planCalcList.allSum}</td>
                    </tr>
                </c:when>
            </c:choose>
        </c:forEach>
    </tr>
</c:forEach>