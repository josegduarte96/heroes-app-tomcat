<%-- 
    Document   : heroCards
    Created on : 21 jun. 2022, 19:13:13
    Author     : joseg
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${listaHeroes}" var="heroe">  
    <div class="col">
        <div class="card">
            <div class="row">
                <div class="col-12 col-md-4">
                    <img src="assets/${heroe.foto}" class="card-img" alt="logo-superhero" />
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
                            <a class="btn btn-warning" href="" data-bs-toggle="modal" data-bs-target="#${heroe.id}">Actualizar</a>
                            <form action="${pageContext.request.contextPath}/heroes?accion=delete&id=${heroe.id}" method="POST">
                                <button type="submit" class="btn btn-danger">Borrar</button>                            
                            </form>
                        </div>                                              
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="${heroe.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">${heroe.superhero}</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form id="formEditarHeroe" action="${pageContext.request.contextPath}/heroes?accion=update&id=${heroe.id}"
                      method="post" class="was-validated border p-4 rounded-3 bg-light">
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-6">
                                <img src="assets/${heroe.foto}" class="img-fluid rounded" alt="logo-superhero" />
                            </div>
                            <div class="col-6">
                                <div class="row">
                                    <div class="col-12 mb-3">
                                        <label for="nombreHeroe" class="form-label">Super Heroe</label>
                                        <input type="text" class="form-control" id="nombreHeroe" name="nombreHeroe" value="${heroe.superhero}" required>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <label for="editor" class="form-label">Editor</label>
                                        <input type="text" class="form-control" id="editor" name="editor" value="${heroe.publisher}" required>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <label for="nombrePersona" class="form-label">Nombre</label>
                                        <input type="text" class="form-control" id="nombrePersona" name="nombrePersona" value="${heroe.alter_ego}" required>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <label for="firstAp" class="form-label">Primera aparicion:</label>
                                        <input type="text" class="form-control" id="firstAp" name="firstAp" value="${heroe.first_appearance}" required>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>                    
                    <div class="modal-footer">
                        <button class="btn btn-warning" type="submit" data-bs-dismiss="modal">Actualizar</button>
                    </div>
                </form>

            </div>
        </div>
    </div>                        
</c:forEach >
