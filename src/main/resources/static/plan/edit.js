 function getQueryVariable(variable){
         var query = window.location.search.substring(1);
         var vars = query.split("&");
         for (var i=0;i<vars.length;i++) {
             var pair = vars[i].split("=");
             if(pair[0] == variable){return pair[1];}
         }
         return(false);
     }

 var id = getQueryVariable("id");


layui.use('laydate', function(){
  var laydate = layui.laydate;
  //执行一个laydate实例
  laydate.render({
    elem: '#commit_date' //指定元素
  });
   laydate.render({
      elem: '#beginDate' //指定元素
    });
     laydate.render({
        elem: '#endDate' //指定元素
      });
});

layui.use('form', function(){
  var form = layui.form;
  if(id) {
    layui.jquery.ajax({//异步请求返回给后台
            url:'/plan/queryById',
            type:'post',
            data:JSON.stringify(id-0),
            dataType:'json',
            contentType: "application/json; charset=utf-8",
            success:function(data){
            //这里获取到数据执行显示
                if(data.code == 0) {
                     form.val('planForm', data.data);
                }
                return false;
             }
         });
   }


  //监听提交
  form.on('submit(commitPlan)', function(data){
    layui.jquery.ajax({//异步请求返回给后台
        url:'/plan/save',
        type:'post',
        data:JSON.stringify(data.field),
        dataType:'json',
        contentType: "application/json; charset=utf-8",
        success:function(data){
        //这里获取到数据执行显示
            if(data.code == 0) {
                location.href="list";
//                layer.msg("保存成功");
            }
            return false;
         }
     });
     return false;
    });

  });

