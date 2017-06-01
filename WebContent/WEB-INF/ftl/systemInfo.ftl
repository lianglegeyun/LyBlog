<#assign basePath=request.contextPath>
<div class="btn-toolbar" role="toolbar">
  <button type="button" class="btn btn-default" id="vistDetails">访问详细信息</button>
  <button type="button" class="btn btn-default" id="vistorInfo">访客信息</button>
  <button type="button" class="btn btn-default" id="updateAddr">更新ip地理位置</button>
</div>
<div id="systemInfoDiv">

  <#include "/vistDetails.ftl">
</div>
<script src="${basePath}/admin/js/vistor.js"></script>