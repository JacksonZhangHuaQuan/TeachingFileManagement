<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/2/27
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>教师教学档案管理系统</title>
    <!--弹出层-->
    <link href="${ctx}/assets/css/xcConfirm.css" rel="stylesheet" />
    <!-- BOOTSTRAP STYLES-->
    <link href="${ctx}/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="${ctx}/assets/css/font-awesome.css" rel="stylesheet" />
    <!--CUSTOM BASIC STYLES-->
    <link href="${ctx}/assets/css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="${ctx}/assets/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<div id="wrapper">
    <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${ctx}/jsp/main/index.jsp">教师教学档案管理系统</a>
        </div>

        <div class="header-right">

            <a href="${ctx}/jsp/login.jsp" class="btn btn-danger" title="退出"><i class="fa fa-exclamation-circle fa-2x"></i></a>

        </div>
    </nav>
    <!-- /. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li>
                    <div class="user-img-div">
                        <img src="${ctx}/assets/img/njsjdx.jpg" class="img-thumbnail" />

                        <div class="inner-text">
                            ${currentInfo.name}
                        </div>
                    </div>

                </li>


                <li>
                    <a class="active-menu" href="${ctx}/jsp/admin/index.jsp"><i class="fa fa-dashboard "></i>教师录入</a>
                </li>
                <li>
                    <a href="${ctx}/jsp/admin/teachtask_add.jsp"><i class="fa fa-desktop "></i>教学任务录入</a>
                </li>

            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">

            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        教师录入
                    </div>
                    <div class="panel-body">
                        <form role="form" enctype="multipart/form-data" action="/register" method="post">
                            <div class="form-group">
                                <label>用户名</label>
                                <input class="form-control" type="text" name="username">
                            </div>
                            <div class="form-group">
                                <label>密码</label>
                                <input class="form-control" type="text" name="password">
                            </div>
                            <div class="form-group">
                                <label>教师工号</label>
                                <input class="form-control" type="text" name="jobNumber">
                            </div>
                            <div class="form-group">
                                <label>姓名</label>
                                <input class="form-control" type="text" name="name">
                            </div>
                            <div class="form-group">
                                <label>性别</label>
                                <select class="form-control" name="gender">
                                    <option>男</option>
                                    <option>女</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>生日</label>
                                <input class="form-control" type="date" name="birthday">
                                <p class="help-block">如：1996-10-08</p>
                            </div>
                            <div class="form-group">
                                <label>民族</label>
                                <input class="form-control" type="text" name="nation">
                            </div>
                            <div class="form-group">
                                <label>手机</label>
                                <input class="form-control" type="text" name="mobilePhone">
                            </div>
                            <div class="form-group">
                                <label>邮箱</label>
                                <input class="form-control" type="text" name="email">
                            </div>
                            <div class="form-group">
                                <label>住址</label>
                                <input class="form-control" type="text" name="address">
                            </div>

                            <button type="submit" class="btn btn-info">提交</button>

                        </form>
                    </div>
                </div>
            </div>

        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->

<div id="footer-sec">
    &copy; 2019.FileManagement.com
</div>
<!-- /. FOOTER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="${ctx}/assets/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="${ctx}/assets/js/bootstrap.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="${ctx}/assets/js/jquery.metisMenu.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="${ctx}/assets/js/custom.js"></script>
<!-- 弹出层 -->
<script src="${ctx}/assets/js/xcConfirm.js"></script>
<script>
    var server = ${serverResponse};
    $(function () {
        if (server.success === true ){
            var txt= server.message;
            window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.success);
            console.log(server);
        }
        if (server.success === false){
            var txt= server.message;
            window.wxc.xcConfirm(txt, window.wxc.xcConfirm.typeEnum.error);
        }
    })


</script>


</body>
</html>

