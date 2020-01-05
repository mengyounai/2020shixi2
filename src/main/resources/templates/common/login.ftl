<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
    <style type="text/css">
        *{box-sizing: border-box;}
        a{text-decoration: none;color: black;}
        h1{font-size:14px; font-weight: 900;}
        .top9 a{color: white;}
        .top10 a{color: white;}
        .top{width: 90%; height: 60px;margin: auto;}
        .top1{width:100px; height:40px; float: left; margin-left: 55px;margin-top: 10px;}
        .top2{float: left; margin-left: 55px; background-color: #E0E0E0;padding-right:6px;
            padding-left:18px;border-top-left-radius:50%;border-bottom-left-radius:50%;  margin-top: 10px;}
        .top3{float: left;background-color: #E0E0E0; padding-right:10px;  margin-top: 10px;}
        .top4{float: left;background-color: #E0E0E0;padding-right:18px;
            border-top-right-radius: 50%; border-bottom-right-radius: 50%; margin-top: 10px;}
        .top5{float: left; margin-left: 55px; margin-top: 10px;}
        .top6{float: left; margin-left: 55px; margin-top: 10px;}
        .top7{float: left; margin-left: 55px; margin-top: 10px;}
        .top8{float: left; margin-left: 55px; margin-top: 10px;}
        .top8 form {position: relative;width: 210px;margin: 0 auto;height: 42px;}
        .top8 input {border: none;outline: none;width: 100%;height: 42px;padding-left: 13px;width: 150px;
            border-radius: 42px;border: 2px solid deepskyblue;background: #fff;transition: .3s linear;float: right;}
        .top8 input:focus {width: 210px;}
        .top8 button {border: none;outline: none;height: 42px;width: 42px;cursor: pointer;position: absolute;
            background: none;top: -2px;right: 0;}
        .top8 button:before{content: "\f002";font-family: FontAwesome;color: #324b4e;}
        .top9{float: right; margin-right: 10px;background-color:#FF6699;padding-left:10px;padding-right:25px;border-top-right-radius: 50%; border-bottom-right-radius: 50%; margin-top: 10px;}
        .top10{float: right;border-top-left-radius:50%;border-bottom-left-radius:50%;background-color:#FF6699;padding-left:18px; margin-top: 10px; }
        .center{width: 50%; height: 600px; margin: auto; border: 1px solid #F0F0F0;}
        .center1{width: 66%; height:600px; float: left;}
        .center2{width: 30%; height:600px; float: right;}
    </style>
</head>
<body>
<div class="top">
    <div class="top1">
        <a href="#"><img src="http://image-jishanle2.test.upcdn.net/9718c2a0-9eaa-4afc-8688-c28f2ad6e664.png"/> </a>
    </div>
    <div class="top2">
        <a href="#"><h1>动画</h1></a>
    </div>
    <div class="top3">
        <a href="#"><h1>书籍</h1></a>
    </div>
    <div class="top4">
        <a href="#"><h1>音乐</h1></a>
    </div>
    <div class="top5">
        <a href="#"><h1>人物</h1></a>
    </div>
    <div class="top6">
        <a href="#"><h1>更新信息</h1></a>
    </div>
    <div class="top7">
        <a href="#"><h1>添加信息</h1></a>
    </div>
    <div class="top8">
        <form>
            <input type="text" placeholder="请输入...">
            <button type="submit"></button>
        </form>
    </div>
    <div class="top9">
        <a href="#"><h1>注册</h1></a>
    </div>
    <div class="top10">
        <a href="#"><h1>登录</h1></a>
    </div>
</div>
<HR width="80%" color=#E0E0E0 SIZE=1>
<div class="center">
    <div class="center1">
        <h1 style="color: #FF6699; font-size: 30px; padding-left: 40px; padding-top: 20px;">登录至Bangumi</h1>

            <h1 style="padding-left: 40px; padding-top: 20px;">邮箱</h1>
            <form role="form" method="post" action="/bangumi/user/common/login">
            <input type="text" name="userEmail" style="margin-left: 40px; margin-top: 20px; width: 80%;border: 1px solid #ccc;
                   padding: 7px 0px;border-radius: 3px;padding-left:5px;
                   -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                   -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
                   -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
                   transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s">
            <h1 style="padding-left: 40px; padding-top: 20px;">你的密码</h1>
            <input type="text" name="userPassword" style="margin-left: 40px; margin-top: 20px;width: 80%; border: 1px solid #ccc;
                   padding: 7px 0px;border-radius: 3px;padding-left:5px;
                   -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
                   -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
                   -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
                   transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s">
            <br>
            <input type="submit" value="登录" style="background-color: #FF6699;color: white;margin-left: 40px;
                   margin-top: 20px; width: 100px; height: 50px; padding: auto;border-radius: 10px;">
            </form>
    </div>
    <div style="width:1px;height:600px;float:left;background:#f0f0f0;margin-left:10px;margin-right:10px;"></div>
    <div class="center2">
        <h1 style="color:#0099FF;padding-left: 40px; padding-top: 120px;">还没有Bangumi账户？</h1>
        <input type="submit" value="立即注册" style="background-color: #FF6699;color: white;margin-left: 40px;
                   margin-top: 20px; width: 100px; height: 40px; padding: auto;border-radius: 5px;" onclick="window.location.href='register.html'">
        <h1 style="color:#0099FF;padding-left: 40px; padding-top: 120px;">忘记密码？</h1>
        <input type="submit" value="重置密码" style="background-color: 	#F0F0F0;color: #B8B8B8;margin-left: 40px;
                   margin-top: 20px; width: 100px; height: 40px; padding: auto;border-radius: 5px;" onclick="window.location.href='reset.html'">
    </div>
</div>
</body>
</html>