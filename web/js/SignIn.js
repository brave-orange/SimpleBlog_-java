
function blank(input, text)
{

    if (input.value == null || input.value == "")
    {
        alert(text)
        return false
    }
    else
    {
        return true
    }

}

function check_password(pass1, pass2, text)
{

    var a = pass1.value
    var b = pass2.value
    if (a.indexOf("*") >= 0 || a.indexOf(".") >= 0 || a.indexOf("<") >= 0 || a.indexOf(">") >= 0)
    {
        alert("密码中包含限制字符，请重新输入！")
        return false
    }
    if (a == b)
    {
        return true
    }
    else
    {
        alert(text)
        return false
    }

}
function check_name(name, text)
{
    if (name.value.indexOf("'") >= 0 || name.value.indexOf("=") >= 0 || name.value.indexOf("#") >= 0 || name.value.indexOf("|") >= 0)
    {
        alert("用户名中包含限制字符，请重新输入！")
        return false
    }
    if (name.value.length > 10)
    {
        alert(text)
        return false
    }
    else
    {
        return true
    }
}
function check(form)
{
    with (form)
    {

        if (blank(sid, "学号不能为空") == false)
        {
            sid.focus()
            return false
        }
        if (blank(name, "用户名不能为空") == false)
        {
            name.focus()
            return false
        }


        if (blank(password1, "密码不能为空") == false)
        {

            password1.focus()
            return false
        }
        if (blank(password2, "密码不能为空") == false)
        {
            password2.focus()
            return false
        }
        if (blank(captcha, "验证码不能为空") == false)
        {

            captcha.focus()
            return false
        }
        if (check_name(sid, "学号必须为10位数字！") == false)
        {
            sid.focus()
            return false
        }

        if (check_password(password1, password2, "两次密码输入不一致，请重新输入！") == false)
        {
            password1.focus()
            password2.focus()
            return false
        }
    }
}
function check1(form)
{
    with (form)
    {
        if (blank(password, "密码不能为空") == false)
        {
            password.focus()
            return false
        }

        if (check_name(username, "登录名超出长度！！！") == false)
        {
            username.focus()
            return false
        }
        if (blank(username, "登录名不能为空") == false)
        {
            username.focus()
            return false
        }

    }

}