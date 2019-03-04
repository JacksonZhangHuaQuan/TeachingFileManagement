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
                    <a class="active-menu" href="${ctx}/jsp/main/index.jsp"><i class="fa fa-dashboard "></i>个人信息</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-desktop "></i>教学任务<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="${ctx}/jsp/main/new_teachtask.jsp"><i class="fa fa-toggle-on"></i>本学期教学任务</a>
                        </li>
                        <li>
                            <a href="${ctx}/jsp/main/history_teachtask.jsp"><i class="fa fa-bell "></i>历史教学任务</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-yelp "></i>成绩管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="${ctx}/jsp/main/grade_add.jsp"><i class="fa fa-coffee"></i>录入成绩</a>
                        </li>
                        <li>
                            <a href="${ctx}/jsp/main/grade_find.jsp"><i class="fa fa-flash "></i>成绩查询</a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-flash "></i>论文管理<span class="fa arrow"></span> </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="${ctx}/jsp/main/paper_add.jsp"><i class="fa fa-toggle-on"></i>上传论文</a>
                        </li>
                        <li>
                            <a href="${ctx}/jsp/main/paper_find.jsp"><i class="fa fa-bell "></i>论文查询</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-bicycle "></i>作业、实验管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">

                        <li>
                            <a href="${ctx}/jsp/main/work_add.jsp"><i class="fa fa-desktop "></i>作业、实验上传</a>
                        </li>
                        <li>
                            <a href="${ctx}/jsp/main/work_find.jsp"><i class="fa fa-code "></i>作业、实验查询</a>
                        </li>


                    </ul>
                </li>
            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <!--   Basic Table  -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            个人信息
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal" style="margin-left: 20px; margin-top: 10px;">
                                    修改信息
                                </button>
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
                                    <div class="modal-dialog">
                                        <div class="modal-content" style="width: 1000px;  height:500px; margin-left: -30%;">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                <h4 class="modal-title" id="myModalLabel">个人信息修改</h4>
                                            </div>

                                            <div class="modal-body">
                                <form role="form" id="info" action="${ctx}/userinfo" method="post">
                                            <input name="id" type="hidden" value="${currentInfo.id}" />
                                            <input name="jobNumber" type="hidden" value="${currentInfo.jobNumber}" />
                                            <input name="userId" type="hidden" value="${currentUser.id}" />
                                            <div class="form-group col-md-6">
                                                <label>姓名</label>
                                                <input name="name" class="form-control" type="text" style="width: 400px;" value="${currentInfo.name}">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>性别</label>
                                                <input name="gender" class="form-control" type="text" style="width: 400px;" value="${currentInfo.gender}">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>民族</label>
                                                <input name="nation" class="form-control" type="text" style="width: 400px;" value="${currentInfo.nation}">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>生日</label>
                                                <input name="birthday" class="form-control" type="date" style="width: 400px;" value="${currentInfo.birthday}">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>地址</label>
                                                <input name="address" class="form-control" type="text" style="width: 400px;" value="${currentInfo.address}">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>手机</label>
                                                <input name="mobilePhone" class="form-control" type="text" style="width: 400px;" value="${currentInfo.mobilePhone}">
                                            </div>
                                            <div class="form-group col-md-12">
                                                <label>邮箱</label>
                                                <input name="email" class="form-control" type="text" style="width: 900px;" value="${currentInfo.email}">
                                            </div>
                                            <button type="submit" class="btn btn-info" style="margin-left: 890px; margin-top: 50px;" id="updateInfo">确认修改</button>
                                            </form>
                                        </div>
                                    </div>
                                    </div>
                                </div>
            </div>

                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                <tr>
                                    <td><b>教师工号</b></td>
                                    <td colspan="3">${currentInfo.jobNumber}</td>
                                </tr>
                                <tr>
                                    <td><b>姓名</b></td>
                                    <td>${currentInfo.name}</td>
                                    <td><b>性别</b></td>
                                    <td>${currentInfo.gender}</td>
                                </tr>
                                <tr>
                                    <td><b>民族</b></td>
                                    <td>${currentInfo.nation}</td>
                                    <td><b>生日</b></td>
                                    <td>${currentInfo.birthday}</td>
                                </tr>
                                <tr>
                                    <td><b>地址</b></td>
                                    <td>${currentInfo.address}</td>
                                    <td><b>手机</b></td>
                                    <td>${currentInfo.mobilePhone}</td>
                                </tr>
                                <tr>
                                    <td><b>邮箱</b></td>
                                    <td colspan="3">${currentInfo.email}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
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

