<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link rel="stylesheet" href="../css/index.css">
        <link rel="stylesheet" href="../css/catalogue.css">
        <link rel="stylesheet" type="text/css" href="../css/fronts/css/all.css">
        <style><%@include file="/css/index.css"%></style>
        <style><%@include file="/css/catalogue.css"%></style>
        <style><%@include file="/css/fronts/css/all.css"%></style>
    </head>
    <body>
        <div class="image">
            <div class="login">
                <a href="login.jsp">
                    <span class="vendeur"><i class="fa-solid fa-circle-user"></i></span>
                </a>
            </div>

        </div>
        <%@include file="catalogue.jsp" %>
    </body>
</html>
