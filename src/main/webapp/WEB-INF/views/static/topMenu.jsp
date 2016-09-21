<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">План нагрузки</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="planDropDown">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">План<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/createPlan/select">Ввести дані по плану</a></li>
                        <li><a href="/showPlan/select">Розрахувати години</a></li>
                        <li><a href="#">Копіювати план</a></li>
                    </ul>
                </li>
            </ul>
        <div class="collapse navbar-collapse" id="adminDropDown">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Адміністрування<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/facultet/">Факультети</a></li>
                        <li><a href="/kafedra/select">Кафедри</a></li>
                        <li><a href="/discipline/select">Дисципліни</a></li>
                        <li><a href="/group/">Групи</a></li>
                        <li><a href="/ly/">Навчальний рік</a></li>
                        <li><a href="/users/">Користувачі</a></li>
                    </ul>
                </li>
            </ul>
        <div class="collapse navbar-collapse" id="zvitDropDown">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Звіт<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Загальне навантаження по кафедрах</a></li>
                        <li><a href="#">Навантаження по категоріях</a></li>
                        <li><a href="#">Аналітичний звіт</a></li>
                        <li><a href="#">Контингент студентів</a></li>
                        <li><a href="#">Архів рік</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>