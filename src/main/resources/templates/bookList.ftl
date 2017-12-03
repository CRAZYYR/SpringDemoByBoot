<html>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>图书管理系统</title>
<a href="/bookAdd.html">添加</a>

<hr/>
<form method="post" action="/book/list2">
    图书名称:<input type="text" name="name"/>  作者:<input type="text" name="author"/> <input type="submit" value="搜索">


</form>
<hr/>
<table>
    <tr><th>编号</th>
        <th>图书名称</th>
        <th>图书作者</th>
        <th>操作</th>
    </tr>

    <#list  bookList as book>
    <tr>
        <td>${book.id}</td>
        <td>${book.name}</td>
        <td>${book.author}</td>
        <td><a href="/book/delete?id=${book.id}">删除</a>|<a href="/book/preUpdate/${book.id}">修改</a></td>
    </tr>

</#list>
</table>
</html>