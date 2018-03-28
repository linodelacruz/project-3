<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>counter page</title>
    </head>
    <body>
        <h1>This is a counter page!</h1>
        <p>
            The session counter is <b>${sessionCounter.count}</b>.
        </p>
        <p>
            The application counter is <b>${globalCounter.count}</b>.
        </p>
        
        <a href="/WebAppCounter/reset">Clear the session </a>
    </body>
</html>
