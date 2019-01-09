<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome</h3>
        <form method="POST" action="/index" modelAttribute="login">
             <table>
                <tr>
                    <td><label name="userName">Name</label></td>
                    <td><input name="userName"/></td>
                </tr>
                <tr>
                    <td><label name="password">Password</label></td>
                    <td><input name="password"/></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
