<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/static/css/main.css">
    <link rel="stylesheet" type="text/css" href="/layui/css/layui.css">
    <script type="text/javascript" src="/layui/layui.js"></script>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

<div class="site-nav-bg">
    <div class="site-nav w1200">
        <p class="sn-back-home">
            <i class="layui-icon layui-icon-home"></i>
            <a href="#">首页</a>
        </p>
        <div class="sn-quick-menu">
            <div class="login"><a href="login.html">登录</a></div>
            <div class="sp-cart"><a href="shopcart.html">购物车</a><span>2</span></div>
        </div>
    </div>
</div>


<div class="header">
    <div class="headerLayout w1200">
        <div class="headerCon">
            <h1 class="mallLogo">
                <a href="/test/index" title="母婴商城">
                    <img src="/static/img/logo.png">
                </a>
            </h1>
            <div class="mallSearch">
                <form action="" class="layui-form" novalidate>
                    <input type="text" name="title" required lay-verify="required" autocomplete="off"
                           class="layui-input" placeholder="请输入需要的商品">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">
                        <i class="layui-icon layui-icon-search"></i>
                    </button>
                    <input type="hidden" name="" value="">
                </form>
            </div>
        </div>
    </div>
</div>


<div class="content content-nav-base datails-content">
    <div class="main-nav">
        <div class="inner-cont0">
            <div class="inner-cont1 w1200">
                <div class="inner-cont2">
                    <a href="/test/commodity" class="active">所有商品</a>
                    <a href="/test/buytoday">今日团购</a>
                    <a href="/test/information">母婴资讯</a>
                    <a href="/test/about">关于我们</a>
                </div>
            </div>
        </div>
    </div>
    <div class="data-cont-wrap w1200">
        <div class="crumb">
            <a href="/test/index">首页</a>
            <span>></span>
            <a href="/test/commodity">所有商品</a>
            <span>></span>
            <a href="javascript:;">产品详情</a>
        </div>
        <div class="product-intro layui-clear">
            <div class="preview-wrap">
                <a href="javascript:;"><img src="${sessionScope.item.img}"></a>
            </div>
            <div class="itemInfo-wrap">
                <div class="itemInfo">
                    <div class="title">
                        <h4>${sessionScope.item.title} </h4>
                        <span><i class="layui-icon layui-icon-rate-solid"></i>收藏</span>
                    </div>
                    <div class="summary">
                        <p class="reference"><span>参考价</span>
                            <del>${sessionScope.item.original}</del>
                        </p>
                        <p class="activity"><span>活动价</span><strong class="price"><i>￥</i>${sessionScope.item.price}</strong></p>
                        <p class="address-box"><span>送&nbsp;&nbsp;&nbsp;&nbsp;至</span><strong class="address">江西&nbsp;&nbsp;南昌&nbsp;&nbsp;东湖区</strong>
                        </p>
                    </div>
                    <div class="choose-attrs">
                        <div class="color layui-clear"><span class="title">颜&nbsp;&nbsp;&nbsp;&nbsp;色</span>
                            <div class="color-cont"> <span class="btn active">${sessionScope.item.color}</span></div>
                        </div>
                        <div class="number layui-clear"><span class="title">数&nbsp;&nbsp;&nbsp;&nbsp;量</span>
                            <div class="number-cont"><span class="cut btn">-</span><input
                                    onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
                                    onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
                                    maxlength="4" type="" name="" value="1" id="second"><span class="add btn">+</span></div>
                        </div>
                    </div>
                    <div class="choose-btns">
                        <form class="layui-form" action="/alipay?id=${sessionScope.item.id}&amount=${sessionScope.item.price}" method="post">
                            <button class="layui-btn layui-btn-primary purchase-btn" type="submit" >
                                立刻购买
                            </button>
                            <%--<button class="layui-btn  layui-btn-danger car-btn"><i class="layui-icon layui-icon-cart-simple"></i>加入购物车</button> --%>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<script type="text/javascript">
    layui.config({
        base: '/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm', 'jquery','form'], function () {
        var mm = layui.mm, $ = layui.$;
        var form = layui.form;
        var cur = $('.number-cont input').val();
        $('.number-cont .btn').on('click', function () {
            if ($(this).hasClass('add')) {
                cur++;

            } else {
                if (cur > 1) {
                    cur--;
                }
            }
            $('.number-cont input').val(cur)
        });
       /* form.on('submit(demo11)',function (data) {
            var cont=document.getElementById("account");
            //console.log('innerText cont= '+ cont.innerText);

            $.ajax({
                url:"/alipay",
                //data:{id:1},
                //dataType:"json",
                type:'get',
            });
            return false;
        });*/
    });
</script>


</body>
</html>