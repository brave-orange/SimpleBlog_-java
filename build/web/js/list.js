var num='';
function show(buff,name)
{	
	if(buff==null)
	{
		alert("参数出错！");
	}
	else
	{
		var str = "http://localhost:8084/SimpleBlog/article/"+buff+".txt";
                                    
		console.log(str);
		loadXMLDoc(str);
		document.getElementById("mask").style.display="block";
		document.getElementById("opendiv").style.display="block";
		document.getElementById("openbtn").style.display="block";
                                     LoadComment(buff);   //加载文章评论
                                     if(name==null || name=="")
                                     {
                                         document.getElementById("comment").disabled="true";
                                         document.getElementById("comm_btn").disabled="true";
                                         alert("未登录无法使用评论功能 ！");
                                     }
	}
        num = buff;
}

function hide(){
	document.getElementById("mask").style.display="none";
	document.getElementById("opendiv").style.display="none";
	document.getElementById("openbtn").style.display="none";
                  $("#comm_list").html("");
}
/*
 * 
 * 推送评论以及加载评论
 * 
 */

function comment(comm)
{
    
    var text = document.getElementById('comment').value;
    
    var url = "PushComment?name="+comm+"&text="+text+"&id="+num;
    console.log(comm);
    /*if(comm==""||comm==null)
    {
        alert("您还没登陆，请先登陆！");
        location.href("Login.jsp");
    }*/
    if(text==""||text==null)
    {
        alert("请填写评论内容！");
        return false;
    }  
    console.log(url);
    $.get(url);
    alert("评论成功！");
    document.getElementById('comment').value = "";
	LoadComment(num);
	
 }

function LoadComment(id)
{
    var url = "LoadComment?id="+id;
    var str="<ul>";
    var data={};
    $.get(url,data,function(res){

        var jsonObj = eval("("+res+")");
        if(jsonObj==null)
        {
        }else
        {
            for(var i=0;i<jsonObj.length;i++)
            {
                str+="<li>"+"<p>"+jsonObj[i]['name']+":  "+jsonObj[i]['body']+"</p></li>"
            }
            str += "</ul><br><br><br><br><br>";
            $("#comm_list").html(str);
        }
        //document.getElementById('comm_list').innerHTML=str;
    });
  
  
}
/*实现在文件中读取文章内容显示在遮罩div上*/
var xmlhttp;
function loadXMLDoc(url)
{
xmlhttp=null;
if (window.XMLHttpRequest)
  {// code for Firefox, Opera, IE7, etc.
  xmlhttp=new XMLHttpRequest();
  }
else if (window.ActiveXObject)
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
if (xmlhttp!=null)
  {
  xmlhttp.onreadystatechange=state_Change;
  xmlhttp.open("GET",url,true);
  xmlhttp.send(null);
  }
else
  {
  alert("Your browser does not support XMLHTTP.");
  }
}

function state_Change()
{
if (xmlhttp.readyState==4)
  {// 4 = "loaded"
  if (xmlhttp.status==200)
    {// 200 = "OK"
    document.getElementById('opendiv1').innerHTML=xmlhttp.responseText;
    }
  else
    {
    alert("Problem retrieving data:" + xmlhttp.statusText);
    }
  }
}