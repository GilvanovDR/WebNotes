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
        <div class="card border-dark">
            <div class="card-body pb-0">
                <form method="GET" action="note/filterBy">
                    <div class="form-group">
                        <label>Заметка содержит:</label> <input class="form-control" type="text" name="text">
                    </div>
                    <input class="btn btn-primary mr-5" type="submit" value="Фильтровать">
                </form>
            </div>
        </div>
        <hr>
        <div class="card border-dark">
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr class="table table-dark">
                        <th class="col-1 text-center"><a href="note/create">Добавить</a></th>
                        <th>Заметки</th>
                    </tr>
                    </thead>
                    <c:forEach items="${note}" var="note">
                        <jsp:useBean id="note" scope="page" type="ru.GilvanovDR.webnotes.model.Note"/>
                        <tr>
                            <td class="text-center"><a href="note/delete?id=${note.id}">X</a></td>
                            <td><a href="note/update?id=${note.id}">
                                <c:if test="${not empty note.subject}">${note.subject}</c:if>
                                <c:if test="${empty note.subject}">${note.text}</c:if>
                            </a></td>
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