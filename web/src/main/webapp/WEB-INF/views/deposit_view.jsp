<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Deposit</title>
    </head>

    <body>

        <h3>Deposit</h3>

        <c:if test="${! empty errorMessage}">
            <p style="color: red;">${errorMessage}</p>
        </c:if>

        <form method="POST" action="${pageContext.request.contextPath}/account?action=deposit">
            <table border="0">
                <tr>
                    <td>Account</td>
                    <td><input type="text" name="account" value="${param.account}" /></td>
                </tr>
                <tr>
                    <td>Amount</td>
                    <td><input type="text" name="amount" value="${param.amount}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit" />
                        <a href="#">Cancel</a>
                    </td>
                </tr>
            </table>
        </form>

    </body>

</html>
