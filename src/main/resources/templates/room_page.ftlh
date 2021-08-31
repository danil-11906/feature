<#--<!doctype html>-->
<#--<html lang="ru">-->
<#--<head>-->
<#--    <meta charset="UTF-8">-->
<#--    <meta name="viewport"-->
<#--          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">-->
<#--    <meta http-equiv="X-UA-Compatible" content="ie=edge">-->
<#--    <title>Document</title>-->
<#--    <script-->
<#--            src="https://code.jquery.com/jquery-3.5.1.js"-->
<#--            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="-->
<#--            crossorigin="anonymous"></script>-->
<#--    <link rel="stylesheet" href="/css/menu.css">-->
<#--</head>-->
<#--<body>-->

<#--&lt;#&ndash;<div class="back">&ndash;&gt;-->
<#--&lt;#&ndash;    <header>&ndash;&gt;-->
<#--&lt;#&ndash;        <div class="logo">Анализы Z</div>&ndash;&gt;-->
<#--&lt;#&ndash;        <nav class="menu" id="my-menu">&ndash;&gt;-->
<#--&lt;#&ndash;            <li><a class="nav-menu" href="/profile">&ndash;&gt;-->
<#--&lt;#&ndash;                    <svg margin-top="1px" width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">&ndash;&gt;-->
<#--&lt;#&ndash;                        <path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"/>&ndash;&gt;-->
<#--&lt;#&ndash;                        <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>&ndash;&gt;-->
<#--&lt;#&ndash;                        <path fill-rule="evenodd" d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"/>&ndash;&gt;-->
<#--&lt;#&ndash;                    </svg>&ndash;&gt;-->
<#--&lt;#&ndash;                    <span>МОЙ ПРОФИЛЬ</span>&ndash;&gt;-->
<#--&lt;#&ndash;                </a></li>&ndash;&gt;-->
<#--&lt;#&ndash;            <li><a class="nav-menu" href="/profile">ПРОФИЛЬ</a></li>&ndash;&gt;-->
<#--&lt;#&ndash;            <li><a class="nav-menu" href="/list">СПИСОК УСЛУГ</a></li>&ndash;&gt;-->
<#--&lt;#&ndash;            <li><a class="nav-menu" href="/doctors">ВРАЧИ</a></li>&ndash;&gt;-->
<#--&lt;#&ndash;        </nav>&ndash;&gt;-->
<#--&lt;#&ndash;        <div class="bm">&ndash;&gt;-->
<#--&lt;#&ndash;            <a href="#" class="burger_menu" id="burger_menu">&ndash;&gt;-->
<#--&lt;#&ndash;                <svg width="30px" height="30px" viewBox="0 0 16 16" class="bi bi-list" fill="currentColor" xmlns="http://www.w3.org/2000/svg">&ndash;&gt;-->
<#--&lt;#&ndash;                    <path fill-rule="evenodd" d="M2.5 11.5A.5.5 0 0 1 3 11h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4A.5.5 0 0 1 3 7h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4A.5.5 0 0 1 3 3h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>&ndash;&gt;-->
<#--&lt;#&ndash;                </svg>&ndash;&gt;-->
<#--&lt;#&ndash;            </a>&ndash;&gt;-->
<#--&lt;#&ndash;        </div>&ndash;&gt;-->
<#--&lt;#&ndash;    </header>&ndash;&gt;-->
<#--&lt;#&ndash;</div>&ndash;&gt;-->
<#--<div>-->
<#--    ${roomInfo.name}-->
<#--</div>-->
<#--<form action="/writeMessage/${roomInfo.id}" method="post">-->
<#--    <div class="container">-->
<#--        <label><b>Message</b></label>-->
<#--        <input type="text" name="text" placeholder="Message">-->
<#--        <hr>-->
<#--        <button class="button" type="submit">Добавить</button>-->
<#--    </div>-->
<#--</form>-->
<#--<ul class="newTree" id="newTree">-->
<#--    <li><span>Список пользователей</span>-->
<#--        <ul>-->
<#--            <#list usersList as users>-->
<#--                <li>${users.name}</li>-->
<#--            </#list>-->
<#--        </ul>-->
<#--    </li>-->
<#--</ul>-->
<#--<script>-->
<#--    newTree.onclick = function (value) {-->
<#--        let element = value.target.tagName;//узнать HTML-тег-->
<#--        let children = value.target.parentNode.querySelector("ul");-->
<#--        if (element !== 'SPAN') {-->
<#--            return;-->
<#--        }-->
<#--        if (!children) return; //без узла-->
<#--        children.hidden = !children.hidden;-->
<#--    }-->
<#--</script>-->
<#--<div>-->
<#--    <table id="table">-->
<#--        <tr>-->
<#--            <th>Name</th>-->
<#--            <th>Text</th>-->
<#--            <th>Date</th>-->
<#--        </tr>-->
<#--        <#list messages as mess>-->
<#--            <tr>-->
<#--                <td>${mess.account.name}</td>-->
<#--                <td>${mess.text}</td>-->
<#--                <td>${mess.date}</td>-->
<#--            </tr>-->
<#--        </#list>-->
<#--    </table>-->
<#--</div>-->
<#--</body>-->
<#--</html>-->