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