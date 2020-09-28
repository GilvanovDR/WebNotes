<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <jsp:useBean id="note" type="ru.GilvanovDR.webnotes.model.Note" scope="request"/>

        <h3 class="text-center">${note.isNew() ? 'Добавить заметку' : 'Редактировать заметку'}</h3>
        <hr>
        <form method="post" action="note">
            <input type="hidden" name="id" value="${note.id}">
            <dl>
                <dt>Тема:</dt>
                <dd><input type="text" value="${note.subject}" size=40 name="subject"></dd>
            </dl>
            <dl>
                <dt>Текст:</dt>
                <dd><input type="text" value="${note.text}" size=40 name="text" required></dd>
            </dl>
            <button class="btn btn-success" type="submit">Сохранить</button>
            <button class="btn btn-warning" onclick="window.history.back()" type="button">Отменить</button>
        </form>
        <c:if test="${not empty error}">
            <div class="alert alert-warning">${error}</div>
        </c:if>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
