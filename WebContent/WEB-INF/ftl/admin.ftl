<#assign basePath=request.contextPath>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>香菇炖鸡 Admin</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />    
    
    <link href="${basePath}/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${basePath}/css/bootstrap-responsive.min.css" rel="stylesheet" />
    
    
    <link href="${basePath}/admin/css/font-awesome.css" rel="stylesheet" />
    
    <link href="${basePath}/admin/css/adminia.css" rel="stylesheet" /> 
    <link href="${basePath}/admin/css/adminia-responsive.css" rel="stylesheet" /> 
    
    <link href="${basePath}/admin/css/pages/dashboard.css" rel="stylesheet" /> 
    <link href="${basePath}/admin/summernote/summernote.css" rel="stylesheet">
    <script src="${basePath}/admin/js/jquery-1.7.2.min.js"></script>

    <script src="${basePath}/admin/js/bootstrap.js"></script>
  
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

<body>
  
<div class="navbar navbar-fixed-top">
  
  <div class="navbar-inner">
    
    <div class="container">
      
      <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
        <span class="icon-bar"></span> 
        <span class="icon-bar"></span> 
        <span class="icon-bar"></span>        
      </a>
      
      <a class="brand" href="#">Adminia Admin</a>
      
      <div class="nav-collapse">
      
        <ul class="nav pull-right">
          
          <li class="divider-vertical"></li>
          
          <li class="dropdown">
            
            <a data-toggle="dropdown" class="dropdown-toggle " href="#">
              香菇炖鸡 <b class="caret"></b>              
            </a>
            
            <ul class="dropdown-menu">
              <li>
                <a href="./account.html"><i class="icon-user"></i> Account Setting  </a>
              </li>
              
              <li>
                <a href="./change_password.html"><i class="icon-lock"></i> Change Password</a>
              </li>
              
              <li class="divider"></li>
              
              <li>
                <a href="${basePath}/login/logout.do"><i class="icon-off"></i> Logout</a>
              </li>
            </ul>
          </li>
        </ul>
        
      </div> <!-- /nav-collapse -->
      
    </div> <!-- /container -->
    
  </div> <!-- /navbar-inner -->
  
</div> <!-- /navbar -->

<div id="content">
  
  <div class="container">
    
    <div class="row">
      
      <div class="span3">
        
        <div class="account-container">
        
          <div class="account-avatar">
            <img src="${basePath}/admin/img/yellow.jpg" alt="" class="thumbnail" />
          </div> <!-- /account-avatar -->
        
          <div class="account-details">
          
            <span class="account-name">香菇炖鸡</span>
            
            <span class="account-role">Administrator</span>
           
          
          </div> <!-- /account-details -->
        
        </div> <!-- /account-container -->
        
        <hr />
        
        <ul id="main-nav" class="nav nav-tabs nav-stacked">
          
          <li class="active">
            <a href="#tab1" data-toggle="tab">
              <i class="icon-home"></i>
              文章
              <span class="label label-warning pull-right">#{(articleList?size)!0}</span>    
            </a>
          </li>
          
          <li>
            <a href="#tab2" data-toggle="tab">
              <i class="icon-th-large"></i>
              日志  
              <span class="label label-warning pull-right">#{(yesterdayVistorCount)!0}</span>
            </a>
          </li>
          
        </ul> 
        
        <hr />
        
        <div class="sidebar-extra">
          <p>Just Fuck IT.</p>
        </div> <!-- .sidebar-extra -->
        
        <br />
    
      </div> <!-- /span3 -->
      
      
      
      <div class="span9">
        <div class="tab-content">
          <div id="tab1" class="tab-pane fade in active">
            <#include "/articleList.ftl">
          </div>

          <div class="tab-pane fade" id="tab2">
             <#include "/systemInfo.ftl">
             <#include "/pager.ftl">
          </div>

        </div>

      </div> <!-- /span9 -->
      
      
    </div> <!-- /row -->
    
  </div> <!-- /container -->
  
</div> <!-- /content -->




  </body>
  <script src="${basePath}/admin/js/admin.js"></script>
</html>
