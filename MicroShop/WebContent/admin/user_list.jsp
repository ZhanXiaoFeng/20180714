<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link
	href="${pageContext.request.contextPath}/admin/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/css/style.css" />
<link
	href="${pageContext.request.contextPath}/admin/assets/css/codemirror.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/assets/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/assets/css/font-awesome-ie7.min.css" />
<script
	src="${pageContext.request.contextPath}/admin/assets/js/jquery.min.js"></script>

<script type="text/javascript">
	window.jQuery
			|| document
					.write("<script src='${pageContext.request.contextPath}/admin/assets/js/jquery-2.0.3.min.js'>"
							+ "<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
	if ("ontouchend" in document)
		document
				.write("<script src='${pageContext.request.contextPath}/admin/assets/js/jquery.mobile.custom.min.js'>"
						+ "<"+"/script>");
</script>
<script
	src="${pageContext.request.contextPath}/admin/assets/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/admin/assets/js/typeahead-bs2.min.js"></script>
<!-- page specific plugin scripts -->
<script
	src="${pageContext.request.contextPath}/admin/assets/js/jquery.dataTables.min.js"></script>
<script
	src="${pageContext.request.contextPath}/admin/assets/js/jquery.dataTables.bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/admin/js/H-ui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/admin/js/H-ui.admin.js"></script>
<script
	src="${pageContext.request.contextPath}/admin/assets/layer/layer.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/admin/assets/laydate/laydate.js"
	type="text/javascript"></script>
<title>用户列表</title>
</head>

<body>
	<div class="page-content clearfix">
		<div id="Member_Ratings">
			<div class="d_Confirm_Order_style">
				<div class="search_style">

					<ul class="search_content clearfix" style="display: none;">
						<li><label class="l_f">会员名称</label><input name="" type="text"
							class="text_add" placeholder="输入会员名称、电话、邮箱" style="width: 400px" /></li>
						<li><label class="l_f">添加时间</label><input
							class="inline laydate-icon" id="start" style="margin-left: 10px;"></li>
						<li style="width: 90px;"><button type="button"
								class="btn_search">
								<i class="icon-search"></i>查询
							</button></li>
					</ul>
				</div>
				<!---->
				<div class="border clearfix">
					<span class="l_f"> <a href="javascript:ovid()"
						id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加用户</a>
						<a href="javascript:ovid()" class="btn btn-danger"><i
							class="icon-trash"></i>批量删除</a>
					</span> <span class="r_f"><b>会员展示</b>
					</span>
				</div>
				<!---->
				<div class="table_menu_list">
					<table class="table table-striped table-bordered table-hover"
						id="sample-table">
						<thead>
							<tr>
								<th width="25"><label><input type="checkbox"
										class="ace"><span class="lbl"></span></label></th>
								<th width="80">ID</th>
								<th width="100">用户名</th>
								<th width="80">密码</th>
								<th width="100">昵称</th>
								<th width="100">头像</th>
								<th width="120">手机</th>
								<th width="150">邮箱</th>
								<th width="180">加入时间</th>
								<th width="70">状态</th>
								<th width="250">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${allCusts }" var="info">
								<tr>
									<td><label><input type="checkbox" class="ace"><span
											class="lbl"></span></label></td>
									<td>${info.id}</td>
									<td><u style="cursor: pointer" class="text-primary"
										onclick="member_show('${info.username}','member-show.html','10001','500','400')">${info.username}</u></td>

									<td>${info.password}</td>
									<td>${info.nickname}</td>
									<td><input type="image" src="${pageContext.request.contextPath}/static/upload/${info.imgurl}" style="width: 100px;height: 100px;"/></td>
									<td class="text-l">${info.phone}</td>
									<td class="text-l">${info.email}</td>
									<td class="text-l">2014-6-11 11:11:42</td>
									<td class="td-status"><span
										class="label label-success radius">已启用</span></td>
									<td class="td-manage">
									<a
										onClick="member_stop(this,'10001')" href="javascript:;"
										title="停用" class="btn btn-xs btn-success" >
										<i class="icon-ok bigger-120"></i></a>
										
										<%-- <a title="编辑"
									onclick="member_edit('编辑','${pageContext.request.contextPath }/customer/editCust.do?id=${info.id}','4','','510')"
									href="javascript:;" class="btn btn-xs btn-info"><i
										class="icon-edit bigger-120"></i></a> --%>
										
										  <a title="编辑" onclick="member_edit('550')" href="${pageContext.request.contextPath }/customer/editCust.do?id=${info.id}"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
										
										<%-- 	 <a title="编辑" type="submit" 
									href="javascript:;" 
										onclick="member_edit('编辑','${pageContext.request.contextPath }/customer/editCust.do?id=${info.id}','4','','550')"
										class="btn btn-xs btn-info" >
										<i
											class="icon-edit bigger-120"></i></a>  --%>
											<a title="删除"
										href="${pageContext.request.contextPath }/customer/deleteCust.do?id=${info.id}" onclick="javascript:if(confirm('确定要删除此信息吗？')){alert('删除成功！');return true;}return false;"
										class="btn btn-xs btn-warning" >
										<i
											class="icon-trash  bigger-120"></i></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--添加修改用户图层-->
	<div class="add_menber" id="add_menber_style" style="display: none">
		<form method="post"
			action="${pageContext.request.contextPath}/customer/edit.do">
			<input type="hidden" name="id" value="${customerInfo.id}" /><br>

			<ul class=" page-content">
				<li><label class="label_name">用&nbsp;&nbsp;户 &nbsp;名：</label><span
					class="add_name"><input value=""  type="text"
						class="text_add"  name="username" value="${customerInfo.username}" /></span>
				<div class="prompt r_f"></div></li>
				<li><label class="label_name">昵称：</label><span
					class="add_name"><input type="text"
						class="text_add"  name="nickname" value="${customerInfo.nickname}"/></span>
				<div class="prompt r_f"></div></li>				
				
				<li><label class="label_name">移动电话：</label><span
					class="add_name"><input  type="text"
						class="text_add" /></span>
				<div class="prompt r_f"></div></li>
				<li><label class="label_name">电子邮箱：</label><span
					class="add_name"><input  type="text"
						class="text_add" /></span>
				<div class="prompt r_f"></div></li>
				<!-- <li class="adderss"><label class="label_name">家庭住址：</label><span
					class="add_name"><input name="家庭住址" type="text"
						class="text_add" style="width: 350px" /></span>
				<div class="prompt r_f"></div></li> -->
				<li><label class="label_name">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</label><span
					class="add_name"> <label><input
							name="form-field-radio1" type="radio" checked="checked"
							class="ace"><span class="lbl">开启</span></label>&nbsp;&nbsp;&nbsp;
						<label><input name="form-field-radio1" type="radio"
							class="ace"><span class="lbl">关闭</span></label></span>
				<div class="prompt r_f"><input type="submit" value="确认修改"></div></li>
			</ul>
		</form>
	</div>
</body>
</html>
<script>
	jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 8, 9 ]
			} // 制定列不参与排序
			]
		});

		$('table th input:checkbox').on(
				'click',
				function() {
					var that = this;
					$(this).closest('table').find(
							'tr > td:first-child input:checkbox').each(
							function() {
								this.checked = that.checked;
								$(this).closest('tr').toggleClass('selected');
							});

				});

		$('[data-rel="tooltip"]').tooltip({
			placement : tooltip_placement
		});
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table')
			var off1 = $parent.offset();
			var w1 = $parent.width();

			var off2 = $source.offset();
			var w2 = $source.width();

			if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
				return 'right';
			return 'left';
		}
	})
	/*用户-添加*/
	$('#member_add').on(
			'click',
			function() {
				layer.open({
					type : 1,
					title : '添加用户',
					maxmin : true,
					shadeClose : true, //点击遮罩关闭层
					area : [ '800px', '' ],
					content : $('#add_menber_style'),
					btn : [ '提交', '取消' ],
					yes : function(index, layero) {
						var num = 0;
						var str = "";
						$(".add_menber input[type$='text']").each(
								function(n) {
									if ($(this).val() == "") {

										layer.alert(str += ""
												+ $(this).attr("name")
												+ "不能为空！\r\n", {
											title : '提示框',
											icon : 0,
										});
										num++;
										return false;
									}
								});
						if (num > 0) {
							return false;
						} else {
							layer.alert('添加成功！', {
								title : '提示框',
								icon : 1,
							});
							layer.close(index);
						}
					}
				});
			});
	/*用户-查看*/
	function member_show(title, url, id, w, h) {
		layer_show(title, url + '#?=' + id, w, h);
	}
	/*用户-停用*/
	function member_stop(obj, id) {
		layer
				.confirm(
						'确认要停用吗？',
						function(index) {
							$(obj)
									.parents("tr")
									.find(".td-manage")
									.prepend(
											'<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="icon-ok bigger-120"></i></a>');
							$(obj)
									.parents("tr")
									.find(".td-status")
									.html(
											'<span class="label label-defaunt radius">已停用</span>');
							$(obj).remove();
							layer.msg('已停用!', {
								icon : 5,
								time : 1000
							});
						});
	}

	/*用户-启用*/
	function member_start(obj, id) {
		layer
				.confirm(
						'确认要启用吗？',
						function(index) {
							$(obj)
									.parents("tr")
									.find(".td-manage")
									.prepend(
											'<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="icon-ok bigger-120"></i></a>');
							$(obj)
									.parents("tr")
									.find(".td-status")
									.html(
											'<span class="label label-success radius">已启用</span>');
							$(obj).remove();
							layer.msg('已启用!', {
								icon : 6,
								time : 1000
							});
						});
	}
	/*用户-编辑*/
	
	function member_edit(id) {
		layer.open({
			type : 1,
			title : '修改用户信息',
			maxmin : true,
			shadeClose : false, //点击遮罩关闭层
			area : [ '800px', '' ],
			content : $('#add_menber_style'),
			btn : [ '提交', '取消' ],
			yes : function(index, layero) {
				var num = 0;
				var str = "";
				$(".add_menber input[type$='text']").each(
						function(n) {
							if ($(this).val() == "") {

								layer.alert(str += "" + $(this).attr("name")
										+ "不能为空！\r\n", {
									title : '提示框',
									icon : 0,
								});
								num++;
								return false;
							}
						});
				if (num > 0) {
					return false;
				} else {
					layer.alert('添加成功！', {
						title : '提示框',
						icon : 1,
					});
					layer.close(index);
				}
			}
		});
	} 
	/*产品-编辑*/
	/* 
	function member_edit(title,url,id,w,h){
		layer_show(title,url,w,h);
	} */
	/*用户-删除*/
	function member_del(obj, id) {
		layer.confirm('确认要删除吗？', function(index) {
			$(obj).parents("tr").remove();
			layer.msg('已删除!', {
				icon : 1,
				time : 1000
			});
		});
	}
	laydate({
		elem : '#start',
		event : 'focus'
	});
</script>