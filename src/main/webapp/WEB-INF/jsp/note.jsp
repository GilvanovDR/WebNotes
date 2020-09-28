<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron pt-4">
    <div class="container">
        <hr>
        <div class="col-md-6 col-md-offset-3">
            <div class="table-responsive">
                <table class="text-center" border="1" cellpadding="8" cellspacing="0">
                    <thead>
                    <tr class="table table-dark">
                        <th>Заметки</th>
                        <th><a href="note/create">Добавить</a></th>
                    </tr>
                    </thead>
                    <c:forEach items="${note}" var="note">
                        <jsp:useBean id="note" scope="page" type="ru.GilvanovDR.webnotes.model.Note"/>
                        <tr>
                            <td><a href="note/update?id=${note.id}">
                                <c:if test="${not empty note.subject}">${note.subject}</c:if>
                                <c:if test="${empty note.subject}">${note.text}</c:if>
                            </a></td>
                            <td><a href="note/delete?id=${note.id}">X</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>