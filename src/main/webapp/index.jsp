<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="es">
<head>
    <title>Examen TW</title>

    <!-- Metadatos -->
    <meta name="author" content="Jose Luis Obiang Ela Nanguang">
    <meta name="description" content="Bootstrap, Review, CSS, JS">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="" type="image/x-icon">
    <meta charset="UTF-8">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="d-flex flex-column min-vh-100" data-bs-theme="dark">
<header>
    <h1 class="text-center">Examen TW</h1>

    <!-- Incluir Barra de navegación -->
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"><i class="bi bi-house"></i></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item mx-3">
                        <% if (session.getAttribute("user") == null) { %>
                        <a class="nav-link active" aria-current="page" href="#" aria-controls="offcanvasResponsive"
                           data-bs-toggle="modal" data-bs-target="#exampleModal">Iniciar sesión</a>
                        <%} else {%>
                        <a href="${pageContext.request.contextPath}/showPerfil" class="text-decoration-none"><i class="bi bi-person-badge">${sessionScope.user.getNombre_usuario()}</i></a>
                        <%}%>

                        <!-- Modal -->
                        <div class="modal fade" title="${sessionScope.showLogin}" id="exampleModal" tabindex="-1"
                             aria-labelledby="exampleModalLabel"
                             aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="exampleModalLabel">Identificarse</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <form class="row g-3"

                                              id="formulario" action="${pageContext.request.contextPath}/actionLogin"
                                              method="post">

                                            <!-- Mostrar el campo de nombre de usuario y contraseña tanto en inicio de sesión como en registro -->
                                            <div class="col-md-12" id="campo-username">
                                                <label for="username" class="form-label">Usuario</label>
                                                <input type="text" class="form-control" id="username" name="username"
                                                       required
                                                       aria-describedby="usernameHelp">
                                                <div class="valid-feedback">
                                                    Genial!
                                                </div>
                                                <div id="usernameHelp" class="form-text">Debe tener al menos 3
                                                    caracteres
                                                </div>
                                            </div>

                                            <div class="col-md-12">
                                                <label for="password" class="form-label">Contraseña</label>
                                                <input type="password" class="form-control" id="password"
                                                       name="password" required
                                                       aria-describedby="passwordHelp">
                                                <div class="valid-feedback">
                                                    Genial!
                                                </div>
                                                <div id="passwordHelp" class="form-text">Debe tener al menos 6
                                                    caracteres
                                                </div>
                                            </div>

                                            <div class="col-12">
                                                <div class="form-check">
                                                    <input class="form-check-input" type="checkbox" value=""
                                                           id="invalidCheck">
                                                    <label class="form-check-label" for="invalidCheck">
                                                        Acepta los términos y condiciones
                                                    </label>
                                                    <div class="invalid-feedback">
                                                        Debes aceptar antes de enviar.
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="modal-footer">
                                                <button class="btn btn-primary" type="submit" value="login"
                                                        name="action">Iniciar
                                                    sesión
                                                </button>

                                                <button class="btn btn-secondary" type="submit" value="signUp"
                                                        name="action">Registrarse
                                                </button>
                                            </div>
                                        </form>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="nav-item mx-3">
                        <a class="nav-link" href="${pageContext.request.contextPath}/logout">Cerrar sesión</a>
                    </li>
                </ul>
                <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>

    <% if (request.getAttribute("mensaje") != null) { %>
    <% if (((String) request.getAttribute("mensaje")).toLowerCase().contains("no") || ((String) request.getAttribute("mensaje")).toLowerCase().contains("error")) { %>
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <strong>Error:</strong> <%= request.getAttribute("mensaje") %>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <% } else {%>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <strong>Éxito:</strong> <%= request.getAttribute("mensaje") %>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <% } %>
    <% } %>
</header>

<main class="flex-grow-1">
    <!-- Contenido Principal -->
</main>

<!-- Pie de página -->
<footer class="py-3 bg-secondary text-center position-absolute bottom-0 w-100">
    <div class="container">
        <p class="small m-0">&copy; 2024 - Jose Luis Obiang Ela Nanguang</p>
    </div>
</footer>

<!-- Script JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

<script src="./main.js"></script>
</body>
</html>