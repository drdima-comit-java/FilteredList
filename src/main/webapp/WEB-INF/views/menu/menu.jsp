
<nav class="navbar navbar-expand-lg navbar-dark bg-primary navbar-inverse" role="navigation">
    <a class="navbar-brand" href="/home">FL</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="nav navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/home"><i class="fa fa-home" style="font-size:30px"></i>
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/base-lists">My Excluded Soft Lists</a>
            </li>

            <li class="nav-item">
            <a class="nav-link" href="/filtered-lists-view">My Computers Lists</a>
            </li>

            <li class="nav-item">
            <a class="btn btn-info ml-auto" href="/new-list-create">Create a new Computer</a>
            </li>

            <li class="nav-item">
            <a class="nav-link" href="/app-setup">Application setup</a>
            </li>

        </ul>
        <div class="collapse navbar-collapse flex-grow-0" id="navbarSupportedContent">
        <ul class="navbar-nav text-right">

            <li class="nav-item">
                <label class="navbar-text">Signed in as <a href="/sign-out">${user.userName}</a>
                </label>
            </li>
        </ul>
        </div>



        <%--<form class="form-inline my-2 my-lg-0">--%>
            <%--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">--%>
            <%--<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
        <%--</form>--%>
    </div>


</nav>






