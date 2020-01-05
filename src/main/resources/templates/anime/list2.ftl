<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
    <style type="text/css">

        *{box-sizing: border-box;}
        a{text-decoration: none;color: black;}
        h1{font-size:14px; font-weight: 900;margin-top: 10px}
        .top9 a{color: white;}
        .top10 a{color: white;}
        .top{width: 80%;margin: auto;}
        .top1{width:100px; height:40px; float: left; margin-left: 55px;margin-top: 10px;}
        .top2{float: left; margin-left: 55px; background-color: #E0E0E0;padding-right:6px;
            padding-left:18px;border-top-left-radius:50%;border-bottom-left-radius:50%;  margin-top: 10px;}
        .top3{float: left;background-color: #E0E0E0; padding-right:10px;  margin-top: 10px;}
        .top4{float: left;background-color: #E0E0E0;padding-right:18px;
            border-top-right-radius: 50%; border-bottom-right-radius: 50%; margin-top: 10px;}
        .top5{float: left; margin-left: 55px; margin-top: 10px;}
        .top6{float: left; margin-left: 55px; margin-top: 10px;}
        .top7{float: left; margin-left: 55px; margin-top: 10px;}
        .top8{float: left; margin-left: 55px; margin-top: 8px;}
        .top8 form {position: relative;width: 210px;margin: 0 auto;height: 42px;}
        .top8 input {border: none;outline: none;width: 100%;height: 42px;padding-left: 13px;width: 150px;
            border-radius: 42px;border: 2px solid deepskyblue;background: #fff;transition: .3s linear;float: right;}
        .top8 input:focus {width: 210px;}
        .top8 button {border: none;outline: none;height: 42px;width: 42px;cursor: pointer;position: absolute;
            background: none;top: -2px;right: 0;}
        .top8 button:before{content: "\f002";font-family: FontAwesome;color: #324b4e;}
        .top9{float: right; margin-right: 10px;background-color:#FF6699;padding-left:10px;padding-right:18px;border-top-right-radius: 50%; border-bottom-right-radius: 50%; margin-top: 10px;}
        .top10{float: right;border-top-left-radius:50%;border-bottom-left-radius:50%;background-color:#FF6699;padding-left:18px; margin-top: 10px; }
       </style>
</head>
<body>
<div class="top">
    <div class="top1">
        <a href="#"><img src="http://image-jishanle2.test.upcdn.net/9718c2a0-9eaa-4afc-8688-c28f2ad6e664.png" height="37" width="143"/></a>
    </div>
    <div class="top2">
        <a href="../anime/list"><h1>动画</h1></a>
    </div>
    <div class="top3">
        <a href="../book/list"><h1>书籍</h1></a>
    </div>
    <div class="top4">
        <a href="../music/list"><h1>音乐</h1></a>
    </div>
    <div class="top5">
        <a href="../people/list"><h1>人物</h1></a>
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
<div style="width: 80%;margin: auto;">
<h3>动漫列表</h3>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-11 column">
            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>动漫id</th>
                    <th>动漫名称</th>
                    <th>图片</th>
                    <th>上映时间</th>
                    <th>作者</th>
                    <th>类目</th>
                    <th>上映状态</th>
                    <th colspan="2">操作</th>
                </tr>
                </thead>
                <tbody>
                <#list animeInfoPage.content as animeInfoPage>
                <tr>
                    <td>${animeInfoPage.animeId}</td>
                    <td>${animeInfoPage.animeName}</td>
                    <td><img height="100" width="100" src="${animeInfoPage.animeIcon}" alt=""></td>
                    <td>${animeInfoPage.animeTime}</td>
                    <td>${animeInfoPage.animeAuthor}</td>
                    <td>${animeInfoPage.labelType}</td>
                    <td>
                        <#if animeInfoPage.animeStatus=0>上架中
                            <a href="/bangumi//admin/anime/down?animeId=${animeInfoPage.animeId}" style="color: red;">下架</a>
                        <#else >下架中
                            <a href="/bangumi//admin/anime/up?animeId=${animeInfoPage.animeId}" style="color: green;">上架</a>
                        </#if>
                    </td>
                    <td>
                        <a href="/bangumi//admin/anime/index?animeId=${animeInfoPage.animeId}">修改</a>
                    </td>

                </tr>
                </#list>
                <a href="/bangumi//admin/anime/index">新增</a>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
