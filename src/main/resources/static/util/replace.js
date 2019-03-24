//function replace() {
//    alert($);
////layui.jquery.ajax({})
//}
layui.use('layer', function(){
     var $ = layui.jquery;

      $(document).on('click','#replace',function(){
            var oldText = $("#old_text").val();
            var newText = $("#new_text").val();
            var re = new RegExp(oldText, "g");
            var replaceText = "<span style='color:red' onclick=\"javascript:this.innerHTML=(this.innerHTML=='"+newText+"'?'"+oldText+"':'"+newText+"');\">"+newText+"</span>";
//            alert($('#input_text').text)
//            console.log($('#input_text'))
//            $('#out_text')[0].innerHTML =$('#input_text')[0].innerHTML.replace(new RegExp("<div>", "g"),"/n");
            $('#out_text')[0].innerHTML = $('#input_text')[0].outerHTML.replace(re,replaceText);
     });
 });