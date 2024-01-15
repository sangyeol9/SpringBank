<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Personal - Start Bootstrap Theme</title>
<!-- 사용전 경로 수정 -->
<c:import url="../templates/head_css.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<!-- 사용전 경로 수정 -->
		<c:import url="../templates/header.jsp"></c:import>

		<div class="container px-5">
			<div class="bg-light rounded-4 py-5 px-4 px-md-5">
				<div class="text-center mb-5">
					<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">글쓰기</span></h1>
				</div>
				
				<div class="row gx-5 justify-content-center">
					<div class="col-lg-8 col-xl-8">
						<form id="contactForm" action="add" method="post" enctype="multipart/form-data">
							<!-- ProductName input -->
							<div class="form-floating mb-3">
								<input id="NoticeTitle" name="noticeTitle" class="form-control" type="text" placeholder="제목을 입력하세요" /> 
								<label for="NoticeTitle">Notice Title</label>
							</div>
							<!-- ProductContents input -->
							<div class="form-floating mb-3">
								<textarea id="noticeContents" name="noticeContents"></textarea>
							</div>
							<!-- ProductRate input -->
							<div class="form-floating mb-3">
								<input class="form-control" name="writer" id="writer" type="text" placeholder="작성자를 입력하세요" /> 
								<label for="writer">Writer</label>
							</div>

							<div class="mb-3">
								<h5 class="fw-bolder mb-1">첨부파일</h5>
								<input type="file" class="form-control" name="files">
								<input type="file" class="form-control" name="files">
								<input type="file" class="form-control" name="files">
								<input type="file" class="form-control" name="files">
								<input type="file" class="form-control" name="files">
							</div>

							<div class="d-grid">
								<button class="btn btn-primary btn-lg" id="submitButton" type="submit">추가</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</main>
	<c:import url="../templates/footer.jsp"></c:import>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
    <script type="text/javascript">
    	$("#noticeContents").summernote();
    </script>
</body>
</html>
