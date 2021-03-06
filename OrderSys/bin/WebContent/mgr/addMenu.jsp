<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加菜品</title>
<link rel="stylesheet" type="text/css" href="../css/allmenu.css">
</head>
<body>

	<section class="rt_wrap content mCustomScrollbar">
	<div class="rt_content">
		<div class="page_title">
			<h2 class="fl">添加菜品</h2>
			<a class="fr top_rt_btn"
				href="${pageContext.request.contextPath }/mgr/mgrShowAllMenu.jsp">返回产品列表</a>
		</div>
	<section>
	
		<form action="${pageContext.request.contextPath}/menuServlet?op=addMenu"
			method="post" enctype="multipart/form-data">
			<ul class="ulColumn2">
				<li><span class="item_name" style="width: 120px;">菜品编号：</span>
					<input type="text" class="textbox" name="id" placeholder="菜品编号..." />
				</li>
				<li><span class="item_name" style="width: 120px;">菜品名称：</span>
					<input type="text" class="textbox textbox_295" name="title"
					placeholder="菜品名称..." /></li>
				<li><span class="item_name" style="width: 120px;">单价：</span> <input
					type="text" class="textbox textbox_295" name="price"
					placeholder="单价..." /></li>
				<li><span class="item_name" style="width: 120px;">上传图片：</span>
					<label class="uploadImg"> <input type="file" name="img" />
						<span>上传图片</span>
					</label>
				</li>

				<li><span class="item_name" style="width: 120px;"></span>
				 <input
					type="submit" class="link_btn" value="添加" />
				</li>
			</ul>
		</form>
		</section>
	</div>
	</section>
</body>
</html>