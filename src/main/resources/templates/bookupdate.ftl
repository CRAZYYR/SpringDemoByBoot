<html>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<title>图书管理系统修改</title>

<form method="post" action="/book/update">
    <input type="text" name="id" value="${bookList.id}"  hidden>
    <label>图书名称:</label><input name="name" type="text"  value="${bookList.name}">
    <label>作者:</label><input name="author" type="text" value="${bookList.author}">
    <input type="submit" value="提交">


</form>
</html>