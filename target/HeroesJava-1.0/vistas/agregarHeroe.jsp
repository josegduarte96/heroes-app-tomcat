<%-- 
    Document   : agregarHeroe
    Created on : 24 jun. 2022, 15:49:10
    Author     : joseg
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="addHero" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">¿Que heroe es?</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form id="formEditarHeroe" action="${pageContext.request.contextPath}/heroes?accion=add"
                  method="post" class="was-validated border p-4 rounded-3 bg-light">
                <div class="modal-body">


                    <div class="row">
                        <div class="col-12 mb-3">
                            <label for="idHeroe" class="form-label">Selecciona un heroe para agregar y completa sus campos</label>
                            <select class="form-select idHero" name="idHeroe" placeholder="Selecciona.." required>                                                            
                                <option value="">Seleccionar...</option>
                                <c:forEach items="${listadoNuevosHeroes}" var="nuevoHeroe" varStatus="loop">                                    
                                    <option value="${nuevoHeroe}">${loop.index + 1}</option>
                                </c:forEach>
                            </select>                            
                        </div>
                        <div class="col-12 d-flex justify-content-center">                            
                            <img id="heroImg" src="" />
                        </div>
                        <div class="col-12 mb-3">
                            <label for="nombreHeroe" class="form-label">Super Heroe</label>
                            <input type="text" class="form-control" id="nombreHeroe" name="nombreHeroe" placeholder="Nombre del superheroe" required>
                        </div>
                        <div class="col-12 mb-3">
                            <label for="editor" class="form-label">Editor</label>
                            <input type="text" class="form-control" id="editor" name="editor" placeholder="Editor" required>
                        </div>
                        <div class="col-12 mb-3">
                            <label for="nombrePersona" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="nombrePersona" name="nombrePersona" placeholder="Nombre del personaje" required>
                        </div>
                        <div class="col-12 mb-3">
                            <label for="firstAp" class="form-label">Primera aparicion:</label>
                            <input type="text" class="form-control" id="firstAp" name="firstAp" placeholder="Primera aparicion" required>
                        </div>
                    </div>


                </div>                    
                <div class="modal-footer">
                    <button class="btn btn-warning" type="submit" data-bs-dismiss="modal">Agregar</button>
                </div>
            </form>

        </div>
    </div>
</div>
                        
                        <script>
                            const selectElement = document.querySelector('.idHero');
                            const imgElement = document.querySelector('#heroImg');
                            selectElement.addEventListener('change', e => {
                                imgElement.src = 'assets/' + e.target.value + '.jpg';                                
                                imgElement.height = '150'
                            })
                            
                        </script>                        
