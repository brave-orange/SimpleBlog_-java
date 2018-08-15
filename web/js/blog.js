
function indexshow()
{
	
	document.getElementById("mask").style.display="block";
	document.getElementById("indexdiv").style.display="block";
	document.getElementById("indexbtn").style.display="block";
}
function show1(){
	
	loadXMLToIndex("/SimpleBlog/article/1.txt");
	
	indexshow();
	
}
function show2(){
	
	loadXMLToIndex("/SimpleBlog/article/2.txt");
	indexshow();
	
}
function show3(){
	
	loadXMLToIndex("/SimpleBlog/article/3.txt");
	indexshow();
	
}
function show4(){
	
	loadXMLToIndex("/SimpleBlog/article/4.txt");
	indexshow();
	
}
function show5(){
	
	loadXMLToIndex("/SimpleBlog/article/5.txt");
	indexshow();
	
}
function show6(){
	
	loadXMLToIndex("/SimpleBlog/article/6.txt");
	indexshow();
	
}
function show7(){
	
	loadXMLToIndex("/SimpleBlog/article/7.txt");
	indexshow();
	
}
function show8(){
	
	loadXMLToIndex("/SimpleBlog/article/8.txt");
	indexshow();
	
}

function hideindex(){
	document.getElementById("mask").style.display="none";
	document.getElementById("indexdiv").style.display="none";
	document.getElementById("indexbtn").style.display="none";
}

/*ʵ�����ļ��ж�ȡ����������ʾ������div��*/
var xmlhttp;
function loadXMLToIndex(url)
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
  xmlhttp.onreadystatechange=state_Change_Index;
  xmlhttp.open("GET",url,true);
  xmlhttp.send(null);
  }
else
  {
  alert("Your browser does not support XMLHTTP.");
  }
}

function state_Change_Index()
{
if (xmlhttp.readyState==4)
  {// 4 = "loaded"
  if (xmlhttp.status==200)
    {// 200 = "OK"
    document.getElementById('indexdiv').innerHTML=xmlhttp.responseText;
    }
  else
    {
    alert("Problem retrieving data:" + xmlhttp.statusText);
    }
  }
}


/*
 * 页面ajax操作
 */
function GotoIndex()
{     
    loadPageDoc("http://localhost:8084/SimpleBlog/page/Index.xml");
}
function GotoList()
{
    
     //loadPageDoc("http://localhost:8084/SimpleBlog/page/List.xml");    
     location.href="List.jsp"; 
}
function GotoMovie()
{
   
     loadPageDoc("http://localhost:8084/SimpleBlog/page/Movie.xml");
}
function GotoAbout()
{
    
     loadPageDoc("http://localhost:8084/SimpleBlog/page/About.xml");
}
function GotoWrite()
{
     loadPageDoc("http://localhost:8084/SimpleBlog/page/Write.xml");
}


function loadPageDoc(url)
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
  xmlhttp.onreadystatechange=page_Change;
  xmlhttp.open("GET",url,true);
  xmlhttp.send(null);
  }
else
  {
  alert("Your browser does not support XMLHTTP.");
  }
    
}
function page_Change()
{
if (xmlhttp.readyState==4)
  {// 4 = "loaded"
  if (xmlhttp.status==200)
    {// 200 = "OK"
    document.getElementById('main').innerHTML=xmlhttp.responseText;
    }
  else
    {
    alert("Problem retrieving data:" + xmlhttp.statusText);
    }
  }
}
