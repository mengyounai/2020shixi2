<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>成功提示</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        *{box-sizing: border-box;}
        a{text-decoration: none;color: black;}
        h1{font-size:20px; font-weight: 900;}
        .top9 a{color: white;}
        .top10 a{color: white;}
        .top{width: 80%; height: 60px;margin: auto;}
        .top1{width:140px; height:40px; float: left; margin-left: 20px;margin-top: 12px;}
        .top2{float: left; margin-left: 20px; background-color: #E0E0E0;padding-right:10px;
            padding-left:25px;border-top-left-radius:50%;border-bottom-left-radius:50%; }
        .top3{float: left;background-color: #E0E0E0; padding-right:10px; }
        .top4{float: left;background-color: #E0E0E0;padding-right:25px;
            border-top-right-radius: 50%; border-bottom-right-radius: 50%;}
        .top5{float: left; margin-left: 20px;}
        .top6{float: left; margin-left: 20px;}
        .top7{float: left; margin-left: 40px;}
        .top8{float: left; margin-left: 20px; margin-top: 8px;}
        .top8 form {position: relative;width: 300px;margin: 0 auto;height: 42px;}
        .top8 input {border: none;outline: none;width: 100%;height: 42px;padding-left: 13px;width: 250px;
            border-radius: 42px;border: 2px solid deepskyblue;background: #fff;transition: .3s linear;float: right;}
        .top8 input:focus {width: 300px;}
        .top8 button {border: none;outline: none;height: 42px;width: 42px;cursor: pointer;position: absolute;
            background: none;top: -2px;right: 0;}
        .top8 button:before{content: "\f002";font-family: FontAwesome;color: #324b4e;}
        .top9{float: right; margin-right: 20px;background-color:#FF6699;padding-left:10px;padding-right:25px;border-top-right-radius: 50%; border-bottom-right-radius: 50%;}
        .top10{float: right;border-top-left-radius:50%;border-bottom-left-radius:50%;background-color:#FF6699;padding-left:25px; }


    </style>
</head>
<body>

<div class="top">
    <div class="top1">
        <a href="#"><img src="http://image-jishanle2.test.upcdn.net/9718c2a0-9eaa-4afc-8688-c28f2ad6e664.png" height="37" width="143"/></a>
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



<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-success">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">x</button>
                <h4>
                    成功！
                </h4 ><strong>${msg!""}</strong><a href="${url}" class="alert-link">3s后跳转</a>
            </div>
        </div>
    </div>
</div>

</body>
<script>
    setTimeout('location.href="${url}"',3000);
</script>
</html>