$(function(){
  load("head","/layout/stylesheets",true);
  load("body","/layout/scripts",true);
  load("#navbar","/layout/navbar");
  load("#sidebar","/layout/sidebar");
  load("#breadcrumbs","/layout/breadcrumbs");
  load(".footer","/layout/footer");
});
function load(el,url,insert){
  $.get(url, function(result){
    if(insert){
      $(el).append(result)
    }else{
      $(el).html(result);
    }
  });
}