function go(form)
{
    with (form)
    {
        
        if (title.value == null || title.value == "" || body.value == null || body.value == "")
        {
            alert("请填写好标题和正文！")
            return false
        } else {
            if (window.confirm('确定发布吗？')) {
                
                var action="PushArticle";         
                action=action+"?title="+title.value+"&body="+body.value;  
                form.action=action;        
                //form.submit();  
                return true;
                } else {

                return false;
            }
        }
    }
}



function onload()
{
    console.log("检查")
    var login = document.getgetElementById("login").value;
    if (login == "no")
    {
        alert("请先登录才可以发布文章！")

    } else {

    }
}