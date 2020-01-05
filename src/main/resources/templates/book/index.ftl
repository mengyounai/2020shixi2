<head>
    <meta charset="UTF-8">
    <title>书籍列表</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/sell/css/style.css">
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
        </style>
</head>
<script>
    $(function () {
        var initialPreview =[];
        if ('${(bookInfo.bookIcon)!""}'!=''){
            initialPreview="<img class='kv-preview-data file-preview-image'src='${(bookInfo.bookIcon)!""}'>"
        }

        $("#input-id").fileinput({
            uploadUrl: '/bangumi/image/upload',               //上传接口
            language: 'zh',                                //设置语言
            browseClass: "btn btn-primary btn-block",      //按钮样式
            showCaption: false,                           //是否显示标题
            showRemove: false,                            //是否显示移除按钮
            showUpload: false,                            //是否显示上传按钮
            allowedFileExtensions: [ 'jpg','jpeg','png','gif'],//接收文件后缀
            maxFilesize: 1024,                             //最大尺寸，单位KB，0为不限制
            autoReplace: true,                            //允许自动替换
            overwriteInitial: true,                       //是否覆盖已存在图片
            maxFileCount: 1,                              //允许上传的图片数
            initialPreview: initialPreview,               //要显示的图片路径
        });

        //上传完成设置表单内容
        $('#input-id').on('fileuploaded', function(event,data,previewId,index){
            if(data.response.code !=0){
                alert(data.response.msg)
                return
            }
            $('#bookIcon').val(data.response.data.fileUrl)
        });
    });

</script>
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
<div id="page-content-wrapper" style="width: 70%;margin: auto;">
    <div class="container-fluid">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <form role="form" method="post" action="/bangumi/admin/book/save">
                    <div class="form-group">
                        <label for="exampleInputEmail1">名称</label><input name="bookName" type="text" class="form-control" value="${(bookInfo.bookName)!''}"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">上映时间</label><input name="bookTime" type="text" class="form-control" value="${(bookInfo.bookTime)!''}"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">作者</label><input name="bookAuthor" type="text" class="form-control" value="${(bookInfo.bookAuthor)!''}"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">描述</label><input name="bookDescription" type="text" class="form-control" value="${(bookInfo.bookDescription)!''}"/>
                    </div>
                    <div class="form-group" style="width: 400px;height: 300px;">
                        <label>图片</label><input id="bookIcon" name="bookIcon" type="text" hidden="hidden" value="${(bookInfo.bookIcon)!''}">
                        <div class="file-loading">
                            <input id="input-id" type="file"> <p>支持jpg、jpeg、png、gif格式，大小1M</p>
                        </div>
                    </div>
                    <div style="margin-top: 120px;">
                        <label>类目</label>
                        <select name="labelType" class="form-control">
                                <#list labelList as labelList>
                                    <option value="${labelList.labelType}"
                                            <#if (bookInfo.labelType)?? && bookInfo.labelType==labelList.labelType>
                                                selected
                                            </#if>
                                    >${labelList.labelName}
                                    </option>
                                </#list>
                        </select>
                    </div>
                    <input hidden type="text" name="bookId" value="${(bookInfo.bookId)!''}">
                    <button type="submit" class="btn btn-default">提交</button>
                </form>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>