<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
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
        .P p{margin-top: -3px}
        .J{width: 500px; float: left; border: 1px solid  azure; margin-left: 80px; margin-top: 40px;}
        .J p{font-size: 18px; margin-left: 20px}
        .L{width: 500px;  float: left; border: 1px solid aliceblue;margin-left: 80px; margin-top: 10px;}
        .center7{float:left; width: 490px;}
        .font{ float: left;margin-top: 5px;}
        .font p{margin-top: 5px;}
        .mig{ float: left}
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
        <img src="${peopleInfo.peopleIcon}" height="343" width="250"/>
        <hr style="color: skyblue; margin-top: -6px;">
        <p>姓名:${peopleInfo.peopleName}</p>
        <hr style="color: skyblue; margin-top: -6px;">
        <p>性别:${peopleInfo.peopleSex}</p>
        <hr style="color: skyblue; margin-top: -6px;">
        <p>生日:${peopleInfo.peopleBirthday}</p>
        <hr style="color: skyblue; margin-top: -6px;">
    </div>

    <div class="J">
        <p>
        ${peopleInfo.peopleDescription}
        </p>
    </div>
    <div class="L">
        <p style="font-size: 18px; margin-left: 20px">出演:</p>
        <div class="center7">
            <div class="mig">
                <a href="#"> <img src="image/3.jpg" height="80" width="80" ></a>
            </div>
            <div class="font">
                <p>海贼王</p>
                <p>尾田荣一郎</p>
            </div>
        </div>


    </div>



</body>
</html>