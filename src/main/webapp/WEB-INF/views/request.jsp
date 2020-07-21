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
</head>
<body>
  <jsp:include page="./header.jsp"><jsp:param name="act_type" value="farmer"/></jsp:include>
  <section class="bdy">
    <div class="contents">
      <div class="title">本の要望</div>
      <div class="text-message">応援しよう！！！！！！！</div>
      <a href="#" class="btn-rq">本を要望する</a>
      <section class="td-rq">
			<div class="line">
				<div class="row book_img">
					<img  src="./sample_book.jpg" alt="">
				</div>
				<div class="row content">
					<div class="name">
						<div class="text">
							Java SE 8 Silver 問題集
						</div>
					</div>
					<div class="author">
						<div class="text">
							志賀 澄人
						</div>
					</div>
					<div class="reason">
						<div class="text">
							要望理由
						</div>
					</div>
				</div>
				<div class="row cheer_img">
					<div class="cheer_count">
						99+
					</div>
					<img  src="./img/cheering.png" alt="">
				</div>
			</div>
		</section>
    </div>
  </section>
</body>
</html>