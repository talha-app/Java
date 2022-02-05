<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Talha Company Home Page
    </title>
</head>
<body>
<p>
    Welcome to company home page.
</p>

<hr>
<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role(s): <security:authentication property="principal.authorities"/>
    <br><br>

</p>
<hr>
<!-- Add a link to point to /leaders ... this is for the managers. -->

<security:authorize access="hasRole('MANAGER')">
    <p>
        <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting </a>
        (Only for managers )
    </p>
    <hr>
</security:authorize>
<!-- Add a link to point to /system ... this is for admins -->
<security:authorize access="hasRole('ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/systems">Admin Meeting </a>
        (Only for admins )
    </p>
    <hr>
</security:authorize>
<!-- Add logout button -->
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout"/>

</form:form>

</body>
</html>