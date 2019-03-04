<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/2/27
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>教师教学档案管理系统</title>

    <!-- BOOTSTRAP STYLES-->
    <link href="${ctx}/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="${ctx}/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- PAGE LEVEL STYLES -->
    <link href="${ctx}/assets/css/bootstrap-fileupload.min.css" rel="stylesheet" />
    <!--CUSTOM BASIC STYLES-->
    <link href="${ctx}/assets/css/basic.css" rel="stylesheet" />
    <!--CUSTOM MAIN STYLES-->
    <link href="${ctx}/assets/css/custom.css" rel="stylesheet" />
    <!--弹出层-->
    <link href="${ctx}/assets/css/xcConfirm.css" rel="stylesheet" />
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
            <a class="navbar-brand" href="${ctx}/index.jsp">教师教学档案管理系统</a>
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
                    <a  href="${ctx}/jsp/main/index.jsp"><i class="fa fa-dashboard "></i>个人信息</a>
                </li>
                <li>
                    <a href="#" ><i class="fa fa-desktop "></i>教学任务<span class="fa arrow"></span></a>
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
                    <a href="#" class="active-menu-top"> <i class="fa fa-yelp "></i>成绩管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level ">
                        <li>
                            <a  href="${ctx}/jsp/main/grade_add.jsp"><i class="fa fa-coffee"></i>录入成绩</a>
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
                    <ul class="nav nav-second-level collapse in ">

                        <li>
                            <a href="${ctx}/jsp/main/work_add.jsp" class="active-menu"><i class="fa fa-desktop "></i>作业、实验上传</a>
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


            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        上传论文
                    </div>
                    <div class="panel-body">
                        <form role="form" enctype="multipart/form-data" action="/studentwork" method="post">

                            <div class="form-group">
                                <label>类型</label>
                                <select class="form-control" name="workType">
                                    <option>作业</option>
                                    <option>实验</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>学年</label>
                                <input class="form-control" type="text" name="year">
                                <p class="help-block">如：2019</p>
                            </div>
                            <div class="form-group">
                                <label>学期</label>
                                <select class="form-control" name="semester">
                                    <option>上半年</option>
                                    <option>下半年</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>班级</label>
                                <input class="form-control" type="text" name="className">
                            </div>
                            <div class="form-group">
                                <label>课程</label>
                                <input class="form-control" type="text" name="courseTitle">
                            </div>
                            <div class="form-group">
                                <label >附件</label>
                                <div class="">
                                    <div class="fileupload fileupload-new" data-provides="fileupload">
		                                             	<span class="btn btn-file btn-default">
					                                    <span class="fileupload-new">选择文件</span>
					                                    <span class="fileupload-exists">重新选择</span>
					                                    <input type="file" name="uploadFile">
                                						</span>
                                        <span class="fileupload-preview"></span>
                                        <a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none">×</a>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-info">提交</button>

                        </form>
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
    <!-- PAGE LEVEL SCRIPTS -->
    <script src="${ctx}/assets/js/bootstrap-fileupload.js"></script>
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

