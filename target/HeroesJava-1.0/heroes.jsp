<%-- 
    Document   : heroes
    Created on : 21 jun. 2022, 16:42:33
    Author     : joseg
--%>
<jsp:include page="comunes/inicioHTML.jsp" />
<jsp:include page="comunes/inicioHEAD.jsp" />
<jsp:include page="comunes/finHEAD.jsp" />
<jsp:include page="vistas/navbar.jsp" />
<section class="h-75 p-3 my-4">
    <div class="p-3">
        <button data-bs-toggle="modal" data-bs-target="#addHero" class="btn btn-info">Agregar Heroe</button>
    </div>
    <div class="row row-cols-2 row-cols-md-3 g-3 my-2 container-fluid h-75">        
        <jsp:include page="vistas/heroCards.jsp" />
    </div>
        <jsp:include page="vistas/agregarHeroe.jsp" />
</section>
<jsp:include page="vistas/footer.jsp" />
<jsp:include page="comunes/finHTML.jsp" />
