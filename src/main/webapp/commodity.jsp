<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

            <c:choose>
                <c:when test="${sessionScope.user!=null}">
                    <div class="login">${sessionScope.user}</div>
                </c:when>
                <c:otherwise>
                    <div class="login"><a href="login.html">登录</a></div>
                </c:otherwise>
            </c:choose>
            <div class="sp-cart"><a href="shopcart.html">购物车</a><span></span></div>
        </div>
    </div>
</div>


<div class="header">
    <div class="headerLayout w1200">
        <div class="headerCon">
            <h1 class="mallLogo">
                <a href="#" title="母婴商城">
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


<div class="content content-nav-base commodity-content">
    <div class="main-nav">
        <div class="inner-cont0">
            <div class="inner-cont1 w1200">
                <div class="inner-cont2">
                    <a href="commodity.html" class="active">所有商品</a>
                    <a href="buytoday.html">今日团购</a>
                    <a href="information.html">母婴资讯</a>
                    <a href="about.html">关于我们</a>
                </div>
            </div>
        </div>
    </div>
    <div class="commod-cont-wrap">
        <div class="commod-cont w1200 layui-clear">
            <div class="left-nav">
                <div class="title">所有分类</div>
                <div class="list-box">
                    <dl>
                        <dt>奶粉辅食</dt>
                        <dd><a href="javascript:;" onclick="getCatalogItem('catalog')">进口奶粉</a></dd>
                        <dd><a href="javascript:;">宝宝辅食</a></dd>
                        <dd><a href="javascript:;">营养品</a></dd>
                    </dl>
                    <dl>
                        <dt>儿童用品</dt>
                        <dd><a href="javascript:;">纸尿裤</a></dd>
                        <dd><a href="javascript:;">婴儿湿巾</a></dd>
                        <dd><a href="javascript:;">婴儿车</a></dd>
                        <dd><a href="javascript:;">婴儿床</a></dd>
                        <dd><a href="javascript:;">儿童安全座椅</a></dd>
                    </dl>
                    <dl>
                        <dt>儿童早教</dt>
                        <dd><a href="javascript:;">儿童玩具</a></dd>
                        <dd><a href="javascript:;">早教书籍</a></dd>
                        <dd><a href="javascript:;">孕产育儿书</a></dd>
                    </dl>
                    <dl>
                        <dt>儿童服饰</dt>
                        <dd><a href="javascript:;">童装</a></dd>
                        <dd><a href="javascript:;">童鞋</a></dd>
                        <dd><a href="javascript:;">宝宝配饰</a></dd>
                    </dl>
                    <dl>
                        <dt>孕妈专区</dt>
                        <dd><a href="javascript:;">孕妇装</a></dd>
                        <dd><a href="javascript:;">孕妇护肤</a></dd>
                        <dd><a href="javascript:;">孕妇用品</a></dd>
                    </dl>
                    <%--<c:forEach items="" var="">
                        <dl>
                            <dt>奶粉辅食</dt>
                            <dd><a href="javascript:;" onclick="getCatalogItem('catalog')">进口奶粉</a></dd>
                            <dd><a href="javascript:;">宝宝辅食</a></dd>
                            <dd><a href="javascript:;">营养品</a></dd>
                        </dl>
                    </c:forEach>--%>
                </div>
            </div>
            <div class="right-cont-wrap">
                <div class="right-cont">

                    <div class="cont-list layui-clear" id="list-cont">
                       <%-- <div class="item">
                            <div class="img">
                                <a href="javascript:;"><img src="/static/img/paging_img1.jpg"></a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <div class="img">
                                <a href="javascript:;"><img src="/static/img/paging_img2.jpg"></a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <div class="img">
                                <a href="javascript:;"><img src="/static/img/paging_img3.jpg"></a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <div class="img">
                                <a href="javascript:;"><img src="/static/img/paging_img1.jpg"></a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <div class="img">
                                <a href="javascript:;"><img src="/static/img/paging_img2.jpg"></a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <div class="img">
                                <a href="javascript:;"><img src="/static/img/paging_img3.jpg"></a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <div class="img">
                                <a href="javascript:;"><img src="/static/img/paging_img1.jpg"></a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <div class="img">
                                <a href="javascript:;"><img src="/static/img/paging_img2.jpg"></a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <div class="img">
                                <a href="javascript:;"><img src="/static/img/paging_img3.jpg"></a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <div class="img">
                                <a href="javascript:;"><img src="/static/img/paging_img1.jpg"></a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <div class="img">
                                <a href="javascript:;"><img src="/static/img/paging_img2.jpg"></a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <div class="img">
                                <a href="javascript:;"><img src="/static/img/paging_img3.jpg"></a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <div class="img">
                                <a href="javascript:;"><img src="/static/img/paging_img1.jpg"></a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <div class="img">
                                <a href="javascript:;"><img src="/static/img/paging_img2.jpg"></a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>--%>
                        <%--<div class="item">
                            <div class="img">
                                <a href="javascript:;"><img src="/static/img/paging_img3.jpg"></a>
                            </div>
                            <div class="text">
                                <p class="title">森系小清新四件套</p>
                                <p class="price">
                                    <span class="pri">￥200</span>
                                    <span class="nub">1266付款</span>
                                </p>
                            </div>
                        </div>--%>
                    </div>
                    <!-- 模版引擎导入 -->
                    <script type="text/html" id="demo">
                      {{# layui.each(d.menu.milk.content,function(index,item){}}
                        <div class="item">
                          <div class="img">
                            <a href="javascript:;"><img src="{{item.img}}"></a>
                          </div>
                          <div class="text">
                            <p class="title">{{item.title}}</p>
                            <p class="price">
                              <span class="pri">{{item.pri}}</span>
                              <span class="nub">{{item.nub}}</span>
                            </p>
                          </div>
                        </div>
                      {{# }); }}
                    </script>
                    <div id="demo0" style="text-align: center;"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    //var count;
    layui.config({
        base: '/static/js/util/'   //你存放新模块的目录，注意，不是layui的模块目录
    }).use(['mm', 'laypage', 'jquery'],
        function () {
        var laypage = layui.laypage,
            $ = layui.$,
            mm = layui.mm;

        //请求分类
            $.ajax(
                {
                    type: "get",
                    url: "/getCatalog",
                    datatype: "json",
                    success:function (data) {
                        if (data.result=='SUCCESS') {
                            /*setTimeout(function () {
                                window.location.href = "/index.jsp";
                            },1000)*/
                        }
                        else {
                            lay.msg(data.errorMsg,{time: 1000});
                        }
                    },
                    error:function () {
                        layer.msg("商品分类获取失败");
                    }

                }
            );
        mm.request({
            url: '/getCount',
            //ata:{account:obj.curr,pagesize:obj.limit},
            success : function(res){
                console.log(res)
                //count = res.count;
                laypage.render({
                    elem: 'demo0',
                    limit:3
                    , count:res.count//数据总数
                    , jump: function (obj, first) {
                        mm.request({
                            url: '/getCommodity',
                            data:{account:obj.curr,pagesize:obj.limit},
                            success : function(res){
                                console.log(res)
                                listCont.innerHTML = mm.renderHtml(html,res)
                            },
                            error: function(res){
                                console.log(res);
                            }
                        })

                    }
                });
                //listCont.innerHTML = mm.renderHtml(html,res)
            },
            error: function(res){
                console.log(res);
            }
        })
            /*laypage.render({
                elem: 'demo0',
                limit:3
                //, count:res.count//数据总数
                , jump: function (obj, first) {
                    mm.request({
                        url: '/getCommodity',
                        data:{account:obj.curr,pagesize:obj.limit},
                        success : function(res){
                            console.log(res);
                            listCont.innerHTML = mm.renderHtml(html,res)
                        },
                        error: function(res){
                            console.log(res);
                        }
                    })

                }
            });*/

        /*laypage.render({
            elem: 'demo0',
            limit:3
            , count:count//数据总数
            , jump: function (obj, first) {
                mm.request({
                    url: '/getCommodity',
                    data:{account:obj.curr,pagesize:obj.limit},
                    success : function(res){
                        console.log(res)
                        listCont.innerHTML = mm.renderHtml(html,res)
                    },
                    error: function(res){
                        console.log(res);
                    }
                })

            }
        });*/


        // 模版引擎导入
          var html = demo.innerHTML;
          var listCont = document.getElementById('list-cont');
          // console.log(layui.router("#/about.html"))




        $('.sort a').on('click', function () {
            $(this).addClass('active').siblings().removeClass('active');
        })
        $('.list-box dt').on('click', function () {
            if ($(this).attr('off')) {
                $(this).removeClass('active').siblings('dd').show()
                $(this).attr('off', '')
            } else {
                $(this).addClass('active').siblings('dd').hide()
                $(this).attr('off', true)
            }
        })

    });

    function getCatalogItem(catalog) {
        layui.config({
            base: '/static/js/util/'   //你存放新模块的目录，注意，不是layui的模块目录
        }).use(['mm', 'laypage', 'jquery'],
            function () {
                var laypage = layui.laypage,
                    $ = layui.$,
                    mm = layui.mm;

                mm.request({
                    url: '/getCount1',
                    //data:{account:obj.curr,pagesize:obj.limit},
                    data:{catalog:catalog},
                    success : function(res){
                        console.log(res)
                        //count = res.count;
                        laypage.render({
                            elem: 'demo0',
                            limit:3
                            , count:res.count//数据总数
                            , jump: function (obj, first) {
                                mm.request({
                                    url: '/getCommodity1',
                                    data:{account:obj.curr,pagesize:obj.limit,catalog:catalog},
                                    success : function(res){
                                        console.log(res)
                                        listCont.innerHTML = mm.renderHtml(html,res)
                                    },
                                    error: function(res){
                                        console.log(res);
                                    }
                                })

                            }
                        });
                        //listCont.innerHTML = mm.renderHtml(html,res)
                    },
                    error: function(res){
                        console.log(res);
                    }
                })

                /*laypage.render({
                    elem: 'demo0',
                    limit:3
                    , count:count//数据总数
                    , jump: function (obj, first) {
                        mm.request({
                            url: '/getCommodity',
                            data:{account:obj.curr,pagesize:obj.limit},
                            success : function(res){
                                console.log(res)
                                listCont.innerHTML = mm.renderHtml(html,res)
                            },
                            error: function(res){
                                console.log(res);
                            }
                        })

                    }
                });*/


                // 模版引擎导入
                var html = demo.innerHTML;
                var listCont = document.getElementById('list-cont');
                // console.log(layui.router("#/about.html"))




                $('.sort a').on('click', function () {
                    $(this).addClass('active').siblings().removeClass('active');
                })
                $('.list-box dt').on('click', function () {
                    if ($(this).attr('off')) {
                        $(this).removeClass('active').siblings('dd').show()
                        $(this).attr('off', '')
                    } else {
                        $(this).addClass('active').siblings('dd').hide()
                        $(this).attr('off', true)
                    }
                })

            });

    }

</script>


</body>
</html>
<%--
</jsp:root></jsp:root></jsp:root></jsp:root>--%>
