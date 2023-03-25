<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Accounts List</title>
    </head>

    <body>

        <h3>Accounts List</h3>

        <c:if test="${! empty errorMessage}">
            <p style="color: red;">${errorMessage}</p>
        </c:if>

        <table border="1" cellpadding="5" cellspacing="1">
            <tr>
                <th>Code</th>
                <th>Solde</th>
                <th>Owner</th>
                <th colspan="3">Actions</th>
            </tr>
            <c:forEach items="${accounts}" var="account">
                <tr>
                    <td>${account.code}</td>
                    <td>${account.solde}</td>
                    <td>${account.owner}</td>
                    <td><a href="${pageContext.request.contextPath}/accounts?action=deposit">Deposit</a></td>
                    <td><a href="${pageContext.request.contextPath}/accounts?action=withdraw">Withdraw</a></td>
                    <td><a href="#">Delete</a></td>
                </tr>
            </c:forEach>
        </table>

        <a href="${pageContext.request.contextPath}/accounts?action=create">Create Account</a>

    </body>

</html>
