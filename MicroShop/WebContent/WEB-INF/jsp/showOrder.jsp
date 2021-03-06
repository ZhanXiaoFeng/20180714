<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>商城网上商城</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/css/css.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		var region = $("#region");
		var address = $("#address");
		var number_this = $("#number_this");
		var name = $("#name_");
		var phone = $("#phone");
		$("#sub_setID").click(function() {
			var input_out = $(".input_style");
			for (var i = 0; i <= input_out.length; i++) {
				if ($(input_out[i]).val() == "") {
					$(input_out[i]).css("border", "1px solid red");

					return false;
				} else {
					$(input_out[i]).css("border", "1px solid #cccccc");
				}
			}
		});
		var span_momey = $(".span_momey");
		var b = 0;
		for (var i = 0; i < span_momey.length; i++) {
			b += parseFloat($(span_momey[i]).html());
		}
		var out_momey = $(".out_momey");
		out_momey.html(b);
		$(".shade_content").hide();
		$(".shade").hide();
		$('.nav_mini ul li').hover(function() {
			$(this).find('.two_nav').show(100);
		}, function() {
			$(this).find('.two_nav').hide(100);
		})
		$('.left_nav').hover(function() {
			$(this).find('.nav_mini').show(100);
		}, function() {
			$(this).find('.nav_mini').hide(100);
		})
		$('#jia').click(function() {
			$('input[name=num]').val(parseInt($('input[name=num]').val()) + 1);
		})
		$('#jian').click(function() {
			$('input[name=num]').val(parseInt($('input[name=num]').val()) - 1);
		})
		$('.Caddress .add_mi')
				.click(
						function() {
							$(this)
									.css('background',
											'url("${pageContext.request.contextPath }/static/images/mail_1.jpg") no-repeat')
									.siblings('.add_mi')
									.css('background',
											'url("static/images/mail.jpg") no-repeat')
						})
	})
	var x = Array();

	function func(a, b) {
		x[b] = a.html();
		alert(x)
		a.css('border', '2px solid #f00').siblings('.min_mx').css('border',
				'2px solid #ccc');
	}

	function onclick_close() {
		var shade_content = $(".shade_content");
		var shade = $(".shade");
		if (confirm("确认关闭么！此操作不可恢复")) {
			shade_content.hide();
			shade.hide();
		}
	}

	function onclick_open() {
		$(".shade_content").show();
		$(".shade").show();
		var input_out = $(".input_style");
		for (var i = 0; i <= input_out.length; i++) {
			if ($(input_out[i]).val() != "") {
				$(input_out[i]).val("");
			}
		}
	}

	function onclick_remove(r) {
		if (confirm("确认删除么！此操作不可恢复")) {
			var out_momey = $(".out_momey");
			var input_val = $(r).parent().prev().children().eq(1).val();
			var span_html = $(r).parent().prev().prev().children().html();
			var out_add = parseFloat(input_val).toFixed(2)
					* parseFloat(span_html).toFixed(2);
			var reduce = parseFloat(out_momey.html()).toFixed(2)
					- parseFloat(out_add).toFixed(2);
			console.log(parseFloat(reduce).toFixed(2));
			out_momey.text(parseFloat(reduce).toFixed(2))
			$(r).parent().parent().remove();
		}
	}

	function onclick_btnAdd(a) {
		var out_momey = $(".out_momey");
		var input_ = $(a).prev();
		var input_val = $(a).prev().val();
		var input_add = parseInt(input_val) + 1;
		input_.val(input_add);
		var btn_momey = parseFloat($(a).parent().prev().children().html());
		var out_momey_float = parseFloat(out_momey.html()) + btn_momey;
		out_momey.text(out_momey_float.toFixed(2));
	}

	function onclick_reduce(b) {
		var out_momey = $(".out_momey");
		var input_ = $(b).next();
		var input_val = $(b).next().val();
		if (input_val <= 1) {
			alert("商品个数不能小于1！")
		} else {
			var input_add = parseInt(input_val) - 1;
			input_.val(input_add);
			var btn_momey = parseFloat($(b).parent().prev().children().html());
			var out_momey_float = parseFloat(out_momey.html()) - btn_momey;
			out_momey.text(out_momey_float.toFixed(2));
		}
	}
</script>
</head>

<body>
	<div id="top">
		<div id="top_main">
			<ul class="topu">
				<li>
					<div class="xing"></div> <a href="#">收藏商城</a>
				</li>
			</ul>
			<div id="hello">
				<span>您好，欢迎来到商城！ <a href="login.html">[登陆]</a><a
					href="login.html">[免费注册]</a>
				</span>
			</div>
			<div class="topright">
				<ul>
					<li>
						<div class="cun">
							<a href="#">我的订单</a>
						</div>
					</li>
					<li class="kefu">
						<div class="cun">
							<div class="a1">
								<div class="kefuhide">
									<span>客户服务</span>
									<div class="downjian1"></div>
									<ul>
										<li><a href="#">帮助中心</a></li>
										<li><a href="#">售后服务</a></li>
										<li><a href="#">在线客服</a></li>
										<li><a href="#">投诉中心</a></li>
										<li><a href="#">客服邮箱</a></li>
									</ul>
								</div>
							</div>
						</div>
					</li>
					<li class="wangzhan">
						<div class="cun">
							<span>网站导航</span>
							<div class="downjian1"></div>
						</div>
						<div class="wangzhanhide">
							<div class="tese">
								<span>特色栏目</span>
							</div>
							<div class="tesemain">
								<a href="#">商城通信</a> <a href="#">校园之星</a> <a href="#">视频购物</a> <a
									href="#">商城社区</a> <a href="#">在线读书</a> <a href="#">装机大师</a> <a
									href="#">商城E卡 </a> <a href="#">家装城</a> <a href="#">搭配购 </a> <a
									href="#">我喜欢 </a> <a href="#">游戏社区</a>
							</div>
							<div class="tese">
								<span>企业服务</span>
							</div>
							<div class="tesemain1">
								<a href="#">企业采购</a> <a href="#">办公直通车</a>
							</div>
							<div class="tese">
								<span>旗下网站</span>
							</div>
							<div class="tesemain2">
								<a href="#">English Site</a>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<!-- 搜索区域开始 -->
	<div id="serach">
		<div class="logo">
			<a href="index.html"> <img
				src="${pageContext.request.contextPath }static/images/logo.png"
				alt="" /></a>
			<div class="dongtu"></div>
		</div>
		<div class="sou">
			<div class="sousuo">
				<input type="text" class="kuang" value="跨界"
					style="color: #999; font-size: 14px" />
				<div class="souzi">
					<a href="#">搜索</a>
				</div>
			</div>
			<div class="reci">
				<span>热门搜索:</span> <a href="#" style="color: red">校园之星</a> <a
					href="#">影院到家</a> <a href="#">JD制暖节</a> <a href="#">腕表领券</a> <a
					href="#">自营满减</a> <a href="#">N3抢购</a> <a href="#">图书换购</a> <a
					href="#">12.12</a>
			</div>
		</div>
		<div class="myjd">
			<div class="mytu"></div>
			<a href="#">我的商城</a>
			<div class="jiantou"></div>
			<div class="myjdhide">
				<div class="hello">
					<span>您好，请</span> <a href="#">登录</a>
				</div>
				<div class="hey">
					<div class="heyleft">
						<ul>
							<li><a href="#">待处理订单</a></li>
							<li><a href="#">咨询回复</a></li>
							<li><a href="#">降价商品</a></li>
							<li><a href="#">返修退换货</a></li>
							<li><a href="#">优惠券</a></li>
						</ul>
					</div>
					<div class="heyright">
						<ul>
							<li><a href="#">我的关注></a></li>
							<li><a href="#">我的京豆></a></li>
							<li><a href="#">我的理财></a></li>
							<li><a href="#">我的白条></a></li>
						</ul>
					</div>
				</div>
				<div class="hidebot">
					<div class="bottop">
						<span>最近浏览的商品:</span> <a href="#">查看浏览历史></a>
					</div>
					<div class="botdown">
						<span>「暂无数据」</span>
					</div>
				</div>
			</div>
		</div>
		<div class="gouwuche">
			<div class="chetu"></div>
			<a href="#">去购物车结算</a>
			<div class="jianleft"></div>
			<div class="num">
				<div class="numright"></div>
				<div class="numzi">
					<span>0</span>
				</div>
			</div>
			<div class="hideche">
				<div class="kongche"></div>
				<span>购物车中还没有商品，赶紧选购吧！</span>
			</div>
		</div>
		<div class="jubao"></div>
	</div>

	<div class="shopping_content">
		<div class="shopping_table">
			<table border="1" bordercolor="#cccccc" cellspacing="0"
				cellpadding="0" style="width: 100%; text-align: center;">
				<tr>
					<th>订单编号</th>
					<th>支付状态<br/>1支付;0未支付</th>
					<th>订单总价/元</th>
					<th>支付方式</th>
					<th>操作</th>
				</tr>
				<c:forEach var="order" items="${orders}" varStatus="status2">
					<tr>

						<td height="80px" width="200px"><span
							style="font-family: '楷体'; color: #000; font-size: 20px;">${status2.count}</span></td>
						<td width="150px"><span
							style="font-family: '楷体'; color: #000; font-size: 20px;" >${order.status}</span></td>
						<td width="150px"><span
							style="font-family: '楷体'; color: #CB3437; font-size: 20px;">￥：${order.price}元</span></td>
						<td width="150px"><span
							style="font-family: '楷体'; color: #000; font-size: 20px;">${order.paymethod}</span></td>
						<td width="180px"><a
							href="${pageContext.request.contextPath }/showOrderDetail.do?orderId=${order.id }">查看订单详情</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<!-- 底部开始 -->
	<div id="down">
		<div class="down_top">
			<a href="#">关于我们</a> <a href="#">联系我们</a> <a href="#">商家入驻</a> <a
				href="#">营销中心</a> <a href="#">手机商城</a> <a href="#">友情链接</a> <a
				href="#">销售联盟</a> <a href="#">商城社区</a> <a href="#">商城公益</a> <a
				href="#" style="border-right: none">English Site</a>
		</div>
		<div class="down_center">
			<span>北京市公安局朝阳分局备案编号110105014669 | 京ICP证070359号 | <a href="#">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a>
				| 新出发京零 字第大120007号
			</span> <span><a href="#">音像制品经营许可证苏宿批005号</a> |
				出版物经营许可证编号新出发(苏)批字第N-012号 | 互联网出版许可证编号新出网证(京)字150号</span> <span><a
				href="#">网络文化经营许可证京网文[2011]0168-061号</a> 违法和不良信息举报电话：4006561155
				Copyright © 2004-2014 商城JD.com 版权所有</span> <span>商城旗下网站：<a href="#">360TOP</a><a
				href="#">拍拍网</a><a href="#">网银在线</a></span>
		</div>
		<div class="down_bot">
			<img src="${pageContext.request.contextPath }/static/images/bot1.gif"
				alt="" /> <img
				src="${pageContext.request.contextPath }/static/images/bot2.gif"
				alt="" /> <img
				src="${pageContext.request.contextPath }/static/images/bot3.png"
				alt="" /> <img
				src="${pageContext.request.contextPath }/static/images/bot4.png"
				alt="" />
		</div>
	</div>
	<!-- 底部结束 -->
</body>

</html>