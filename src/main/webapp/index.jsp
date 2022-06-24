<!DOCTYPE html>
<jsp:include page="comunes/inicioHTML.jsp" />
<jsp:include page="comunes/inicioHEAD.jsp" />
<jsp:include page="comunes/finHEAD.jsp" />
    <body>
        <jsp:include page="vistas/navbar.jsp" />
        <div class="container-fluid p-4">
            <h1 class="text-center">HeroesApp</h1>
            <p class="text-center fs-5">
                La app cuenta con un listado de Heroes, te permitira agregar, eliminar y actualizar cada Heroe con los valores que quieras,
                en el momento que agregues un nuevo heroe selecciona una imagen del listado e intenta rellenar cada campo con la informacion del heroe.
                
            </p>
            <p class="fw-bold text-center">¡Veamos que tanto conoces sobre los superheroes!</p>
            <div class="d-flex justify-content-center">
                <a class="btn btn-info" href="${pageContext.request.contextPath}/heroes">Ir a la app</a>
            </div>
            <p class="fw-bold text-center mt-4">*Diseñada para fines educativos*</p>
        </div>
        <div class="position-fixed bottom-0 w-100 bg-dark d-flex justify-content-center align-items-center text-white" style="height: 45px; ">
            <i class="fa-solid fa-copyright"></i>
            <h5 class="mx-2 my-0">Creado por 
                <a class="text-warning" href="https://joseduarte.netlify.app/" target="_blank">Jose Duarte</a>
            </h5>
        </div>
    </body>
<jsp:include page="comunes/finHTML.jsp" />
