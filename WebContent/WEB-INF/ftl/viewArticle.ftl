<#assign basePath=request.contextPath>
<div class="panel panel-default ">
  <div class="panel-body">
    <div class="page-header">
      <h3>${(article.title)!""}</h3>
      <ul class="ul-breadcrumb">
        <li class="li-breadcrumb">
          <span class="glyphicon glyphicon-calendar"></span> ${(article.createTime?string("yyyy-MM-dd"))!}
        </li>
        <li class="li-breadcrumb">
          <span class="glyphicon glyphicon-eye-open"></span> ${(article.viewedCount)!"0"}
        </li>
        <li class="li-breadcrumb">
          <span class="glyphicon glyphicon-comment"></span> 0
        </li>
      </ul>
    </div>

    ${(article.content)!""}

  </div>
</div>