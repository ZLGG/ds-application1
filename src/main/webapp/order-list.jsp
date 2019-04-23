<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.1</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="/css/font.css">
    <link rel="stylesheet" href="/css/xadmin.css">
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/js/xadmin.js"></script>
    <script type="text/javascript" src="/js/cookie.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<script type="text/html" id="barDemo">
    <%--<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail"><i class="layui-icon">&#xe60a;</i></a>--%>
    <%-- <a class="layui-btn layui-btn-xs" lay-event="edit"><i class="layui-icon">&#xe642;</i></a>--%>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon">退款</i></a>
</script>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so">
            <input class="layui-input"  name="start" id="start" placeholder="开始时间">
            <input class="layui-input"  name="end" id="end" placeholder="结束时间">
            <div class="layui-input-inline">
                <select name="isPay" id="isPay">
                    <option value=2>支付状态</option>
                    <option value=1>已支付</option>
                    <option value=0>未支付</option>
                </select>
            </div>
          <%--  <div class="layui-input-inline">
                <select name="contrller2">
                    <option>支付方式</option>
                    <option>支付宝</option>
                    <option>微信</option>
                    <option>货到付款</option>
                </select>
            </div>--%>
            <div class="layui-input-inline">
                <select name="status" id="status">
                    <option value="0">订单状态</option>
                    <option value="1">待付款</option>
                    <option value="2">已付款</option>
                    <option value="4">发货中</option>
                    <option value="41">已发货</option>
                    <option value="5">已收货</option>
                    <option value="6">已完成</option>
                    <option value="9">已取消</option>

                </select>
            </div>
            <input type="text" name="orderId"  placeholder="请输入订单号" autocomplete="off" class="layui-input" id="orderId">
            <div class="layui-btn"  lay-submit="" lay-filter="search"><i class="layui-icon">&#xe615;</i></div>
        </form>
    </div>
    <%--<xblock>
        <button class="layui-btn" onclick="x_admin_show('添加订单','/test/order-add')"><i class="layui-icon"></i>添加</button>
    </xblock>--%>
  <%--  <table class="layui-table">
        <thead>
        <tr>
            <th>
                <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>订单编号</th>
            <th>收货人</th>
            <th>总金额</th>
            <th>应付金额</th>
            <th>订单状态</th>
            <th>支付状态</th>
            <th>发货状态</th>
            <th>支付方式</th>
            <th>配送方式</th>
            <th>下单时间</th>
            <th >操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
            </td>
            <td>2017009171822298053</td>
            <td>老王:18925139194</td>
            <td>7829.10</td>
            <td>7854.10</td>
            <td>待确认</td>
            <td>未支付</td>
            <td>未发货</td>
            <td>其他方式</td>
            <td>申通物流</td>
            <td>2017-08-17 18:22</td>
            <td class="td-manage">
                <a title="查看"  onclick="x_admin_show('编辑','order-view.html')" href="javascript:;">
                    <i class="layui-icon">&#xe63c;</i>
                </a>
                <a title="删除" onclick="member_del(this,'要删除的id')" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
        </tbody>
    </table>--%>

    <table class="layui-table" lay-data="{url:'/getOrderList',page:true,toolbar: '#toolbarDemo',id:'test'}" lay-filter="test" >
        <thead>
        <tr>
            <th lay-data="{type:'checkbox'}"></th>
            <th lay-data="{field:'orderNo', width:180, sort: true}">订单编号</th>
            <th lay-data="{field:'returnPerson', width:120, edit: 'text'}">收货人</th>
            <%--<th lay-data="{field:'email', edit: 'text', minWidth: 80}">邮箱</th>--%>
            <%--<th lay-data="{field:'itemAmount', width:80, sort: true}">总商品数量</th>--%>
            <th lay-data="{field:'payAmount', width:100, sort:true}">支付金额</th>
            <th lay-data="{field:'status', width:80,minWidth: 100}">订单状态</th>
            <th lay-data="{field:'isPay',  width:80}">支付状态</th>
            <th lay-data="{field:'address', edit: 'text'}">收货地址</th>
            <th lay-data="{field:'payTime', sort: true,  width:180}">下单时间</th>
            <th lay-data="{field:'createTime', sort: true,  width:180}">创建时间</th>
            <th lay-data="{width:80,toolbar:'#barDemo'}">操作</th>
        </tr>
        </thead>
    </table>
</div>
<script>
    layui.use(['laydate','table','form'], function(){
        var laydate = layui.laydate;
        var table = layui.table;
        var form = layui.form;
        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
            ,type: 'datetime'
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
            ,type: 'datetime'
        });
        table.on('edit(test)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
            //调用ajax修改
        });
        form.on('submit(search)',function (data) {
            table.reload('test', {
                where: { //设定异步数据接口的额外参数，任意设
                    orderId: $("#orderId").val()
                    ,start: $("#start").val()
                    ,end: $("#end").val()
                    ,isPay: $("#isPay").val()
                    ,status: $("#status").val()
                    //,bbb: 'yyy'
                    //…
                }
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        });
        table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                , layEvent = obj.event; //获得 lay-event 对应的值
            if (layEvent === 'detail') {
                testShow()
            } else if (layEvent === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del(); //删除对应行（tr）的DOM结构
                    layer.close(index);
                    //向服务端发送删除指令
                    $.ajax(
                        {
                            type: 'get',
                            url: '/returnOrder',
                            datatype: "json",
                            data: {id: obj.data.id},
                            success: function (result) {
                                if (result.code == 0) {
                                    layer.msg("成功");
                                }
                                else {
                                    layer.msg("失败");
                                }

                            },
                            error: function () {
                                layer.msg('异常');
                            }
                        }
                    );

                });
            } else if (layEvent === 'edit') {
                layer.msg('删除重新添加', {time: 1000});
                /* layer.msg('编辑操作');
                 layer.open({
                     type: 2,
                     area: [($(window).width() * 0.9) + 'px', ($(window).height() - 50) + 'px'],
                     fix: false, //不固定
                     maxmin: true,
                     shadeClose: true,
                     shade: 0.4,
                     title: "编辑",
                     content: '/test/item-edit',
                     success: function () {
                         //窗口加载成功刷新frame
                         // location.replace(location.href);
                     },
                     cancel: function () {
                         //关闭窗口之后刷新frame
                         // location.replace(location.href);
                     },
                     end: function () {
                         //窗口销毁之后刷新frame
                         // location.replace(location.href);
                     }
                 });*/
            }
        });
    });


    /*layui.use('table', function(){
        var table = layui.table;

        //监听单元格编辑
        table.on('edit(test)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
            //调用ajax修改
        });
    });*/




</script>
<script>var _hmt = _hmt || []; (function() {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();</script>
</body>

</html>