<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>  
<#assign basePath=request.contextPath>
    <head>
	    <title>香菇炖鸡</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <!-- Bootstrap -->
	    <link href="${basePath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
	    <link href="${basePath}/css/docs.css" rel="stylesheet" media="screen">
	    <link href="${basePath}/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
	    <link href="${basePath}/css/other.css" rel="stylesheet" media="screen">
	    <script src="${basePath}/js/jquery-3.2.1.js"></script>

	    <script src="${basePath}/js/bootstrap.js"></script>
	 </head>  
    <body data-spy="scroll" data-target=".bs-docs-sidebar">


  <div class="container ">
    <div class="row ">
      <div class="span1"></div>
      <div class="span2">
        
          <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <a href="${basePath}">香菇炖鸡</a>
                </h3>
            </div>
            <div class="panel-body">
              <img src="${basePath}/img/timg.jpg" class="img-circle" data-toggle="popover" data-placement="right">
              <div>
                
                  <h5 class="text-center ">梁赟</h5>
                
                <p class="text-center">梁赟的博客</p>
              </div>
              <table class="cus-table">
                <tr>
                  <td class="cus-td">${articleCount}</td>
                  <td class="cus-td">${musicCount}</td>
                  <td class="cus-td">${pictureCount}</td> 
                </tr>
                <tr>
                  <td class="cus-td"><span class="glyphicon glyphicon-pencil"></span></td>
                  <td class="cus-td"><span class="glyphicon glyphicon-music"></span></td>
                  <td class="cus-td"><span class="glyphicon glyphicon-camera"></span></td>
                </tr>
              </table>
            </div>
          </div>
          <div class="cus-footer">
            <p class="copy-right">
              
                <span class="glyphicon glyphicon-copyright-mark"></span> 2017 香菇炖鸡
              
              <a href="http://weibo.com/u/2201785692/" target="_blank" class="other-link" data-toggle="tooltip" data-placement="bottom" title="赟梁的新浪微博">
                赟梁
              </a>
            </p>
          </div>

         
      </div>

      <div class="span7 " id="main">
        <#include "/mainDiv.ftl">
      </div>

  </div>


</body>  
<script src="${basePath}/js/app.js"></script>
</html>