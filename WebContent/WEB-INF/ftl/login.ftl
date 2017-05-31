<#assign basePath=request.contextPath>
<!DOCTYPE html>
<!-- saved from url=(0052)http://www.js-css.cn/divcss/admin/bladmin/login.html -->
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>登录页面_Bootstrap响应式布局后台模板BlAdmin - JS代码网</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">    
    
    <link href="${basePath}/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="${basePath}/admin/css/bootstrap-responsive.min.css" rel="stylesheet">
 
    <link href="${basePath}/admin/css/font-awesome.css" rel="stylesheet">
    
    
    <link href="${basePath}/admin/css/adminia-responsive.css" rel="stylesheet"> 
    
    <link href="${basePath}/admin/css/login.css" rel="stylesheet"> 
	
  </head>

<body>
	
<div class="navbar navbar-fixed-top">
	
	<div class="navbar-inner">
		
		<div class="container">
			
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 				
			</a>
			
			<a class="brand" href="${basePath}">香菇炖鸡</a>
			
			<div class="nav-collapse">
			
				<ul class="nav pull-right">
					
					<li class="">
						
						<a href="${basePath}"><i class="icon-chevron-left"></i> 返回首页</a>
					</li>
				</ul>
				
			</div> <!-- /nav-collapse -->
			
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->


<div id="login-container">
	
	
	<div id="login-header">
		
		<h3>登录</h3>
		
	</div> <!-- /login-header -->
	
	<div id="login-content" class="clearfix">
	
		<form action="${basePath}/login/login.do" method="POST">
			<fieldset>
				<div class="control-group">
					<label class="control-label" for="username">用户名</label>
					<div class="controls">
						<input type="text" class="" id="username" name="username">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="password">密码</label>
					<div class="controls">
						<input type="password" class="" id="password" name="password">
					</div>
				</div>
			</fieldset>
			
			<div id="remember-me" class="pull-left">
				<input type="checkbox" name="remember" id="remember">
				<label id="remember-label" for="remember">记住密码</label>
			</div>
			
			<div class="pull-right">
				<button type="submit" class="btn btn-warning btn-large">
					登录
				</button>
			</div>
		</form>
			
	</div> <!-- /login-content -->
		
		
	<div id="login-extra">
		
		<p>@2017 <a href="http://weibo.com/u/2201785692/" target="_blank">赟梁</a></p>
		
		
	</div> <!-- /login-extra -->
	
</div> <!-- /login-wrapper -->

    

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${basePath}/admin/js/jquery-1.7.2.min.js"></script>


<script src="${basePath}/admin/js/bootstrap.js"></script>

  

</body></html>
