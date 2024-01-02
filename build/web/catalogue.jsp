<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="catalog">
    <div class="cart-icon-container">
        <a href="panier.jsp">
            <i class="fa-solid fa-cart-shopping"></i> 
        </a>
        <div class="cart-notification"></div>
    </div>
    <h2>Catalogue des produits</h2>
    <ul class="product-list">
        <li class="product-item">
            <img src="/images/Blueberry.jpg" alt="">
            <div class="product-details">
                <span class="product-name">Blueberry</span>
                <span class="product-price">250 DA</span>
                <span class="product-qts">qts: 20</span>
            </div>
            <form action="AjouterPanier" method="POST">
                <input type="hidden" name="productId" value="">
                <button class="add-to-cart-btn" type="submit">Ajouter</button>
            </form>

        </li>
        <li class="product-item">
            <img src="<c:url value='/images/banana.jpg' />" alt="">
            <div class="product-details">
                <span class="product-name">Banana</span>
                <span class="product-price">250 DA</span>
                <span class="product-qts">qts: 20</span>
            </div>
            <form action="AjouterPanier" method="POST">
                <input type="hidden" name="productId" value="">
                <button class="add-to-cart-btn" type="submit">Ajouter</button>
            </form>

        </li>
        <li class="product-item">
            <img src="/images/Plum.jpg" alt="">
            <div class="product-details">
                <span class="product-name">Plum</span>
                <span class="product-price">250 DA</span>
                <span class="product-qts">qts: 20</span>
            </div>
            <form action="AjouterPanier" method="POST">
                <input type="hidden" name="productId" value="">
                <button class="add-to-cart-btn" type="submit">Ajouter</button>
            </form>

        </li>
        <li class="product-item">
            <img src="/images/Cherry.jpg" alt="">
            <div class="product-details">
                <span class="product-name">Cherry</span>
                <span class="product-price">250 DA</span>
                <span class="product-qts">qts: 20</span>
            </div>
            <form action="AjouterPanier" method="POST">
                <input type="hidden" name="productId" value="">
                <button class="add-to-cart-btn" type="submit">Ajouter</button>
            </form>

        </li>
        <li class="product-item">
            <img src="/images/Orange.jpg" alt="">
            <div class="product-details">
                <span class="product-name">Orange</span>
                <span class="product-price">250 DA</span>
                <span class="product-qts">qts: 20</span>
            </div>
            <form action="AjouterPanier" method="POST">
                <input type="hidden" name="productId" value="">
                <button class="add-to-cart-btn" type="submit">Ajouter</button>
            </form>

        </li>
        <li class="product-item">
            <img src="/images/Apple.jpg" alt="">
            <div class="product-details">
                <span class="product-name">Apple</span>
                <span class="product-price">250 DA</span>
                <span class="product-qts">qts: 20</span>
            </div>
            <form action="AjouterPanier" method="POST">
                <input type="hidden" name="productId" value="">
                <button class="add-to-cart-btn" type="submit">Ajouter</button>
            </form>

        </li>
        <li class="product-item">
            <img src="/images/Peach.jpg" alt="">
            <div class="product-details">
                <span class="product-name">Peach</span>
                <span class="product-price">250 DA</span>
                <span class="product-qts">qts: 20</span>
            </div>
            <form action="AjouterPanier" method="POST">
                <input type="hidden" name="productId" value="">
                <button class="add-to-cart-btn" type="submit">Ajouter</button>
            </form>

        </li>
        <li class="product-item">
            <img src="/images/Strawberry.jpg" alt="">
            <div class="product-details">
                <span class="product-name">Strawberry</span>
                <span class="product-price">250 DA</span>
                <span class="product-qts">qts: 20</span>
            </div>
            <form action="AjouterPanier" method="POST">
                <input type="hidden" name="productId" value="">
                <button class="add-to-cart-btn" type="submit">Ajouter</button>
            </form>

        </li>
        <c:forEach var="produit" items="${produits}">
        <li class="product-item">
            <img src="${produit.photo}" alt="">
            <div class="product-details">
                <span class="product-name"><c:out value="${produit.libelle}"/></span>
                <span class="product-price"><c:out value="${produit.prix}"/> DA</span>
                <span class="product-qts">qts: <c:out value="${produit.qts}"/></span>
            </div>
            <form action="AjouterPanier" method="POST">
                <input type="hidden" name="productLabel" value="${produit.libelle}">
                <button class="add-to-cart-btn" type="submit">Ajouter</button>
            </form>

        </li>
        </c:forEach>
    </ul>
</div>


