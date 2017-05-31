<div class="widget widget-table">                 
  <div class="widget-header">
    <i class="icon-th-list"></i>
    <h3>访客信息</h3>
  </div> <!-- /widget-header -->
  
  <div class="widget-content">
  
    <table class="table table-striped table-bordered">
      <thead>
        <tr>
          <th>ip</th>
          <th>agent</th>
          <th>url</th>
          <th>date</th>
          <th>address</th>
        </tr>
      </thead>
      
      <tbody>
        <#if (vistorList?size > 0)>
          <#list vistorList as v>
            <tr>
              <td>${(a.ip)!}</td>
              <td>${(a.agent)!}</td>
              <td>${(a.url)!}</td>
              <td>${(a.date)!}</td>
              <td>${(a.address)!}</td>
            </tr>
          </#list>
        </#if>
        
      </tbody>
    </table>
  
  </div> <!-- /widget-content -->
  
</div>