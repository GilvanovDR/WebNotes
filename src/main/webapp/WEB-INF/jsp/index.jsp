<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron pt-4">
    <div class="container">
        СТЕК:
        <ul>
            <pre> Spring, Spring MVC, Data JPA, Hibernate, Postgres, Maven, Log4j/LogBack, JUNIT5, Tomcat</pre>
        </ul>
        Функционал:
        <br>
        <ul>
            <li>CREATE/UPDATE/DELETE заметок</li>
            <li>фильтрация по темам и тексту заметки</li>
        </ul>
        <br>
        Дополнительно:
        <ul>
            <li>Реализовано хранение в PostgresSQL</li>
            <li>Реализовано MVC приложение</li>
        </ul>
        <br>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>