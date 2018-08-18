	<nav class="navbar navbar-default" role="navigation">

		<!-- Класс "container-fluid" - адаптивный контейнер -->

		<div class="container-fluid">

		<!-- Блок с кнопкой "Brand" и кнопкой для развертывания меню (для мобильных устройств) -->

		<div class="navbar-header">
		<a class="navbar-brand" href="#">Brand</a>
		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		<span class="sr-only">Toggle navigation</span>

		<!-- Набор иконок для кнопки -->

		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		</button>
		</div>

		<!-- Набор ссылок навигации, форм и других элементов меню (в мобильном устройстве будет находится в
		раскрывающеемся списке) -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

		<ul class="nav navbar-nav">
		<li class="active"><a href="#">Link</a>
		</li>
		<li><a href="#">Link</a>
		</li>
		<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
		<ul class="dropdown-menu" role="menu">
		<li><a href="#">Action</a>
		</li>
		<li><a href="#">Another action</a>
		</li>
		<li><a href="#">Something else here</a>
		</li>
		<li class="divider"></li>
		<li><a href="#">Separated link</a>
		</li>
		<li class="divider"></li>
		<li><a href="#">One more separated link</a>
		</li>
		</ul>
		</li>
		</ul>

		<form class="navbar-form navbar-left" role="search">
		<div class="form-group">
		<input type="text" class="form-control" placeholder="Search">
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
		</form>

		<ul class="nav navbar-nav navbar-right">
		<li><a href="#">Link</a>
		</li>
		<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
		<ul class="dropdown-menu" role="menu">
		<li><a href="#">Action</a>
		</li>
		<li><a href="#">Another action</a>
		</li>
		<li><a href="#">Something else here</a>
		</li>
		<li class="divider"></li>
		<li><a href="#">Separated link</a>
		</li>
		</ul>
		</li>
		</ul>

		</div>
		<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->