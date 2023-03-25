<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Create Account</title>
    </head>

    <body>

        <h3>Create Account</h3>

        <c:if test="${! empty errorMessage}">
            <p style="color: red;">${errorMessage}</p>
        </c:if>

        <form method="POST" action="${pageContext.request.contextPath}/accounts?action=create">
            <table border="0">
                <tr>
                    <td>Code</td>
                    <td><input type="text" name="code" value="${param.code}" /></td>
                </tr>
                <tr>
                    <td>Owner</td>
                    <td><input type="text" name="owner" value="${param.owner}" /></td>
                </tr>
                <tr>
                    <td>Initial Balance</td>
                    <td><input type="text" name="initialBalance" value="${param.initialBalance}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit" />
                        <a href="${pageContext.request.contextPath}/accounts?action=list">Cancel</a>
                    </td>
                </tr>
            </table>
        </form>

    </body>

</html>
