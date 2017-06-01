<div class="widget widget-table" id="vistorTable">                 
  <div class="widget-header">
    <i class="icon-th-list"></i>
    <h3>访客信息</h3>
  </div> <!-- /widget-header -->
  
  <div class="widget-content">
  
    <table class="table table-striped table-bordered">
      <thead>
        <tr>
          <th>ip</th>
          <th>hits<th>
          <th>address</th>
        </tr>
      </thead>
      
      <tbody>
        <#if (vistorList?size > 0)>
          <#list vistorList as v>
            <tr>
              <td>${(v.ip)!}</td>
              <td>${(v.hits)!}</td>
              <td>${(v.address)!}</td>
            </tr>
          </#list>
        </#if>
        
      </tbody>
    </table>
  
  </div> <!-- /widget-content -->
  
</div>
