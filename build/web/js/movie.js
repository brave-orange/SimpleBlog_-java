function showmov()
{
                   
	document.getElementById("mask").style.display="block";
	document.getElementById("playpage").style.display="block";
	document.getElementById("movbtn").style.display="block";
}
function showmov1()
{ 
	document.getElementById("player").src="http://brave-orangedhxy.mp4";
	showmov();
}
function showmov2()
{
    document.getElementById("player").src="xjzw.mp4";
	showmov();
}
function hidemov(){
	document.getElementById("mask").style.display="none";
	document.getElementById("playpage").style.display="none";
	document.getElementById("movbtn").style.display="none";
	document.getElementById("player").src="";
	pause();
}
function pause(){
	document.getElementById("player").pause();
}