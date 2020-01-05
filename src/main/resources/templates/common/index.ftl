<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>主页面</title>
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
    <style type="text/css">
        *{box-sizing: border-box;}
        a{text-decoration: none;color: black;}
        h1{font-size:14px; font-weight: 900;margin-top: 10px}
        .top9 a{color: white;}
        .top10 a{color: white;}
        .top{width: 90%;margin: auto;}
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
        .center{width: 90%; height: 800px; margin: auto; border: 1px solid #F0F0F0;}
        .centre{width: 66%;float: left; height: 100%;}
        .centre1{width: 30%;float: right;height: 100%;}
        .center1{width: 100%; height: 150px; float: left; margin-top: 20px;}
        .center2{width: 100%; height: 150px; float: left; margin-top: 20px;}
        .center3{width: 100%; height: 150px; float: left; margin-top: 20px;}
        .center4{width: 100%; height: 150px; float: left; margin-top: 20px;}
        .center5{width: 100%; height: 300px; float: right; margin-top: 20px;}
        .center6{margin-left: 40px;}
        .center7{float: left; margin-left: 30px;}
        .span input{margin-top:20px}
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
    <div class="centre">
        <div class="center1">
            <div class="center6"><a href="#"><h1>动画</h1></a></div>
              <#list animeInfoList.content as animeInfoList>
            <div class="center7">
                <a href="#"> <img src="${animeInfoList.animeIcon}" height="100" width="100" style="float: left;margin-top: 15px;"></a>
                <p>${animeInfoList.animeName}</p>
            </div>
            </#list>
            <a href="/bangumi/user/anime/list" style="padding-top: 50px;color: blue">更多...</a>
        </div>

        <div class="center2">
            <div class="center6"><a href="#"><h1>书籍</h1></a></div>
            <#list bookInfoList.content as bookInfoList>
            <div class="center7">
                <a href="#"> <img src="${bookInfoList.bookIcon}" height="100" width="100" style="float: left;margin-top: 15px;"></a>
                <p>${bookInfoList.bookName}</p>
            </div>
            </#list>
            <a href="/bangumi/user/book/list" style="padding-top: 50px;color: blue">更多...</a>
        </div>


        <div class="center3">
            <div class="center6"><a href="#"><h1>音乐</h1></a></div>
             <#list musicInfoList.content as musicInfoList>
            <div class="center7">
                <a href="#"> <img src="${musicInfoList.musicIcon}" height="100" width="100" style="float: left;margin-top: 15px;"></a>
                <p>${musicInfoList.musicName}</p>
            </div>
       </#list>
            <a href="/bangumi/user/music/list" style="padding-top: 50px;color: blue;float: right;">更多...</a>
        </div>
        <div class="center4">
            <div class="center6"><a href="#"><h1>人物</h1></a></div>
            <div class="center7">
                <a href="#"> <img src="3.jpg" height="100" width="100" style="float: left;margin-top: 15px;"></a>
            </div>
            <div class="center7">
                <p>2</p>
                <p>海贼王</p>
                <p>尾田荣一郎</p>
            </div>
            <div class="center7">
                <a href="#"> <img src="3.jpg" height="100" width="100" style="float: left;margin-top: 15px;"></a>
            </div>
            <div class="center7">
                <p>3</p>
                <p>海贼王</p>
                <p>尾田荣一郎</p>
            </div>
            <div class="center7">
                <a href="#"> <img src="3.jpg" height="100" width="100" style="float: left;margin-top: 15px;"></a>
            </div>
            <div class="center7">
                <p>4</p>
                <p>海贼王</p>
                <p>尾田荣一郎</p>
            </div>
        </div>
    </div>
    <div class="centre1">
        <div class="center5">
            <div class="center5-1"><h1>标签</h1></div>
            <div class="span">
        <span>
         <input type="checkbox"  class="ipt-hide">
         <label class="checkbox"></label>选项一
        </span>
                <span>
         <input type="checkbox"  class="ipt-hide">
         <label class="checkbox"></label>选项二
        </span>
                <span>
         <input type="checkbox"  class="ipt-hide">
         <label class="checkbox"></label>选项三
        </span>
                <span>
         <input type="checkbox"  class="ipt-hide">
         <label class="checkbox"></label>选项四
        </span>
                <span>
         <input type="checkbox"  class="ipt-hide">
         <label class="checkbox"></label>选项二
        </span>
                <span>
         <input type="checkbox"  class="ipt-hide">
         <label class="checkbox"></label>选项二
        </span>
                <span>
         <input type="checkbox"  class="ipt-hide">
         <label class="checkbox"></label>选项二
        </span>
                <span>
         <input type="checkbox"  class="ipt-hide">
         <label class="checkbox"></label>选项二
        </span>
                <span>
         <input type="checkbox"  class="ipt-hide">
         <label class="checkbox"></label>选项二
        </span>
                <span>
         <input type="checkbox"  class="ipt-hide">
         <label class="checkbox"></label>选项二
        </span>
                <span>
         <input type="checkbox"  class="ipt-hide">
         <label class="checkbox"></label>选项二
        </span>
                <span>
         <input type="checkbox"  class="ipt-hide">
         <label class="checkbox"></label>选项二
        </span>
            </div>

            <div><a href="#"><p style="font-size: 25px; text-align: center;border: 2px skyblue solid">新增</p></a></div>
        </div>
    </div>
</div>
</body>
</html>