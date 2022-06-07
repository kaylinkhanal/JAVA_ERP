

<nav class="navbar navbar-expand-sm bg-dark navbar-dark header">
    <a class="navbar-brand" href="/">Laconic ERP</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
<%--            <li class="nav-item active"><a class="nav-link" href="/personalRegister">Customer</a></li>--%>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Customer
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/personalRegister">Personal Register</a>
                    <a class="dropdown-item" href="/personalAddress">Personal Address</a>
<%--                    <div class="dropdown-divider"></div>--%>
                    <a class="dropdown-item" href="/personalContact">Personal Contact</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Document Management
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/document/create">Create Document Template</a>
                    <a class="dropdown-item" href="/document/list">Document Template List</a>
                    <a class="dropdown-item" href="/document/preview">Document Preview</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/document/typeList">Document Type List</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Email Management
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/email/create">Create Email Template</a>
                    <a class="dropdown-item" href="/email/list">Email Template List</a>
                </div>
            </li>
<%--            <li class="nav-item"><a class="nav-link" href="/document/typeList">Document Management</a></li>--%>
            <li class="nav-item"><a class="nav-link" href="/case/create">Case (Order)</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Installment/Invoice/Deposit</a></li>
            <li class="nav-item"><a class="nav-link" href="#">Report</a></li>

        </ul>

    </div>
</nav>