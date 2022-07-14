<%-- 
    Document   : eliminarHeroe
    Created on : 12 jul. 2022, 10:25:57
    Author     : joseg
--%>
<!DOCTYPE html>
<jsp:include page="comunes/inicioHTML.jsp" />
<jsp:include page="comunes/inicioHEAD.jsp" />
<jsp:include page="comunes/finHEAD.jsp" />
<jsp:include page="vistas/navbar.jsp" />
<body>
    <div class="container my-3">        
        <div class="d-flex h-100 flex-column align-items-center justify-content-center">
            <h4 class="my-3">¿Desea eliminar a ${heroe.superhero}?</h4>
            <div class="card mb-5 align-items-center">
                <div class="row">
                    <div class="col-12 col-md-4">
                        <img src="${heroe.foto}" class="card-img" alt="logo-superhero" />
                    </div>
                    <div class="col-12 col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">${heroe.superhero}</h5>
                            <p class="card-text m-0">${heroe.alter_ego}</p>
                            <p class="card-text m-0">${heroe.publisher}</p>
                            <!-- comment
                               <p class="text-muted m-0 text-truncate"></p>
                            -->
                            <p class="card-text m-0">
                                <small class="text-muted">${heroe.first_appearance}</small>
                            </p>                        
                            <div class="d-flex justify-content-around mt-2">
                                <a class="btn btn-secondary" href="${pageContext.request.contextPath}/heroes">Volver</a>
                                <form action="${pageContext.request.contextPath}/heroes?accion=delete&id=${heroe.id}" method="POST">
                                    <button type="submit" class="btn btn-danger">Borrar</button>                            
                                </form>
                            </div>                                              
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<jsp:include page="vistas/footer.jsp" />
<jsp:include page="comunes/finHTML.jsp" />

