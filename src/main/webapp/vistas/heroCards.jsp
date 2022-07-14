<%-- 
    Document   : heroCards
    Created on : 21 jun. 2022, 19:13:13
    Author     : joseg
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${listaHeroes.size() <= 0}">
        <h2>Agrega un heroe para empezar..</h2>
    </c:when>
    <c:otherwise>
        <c:forEach items="${listaHeroes}" var="heroe">  
            <div class="col">
                <div class="card">
                    <div class="row">
                        <div class="col-12 col-md-4">
                            <img src="${heroe.foto}" class="card-img img-fluid h-100" alt="logo-superhero" />
                        </div>
                        <div class="col-12 col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">${heroe.superhero}</h5>
                                <p class="card-text m-0">${heroe.alter_ego}</p>
                                <p class="card-text m-0">${heroe.publisher}</p>
                                <p class="card-text m-0">
                                    <small class="text-muted">${heroe.first_appearance}</small>
                                </p>                        
                                <div class="d-flex justify-content-around mt-2">
                                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/heroes?accion=watch&id=${heroe.id}">Ver Heroe</a>
                                    <a href="${pageContext.request.contextPath}/heroes?accion=remove&id=${heroe.id}" class="btn btn-danger">Borrar</a>                            
                                </div>                                              
                            </div>
                        </div>
                    </div>
                </div>
            </div>                        
        </c:forEach >
    </c:otherwise>
</c:choose>
