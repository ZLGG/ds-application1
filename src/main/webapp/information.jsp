<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Document</title>
  <link rel="stylesheet" type="text/css" href="/static/css/main.css">
  <link rel="stylesheet" type="text/css" href="/layui/css/layui.css">
  <script type="text/javascript" src="/layui/layui.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
</head>
<body>

  <div class="site-nav-bg">
    <div class="site-nav w1200">
      <p class="sn-back-home">
        <i class="layui-icon layui-icon-home"></i>
        <a href="/test/index">首页</a>
      </p>
      <div class="sn-quick-menu">
        <div class="login"><c:choose>
          <c:when test="${sessionScope.user!=null}">
            <div class="login">${sessionScope.user.accountId}</div>
          </c:when>
          <c:otherwise>
            <div class="login"><a href="/test/login">登录</a></div>
          </c:otherwise>
        </c:choose>
        </div>
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
            <input type="text" name="title" required  lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入需要的商品">
            <button class="layui-btn" lay-submit lay-filter="formDemo">
                <i class="layui-icon layui-icon-search"></i>
            </button>
            <input type="hidden" name="" value="">
          </form>
        </div>
      </div>
    </div>
  </div>


  <div class="content content-nav-base information-content">
    <div class="main-nav">
      <div class="inner-cont0">
        <div class="inner-cont1 w1200">
          <div class="inner-cont2">
            <a href="/test/commodity">所有商品</a>
            <a href="/test/buytoday">今日团购</a>
            <a href="/test/information"  class="active">母婴资讯</a>
            <a href="/test/about">关于我们</a>
          </div>
        </div>
      </div>
    </div>
    <div class="info-list-box">
      <div class="info-list w1200">
        <div class="item-box layui-clear" id="list-cont">
        <%--  <div class="item">
            <div class="img">
              <img src="/static/img/new1.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>
          <div class="item">
            <div class="img">
              <img src="/static/img/new2.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>
          <div class="item">
            <div class="img">
              <img src="/static/img/new1.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>
          <div class="item">
            <div class="img">
              <img src="/static/img/new2.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>
          <div class="item">
            <div class="img">
              <img src="/static/img/new1.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>
          <div class="item">
            <div class="img">
              <img src="/static/img/new2.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>
          <div class="item">
            <div class="img">
              <img src="/static/img/new1.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>
          <div class="item">
            <div class="img">
              <img src="/static/img/new2.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>
          <div class="item">
            <div class="img">
              <img src="/static/img/new1.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>
          <div class="item">
            <div class="img">
              <img src="/static/img/new2.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>
          <div class="item">
            <div class="img">
              <img src="/static/img/new1.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>
          <div class="item">
            <div class="img">
              <img src="/static/img/new2.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>
          <div class="item">
            <div class="img">
              <img src="/static/img/new1.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>
          <div class="item">
            <div class="img">
              <img src="/static/img/new2.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>
          <div class="item">
            <div class="img">
              <img src="/static/img/new1.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>
          <div class="item">
            <div class="img">
              <img src="/static/img/new2.jpg" alt="">
            </div>
            <div class="text">
              <h4>周岁内的宝宝消化不良拉肚子怎么办?</h4>
              <p class="data">2016-12-24 16:33:26</p>
              <p class="info-cont">宝宝在周岁之前体质相对较弱，特别是薄弱肠道，一不注意就会拉肚子;那么宝宝消化不良拉肚子</p>
            </div>
          </div>--%>
        </div>
        <div id="demo0" style="text-align: center;"></div>
      </div>
    </div>
  </div>
  <!-- 模版引擎导入 -->
   <script type="text/html" id="demo">
    {{# layui.each(d.listCont,function(index,item){}}
    <div class="item">
      <div class="img">
        <img src="/img/new1.jpg" alt="">
      </div>
      <div class="text">
        <h4>{{item.text}}</h4>
        <p class="data">{{item.data}}</p>
        <p class="info-cont">{{item.infoCont}}</p>
      </div>
    </div>
    {{# })}}
  </script>
<script>
  layui.config({
    base: '/static/js/util/' //你存放新模块的目录，注意，不是layui的模块目录
  }).use(['mm','laypage'],function(){
      var
      mm = layui.mm,laypage = layui.laypage;


    // 模版引擎导入
     var html = demo.innerHTML;
     var listCont = document.getElementById('list-cont');
      mm.request({
        //url: '../json/information.json',
          url:'/getInformation',
        success : function(res){
          console.log(res);
          //listCont.innerHTML = mm.renderHtml(html,res)
            laypage.render({
                elem: 'demo0'
                ,count: res.count //数据总数
                , jump: function (obj, first) {
                    mm.request({
                        //url: '../json/information.json',
                        url:'/getInformation',
                        data:{account:obj.curr,pagesize:obj.limit},
                        success : function(res){
                            console.log(res);
                            listCont.innerHTML = mm.renderHtml(html,res);
                        },
                        error: function(res){
                            console.log(res);
                        }
                    })

                }
            });
        },
        error: function(res){
          console.log(res);
        }
      })
});

</script>


</body>
</html>