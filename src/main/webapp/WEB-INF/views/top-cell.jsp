<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<div class="top-cell">
	<section class="bdy">
		<div class="line">
			<div class="row book_img">
				<img src="./sample_book.jpg" alt="">
				<div class="book_sample">
					<img class="material" src="./book.png" alt="">
				</div>
			</div>
			<div class="row book_info">
				<p class="name">
					本のタイトル
				</p>
				<p class="author">
					東野圭吾
				</p>
				<p class="recommended">
					誰々に貸出中
                   </p>
                   <ul class="tag">
					<li>
                           php
					</li>
					<li>
                           php
					</li>
					<li>
                           基本情報技術者試験
					</li>
                   </ul>

			</div>
		</div>
	</section>
</div>

<%-- アクティブ処理 --%>
<input type="hidden" id="act_type" value="<%=request.getParameter("act_type") %>">
<script type="text/javascript">
 var actType = document.getElementById('act_type').value;
 if (actType != null && actType != '') {
	 document.getElementsByClassName(actType)[0].classList.add('actv');
	 }
</script>