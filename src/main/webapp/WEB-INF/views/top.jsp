<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>トップ画面</title>
<link rel="stylesheet" href="resources/css/header.css" media="screen">
<link rel="stylesheet" href="resources/css/top.css" media="screen">
<link rel="stylesheet" href="resources/css/top-cell.css" media="screen">
</head>
<body>
 <jsp:include page="./header.jsp"></jsp:include>
 <section class="bdy">
  <jsp:include page="./top-cell.jsp"></jsp:include>
 </section>
</body>
</html>