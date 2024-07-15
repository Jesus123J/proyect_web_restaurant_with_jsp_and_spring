<%-- 
    Document   : Dashboard
    Created on : 29 may 2024, 5:51:07 p.m.
    Author     : Jesus Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cliente</title>
        <link rel="stylesheet" href="cssDashboard.css">
        <link rel="icon" href="img/Imagen2.png">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="Client-page">
        <script>
            function getBasePath() {
                // Obtiene el origen de la URL (protocolo + dominio)
                const origin = window.location.origin;
                // Obtiene el path principal (base path) de la URL
                const basePath = window.location.pathname.split('/')[1];
                // Combina el origen con el path principal
                return `${origin}/${basePath}`;
                    }

                    function addPathToBase(newPath) {
                        // Obtiene el base path
                        const basePath = getBasePath();
                        // Combina el base path con el nuevo path
                        const combinedPath = `${basePath}${newPath}`;
                        // Actualiza la URL con el nuevo path
                        window.location.href = combinedPath;
                    }
        </script>
        <header>
            <div class="header-content">
                <button class="back-button" onclick="window.location.href = '<%= request.getContextPath()%>/login'">Retroceder</button>
                <h1>CATALOGO DE RACOON BROTHERS</h1>
            </div>
        </header>
        <main>
            <!-- Contenido principal -->
            <section class="carousel-section">
                <div id="carouselExampleIndicators" class="carousel slide">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="https://i.pinimg.com/736x/1a/95/f5/1a95f59a786b67136725915db1425d5e.jpg" class="d-block w-100" alt="imagen 1">
                        </div>

                        <div class="carousel-item">
                            <img src="https://i.pinimg.com/564x/f3/23/b4/f323b4acad6f3de84740db0b6366a323.jpg" class="d-block w-100" alt="imagen 2">
                        </div>
                        <div class="carousel-item">
                            <img src="https://i.pinimg.com/564x/ef/63/e5/ef63e5601512bc7b2cce075e0fbda31f.jpg" class="d-block w-100" alt="imagen 3">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </section>

            <section class="game-list">
                <!-- Lista de juegos y promociones -->
                <div class="game-item" data-id="1">
                    <img src="https://cdn.pixabay.com/photo/2016/05/25/10/43/hamburger-1414422_960_720.jpg" alt="Promo 1">
                    <h2>La Conera</h2>
                    <h2>Precio</h2>
                    <p>S/10.00</p>

                </div>
                <div class="game-item" data-id="2">
                    <img src="https://lh3.googleusercontent.com/proxy/7IRJReGHEFkidV8-NXyw7XkdAKXL7i-p23QtehjwPg_dcC0itgi48aAJkB8zUmR5qJGf0INUYSOPECSyyCIa1_0BwK6rul0CnkUHZK2idvQgJhM2PMO5Neq9bR3d6HLs6g" alt="Promo 2">
                    <h2>La Mestiza</h2>
                    <p>S/12.00</p>

                </div>
                <div class="game-item" data-id="3">
                    <img src="https://recetaslaplanchetta.com/wp-content/uploads/cooked/images/recipes/recipe_788.jpg" alt="Juego 3">
                    <h2>La Burguesa</h2>
                    <h2>Precio</h2>
                    <p>S/13.00</p>

                </div>




                <div class="game-item" data-id="6">
                    <img src="https://www.distribuidoramaryori.com/wp-content/uploads/2016/05/gaseosas-coca-cola-y-inca-kola.jpg" alt="Juego 6">
                    <h2>Inka Cola o Coca cola de 600ml</h2>
                    <h2>Precio</h2>
                    <p>S/3.50</p>

                </div>
                <div class="game-item" data-id="7">
                    <img src="https://tofuu.getjusto.com/orioneat-prod/h8DJqdbWKxmAvs4Xn-6715.png" alt="Juego 7">
                    <h2>Pepsi de 350ml</h2>
                    <h2>Precio</h2>
                    <p>S/1.50</p>

                </div>
                <div class="game-item" data-id="7">
                    <!-- Enlace de descarga directa desde OneDrive/SharePoint -->
                    <!-- https://utpedupe-my.sharepoint.com/:i:/g/personal/u21218196_utp_edu_pe/EYQKBZnPlYNJmchIImzTUwAB5Nyfa-URDYxki_iJOVe5mA?e=4tUTVq -->
                    <img src="https://utpedupe-my.sharepoint.com/personal/u21218196_utp_edu_pe/_layouts/15/download.aspx?share=EYQKBZnPlYNJmchIImzTUwAB5Nyfa-URDYxki_iJOVe5mA" alt="Juego 7">
                    <h2>Pepsi de 350ml</h2>
                    <h2>Precio</h2>
                    <p>S/1.50</p>
                </div>
                <!-- Secciones de productos -->
            </section>
        </main>
        <footer>
            <div class="cuadro">
                <img src="img/Imagen2.png" alt="Icono">
                <a href="Index.html">Menu Principal</a>
            </div>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
