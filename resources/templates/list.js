layui.use('laydate', function(){
  var laydate = layui.laydate;
  //执行一个laydate实例
  laydate.render({
    elem: '#commit_date' //指定元素
  });
});

layui.use('form', function(){
  var form = layui.form;

  //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
});