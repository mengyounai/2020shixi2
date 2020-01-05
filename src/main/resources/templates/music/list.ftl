<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
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


        .head{width: 1000px;height: 600px; float: left;margin-left: 130px;margin-top: 20px;}
        .right{width: 250px; height: 300px; border: 1px solid black; float: left; margin-left: 20px; margin-top: 10px;}
        .span input{margin-top:20px;}
        .P{float: left;margin-left: 8px; margin-top:40px}

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



<div class="head">
    <div style="width:1000px; height: 200px; ">
        <p style="margin-left: 80px; font-size: 20px">我的收藏</p>

        <#list musicInfoList as musicInfoList>
            <#list collectionDTOPage.content as collectionDTOPage>
                <#if musicInfoList.musicId=collectionDTOPage.musicId>
                    <#if collectionDTOPage.collectionStatus=1>
        <div style="margin-left:80px ">

            <a href="/bangumi//user/music/detail?musicId=${musicInfoList.musicId}"><img src="${musicInfoList.musicIcon}" height="100" width="100" style="float: left;margin-top: 15px;"/></a>
            <div class="P">
                <p>${musicInfoList.musicName}</p>
                <p>${musicInfoList.musicAuthor}</p>
            </div>
        </div>
</#if>
</#if>
        </#list>
        </#list>

    </div>

    <tbody>

    <hr style="width: 900px; ">
    <p style="margin-left: 80px; font-size: 20px">动画日志</p>
    <hr style="width: 900px; ">


     <#list musicInfoPage.content as musicInfo>
    <div style="margin-left:80px;width: 800px;height:130px;">
        <a href="/bangumi//user/music/detail?musicId=${musicInfo.musicId}"><img src="${musicInfo.musicIcon}" height="100" width="100" style="float: left;margin-top: 15px;"/></a>
        <div class="P">
            <p>${musicInfo.musicName}</p>
            <p>${musicInfo.musicAuthor}</p>
        </div>

         <#assign result = ""/>
         <#assign collectionId=""/>
         <#assign collection=""/>
             <#list collectionDTOPage.content as c>

                 <#assign status = ""/>

                  <#if musicInfo.musicId=c.musicId>
                 <#if c.collectionStatus=1>
                     <#assign result = "取消收藏"/>
                     <#assign collectionId=c.collectionId/>
                 <#else>
                     <#assign status = "收藏"/>
                 </#if >
             <#else>
                 <#assign status = "收藏"/>
                 </#if>



    </#list>
         <#if result="取消收藏">
             <div style="float:right; margin-right: 30px; margin-top: 45px; font-size: 21px"><a href="/bangumi//user/music/cancel?collectionId=${collectionId}" style="color: salmon">${result}</a></div>
<hr style="width: 800px;margin-left: 55px ">
     <#else >
             <div style="float:right; margin-right: 30px; margin-top: 45px; font-size: 21px"><a href="/bangumi//user/music/create?musicId=${musicInfo.musicId}" style="color: salmon">${status}</a></div>
<hr style="width: 800px;margin-left: 55px ">
     </#if>
    </div>

     </#list>

    </tbody>
</div>
<div class="col-md-12 column">
    <ul class="pagination pull-right">
                <#if currentPage lte 1>
                     <li class="disabled"><a href="#">上一页</a></li>
                <#else>
                     <li><a href="/bangumi//user/music/list?page=${currentPage-1}&size=${size}">上一页</a> </li>
                </#if>

                <#list 1..musicInfoPage.getTotalPages() as index>
                    <#if currentPage==index>
                        <li class="disabled"><a href="#">${index}</a> </li>
                    <#else >
                    <li><a href="/bangumi//user/music/list?page=${index}&size=${size}">${index}</a> </li>
                    </#if>
                </#list>

                <#if currentPage gte musicInfoPage.getTotalPages()>
                    <li class="disabled"><a href="#">下一页</a></li>
                <#else>
                    <li><a href="/bangumi//user/music/list?page=${currentPage+1}&size=&{size}">下一页</a></li>
                </#if>

    </ul>
</div>

</body>
</html>