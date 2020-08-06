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
<title>要望画面</title>
<link rel="stylesheet" href="resources/css/header.css" media="screen">
<link rel="stylesheet" href="resources/css/request.css" media="screen">
<link rel="stylesheet" href="resources/css/request-cell.css" media="screen">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/readmore.js"></script>
<script type="text/javascript" src="resources/js/readmore.min.js"></script>
<script type="text/javascript" src="resources/js/request.js"></script>
</head>
<body>
 <jsp:include page="./header.jsp"><jsp:param name="act_type" value="farmer" /></jsp:include>
 <section class="bdy">
  <div class="contents">
   <div class="title">本の要望</div>
   <div class="text-message">応援しよう！！！！！！！</div>
   <a href="#" class="btn-rq">本を要望する</a>
   <section class="td-rq">
    <c:forEach var="i" begin="0" end="1" step="1">
     <jsp:include page="./request-cell.jsp"></jsp:include>
    </c:forEach>
   </section>
  </div>
 </section>
</body>
</html>