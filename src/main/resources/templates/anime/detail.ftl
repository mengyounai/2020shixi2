<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css">

    <link href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.7/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css"/>

    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/fileinput.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.8/js/locales/zh.min.js"></script>
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


        .head{width: 1000px; height: 600px; margin: auto;}
        .P{margin-left: 100px;margin-top: 40px;float: left}
        .P p{ margin-top: -20px}
        .J{width: 600px; float: left; border: 1px solid #e0e0e0; margin-left: 80px; margin-top: 40px;}
        .J p{font-size: 18px; margin-left: 20px}
        .L{width: 600px; float: left;margin-left: 80px; margin-top: 10px;}
        .L p{font-size: 18px; margin-left: 20px}
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

<div class="head">
    <div class="P">
        <img src="${animeinfo.animeIcon}" height="150" width="150"/>
        <p style="margin-top:20px">中文名:${animeinfo.animeName}</p>
        <hr>
        <p>上映时间:${animeinfo.animeTime}</p>
        <hr>
        <p>作者:${animeinfo.animeAuthor}</p>
        <hr>
        <p>动漫类型:${animeinfo.labelType}</p>
        <hr>
        <p>出场角色:${animeinfo.animeCharacter}</p>
        <hr>


        <#if animeinfo.animeStatus=0>
            <p style="color: green">上架状态：上架中 </p>
         <#else >  <p style="color: #9d9d9d">上架状态：下架 </p>
        </#if>

    </div>


    <div class="J"><h1 style="margin-left: 10%;">简介：</h1>
        <p style="font-size: 13px; width: 80%;margin: auto;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${animeinfo.animeDescription}</p></div>

    <#--<#list commentPage.content as commentPage>-->
    <#--<#if commentPage.commentStatus=0>-->
    <#--<div class="L"><h1 style="margin-left: 10%;">${commentPage.userId}:${commentPage.commentDescription}</h1><a href="/bangumi/user/common/cancel">撤销</a></div>-->
    <#--</#if>-->
    <#--</#list>-->


        <#--<div class="form-group">-->
            <#--<label for="exampleInputEmail1"></label><input name="commentDescription" type="text" class="form-control" value=""/>-->
        <#--</div>-->
        <#--<button type="submit" class="btn btn-default">提交</button>-->

<#--</div>-->


<div class="L"><h1 style="margin-left: 10%;">评论：</h1>
         <#list commentPage.content as commentPage>
             <#if commentPage.commentStatus=0>
    <div style="margin-top: 5px;">

        <p style="font-size:5px;">${commentPage.userId}</p>
        <p style="font-size: 5px;">${commentPage.commentDescription}</p>
        <a href="/bangumi/user/comment/down?commentId=${commentPage.commentId}" style="float: right;font-size: 5px;">撤销</a>
        <hr style="width: 80%;color: #0f0f0f;">
    </div>
        </#if>
    </#list>
<#assign result = ""/>
 <#assign status = ""/>
    <div style=" width:85%;margin: auto;">
        <#list commentPage.content as commentPage>
        <#if commentPage.commentStatus=0>
            <#assign result = "1"/>
            <#else>
                <#assign status = "2"/>
        </#if>
        </#list>
        <#if result="1">
        <h1 style="margin-left: 10%;">你的评论：</h1>
        <#else>
        </#if>

        <form role="form" method="post" action="/bangumi/user/comment/save">
            <div class="form-group">
                <label for="exampleInputEmail1"></label><input name="animeId" type="text" class="form-control" value="${animeinfo.animeId}" style="display: none"/>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1"></label><input name="userId" type="text" class="form-control" value="1" style="display: none"/>
            </div>
        <textarea  name="commentDescription" cols="70"   rows="4"   style="OVERFLOW:   hidden;"></textarea>
        <br>
        <input type="submit" value="提交" style="margin-left: 90%;margin-top: 10px;" class="btn btn-default">
    </div>
    </form>

</div>

</body>
</html>