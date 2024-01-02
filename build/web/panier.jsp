<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="beans.Produit"%>
<%@page import="classPACK.PanierItem"%>
<%@page import="classPACK.Panier"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/panier.css">
        <title>Mon Panier</title>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <script>
            function removeFromCart(productId) {
                $.post("RemoveFromCart", {productId: productId}, function () {
                    location.reload();
                });
            }

            function updateQuantity(productId, operation) {
                $.post("ModifierQuantite", {productId: productId, operation: operation}, function () {
                    location.reload();
                });
            }
        </script>
    </head>
    <body>
        <div class="container">
            <header>
                <h1>Mon Panier</h1>
                <div class="card">
                    <h1>Articles du panier</h1>
                    <ul class="listCard">
                        <c:if test="${not empty panier.panierItems}">
                            <c:forEach var="panierItem" items="${panier.panierItems}">
                                <c:set var="produit" value="${panierItem.produit}" />
                                <c:set var="montant" value="${panierItem.montant}" />
                                <li class="cart-item" data-quantity="${panierItem.quantite}">
                                    <img src="images/${produit.photo}" alt="${produit.libelle}" class="product-image">
                                    <div class="item-details">
                                        <span class="item-name">${produit.libelle}</span>
                                        <span class="item-price">${produit.prix} DA</span>
                                        <div class="quantity-controls">
                                            <button class="quantity-btn" onclick="updateQuantity('${produit.libelle}', 'decrement')">-</button>
                                            <span class="quantity">${panierItem.quantite}</span>
                                            <button class="quantity-btn" onclick="updateQuantity('${produit.libelle}', 'increment')">+</button>
                                        </div>
                                        <span class="total-price">${montant} DA</span>
                                    </div>
                                    <button class="remove-btn" onclick="removeFromCart('${produit.libelle}')">Remove</button>
                                </li>
                            </c:forEach>
                        </c:if>
                        <c:if test="${empty panier.panierItems}">
                            <li>Le panier est vide</li>
                            </c:if>
                    </ul>
                    <br><br><br>
                    <div class="checkOut">
                        <div class="total">${not empty panier ? panier.calculerMontantTotal() : 0.0} DA</div>
                        <div class="closeShopping">
                            <a href="/">Retour au catalogue</a>
                        </div>
                        <div class="commande"><a href="commande.jsp">Commander</a></div>
                    </div>
                </div>
            </header>
        </div>
    </body>
</html>