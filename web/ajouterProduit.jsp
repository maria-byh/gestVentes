<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter Produit</title>
    <link rel="stylesheet" href="css/ajouterProduit.css">
</head>
<body>

    <div class="navbar">
        <a href="catalogue.jsp">Catalogue</a>
        <a href="/">Déconnexion</a>
    </div>

    <div class="form">
        <p>Ajouter Produit</p>
        <form method="post" action="AjouterProduit" enctype="multipart/form-data">
            <input type="text" name="libelle" placeholder="Libellé" required>
            <input type="text" name="prix" placeholder="Prix" required>
            <input type="text" name="qts" placeholder="Quantité" required>
            <input type="file" name="image" accept="image/*" required>
            <input type="submit" value="Ajouter" name="submit">
        </form>
    </div>

</body>
</html>