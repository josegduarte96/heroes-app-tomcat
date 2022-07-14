<%-- 
    Document   : editHeroe
    Created on : 14 jul. 2022, 12:33:31
    Author     : joseg
--%>

<jsp:include page="comunes/inicioHTML.jsp" />
<jsp:include page="comunes/inicioHEAD.jsp" />
<jsp:include page="comunes/finHEAD.jsp" />
<jsp:include page="vistas/navbar.jsp" />
<div class="container-fluid my-2">
    <form id="formEditarHeroe" action="${pageContext.request.contextPath}/heroes?accion=update&id=${heroe.id}"
          method="post" class="was-validated border rounded-3 bg-light d-flex justify-content-center">
        <div class="card my-2 p-2" style="width: 40rem;">
            <div class="row card-body">
                <div class="col-12 d-flex justify-content-center col-sm-6 mb-2">
                    <img src="${heroe.foto}" id="superHeroEdit" style="max-height: 380px" class="img-fluid rounded" alt="logo-superhero" />
                </div>
                <div class="col-12 col-sm-6 mb-3">
                    <div class="row">
                        <div class="col-12 mb-1">
                            <label for="nombreHeroe" class="m-0 form-label">Super Heroe</label>
                            <input type="text" class="form-control" id="nombreHeroe" name="nombreHeroe" value="${heroe.superhero}" required>
                        </div>
                        <div class="col-6 mb-1">
                            <label for="editor" class="m-0 form-label">Editor</label>
                            <input type="text" class="form-control" id="editor" name="editor" value="${heroe.publisher}" required>
                        </div>
                        <div class="col-6 mb-1">
                            <label for="nombrePersona" class="m-0 form-label">Nombre</label>
                            <input type="text" class="form-control" id="nombrePersona" name="nombrePersona" value="${heroe.alter_ego}" required>
                        </div>
                        <div class="col-12 mb-1">
                            <label for="characters" class="m-0 form-label">Otros protagonistas:</label>
                            <input type="text" class="form-control" id="characters" name="characters" value="${heroe.characters}" required>
                        </div>
                        <div class="col-12 mb-1">
                            <label for="firstAp" class="m-0 form-label">Primera aparicion:</label>
                            <input type="text" class="form-control" id="firstAp" name="firstAp" value="${heroe.first_appearance}" required>
                        </div>
                        <div class="col-12 mb-1">
                            <label for="inputFoto" class="m-0 form-label">Cambiar foto:</label>
                            <div class="input-group mb-1">
                                <input type="file" accept="image/*" class="form-control" id="inputFoto" name="foto">
                                <input type="hidden" id="fotoBase64" accept="image" name="fotoBase64">
                            </div>                     
                        </div>
                        <div class="col-12 d-flex justify-content-around mb-1">
                            <a href="${pageContext.request.contextPath}/heroes" class="btn btn-info">Regresar</a>
                            <button type="submit" class="btn btn-warning">Actualizar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>                    
    </form>
</div>
<script src="scripts/fotobase64.js" ></script>
<jsp:include page="vistas/footer.jsp" />
<jsp:include page="comunes/finHTML.jsp" />
