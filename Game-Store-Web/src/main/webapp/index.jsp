<%@ page import="sun.net.www.http.HttpClient" %>
<%@ page import="org.apache.http.client.methods.*" %>
<%@ page import="java.net.URI" %>
<%@ page import="java.net.URISyntaxException" %>
<%@ page import="org.apache.http.impl.client.HttpClients" %>
<%@ page import="org.apache.http.impl.client.CloseableHttpClient" %>
<%@ page import="java.io.IOException" %>
<%@ page import="org.apache.http.util.EntityUtils" %>
<%@ page import="org.apache.http.HttpEntity" %>
<%@ page import="com.store.game.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.store.game.dao.ProductsDao" %>
<%@ page import="com.store.game.models.Product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%
    HttpGet req;
    List<Product> productList = null;
    try {
        req = new HttpGet(new URI("http://localhost:8081/game/store/products/all"));
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse res = httpClient.execute(req)) {

            HttpEntity entity = res.getEntity();
            if (entity != null) {
                // return it as a String
                productList = new ProductsDao().getAllProducts(EntityUtils.toString(entity));
            }

        }
    } catch (URISyntaxException e) {
        e.printStackTrace();
    } catch (IOException e) {
    e.printStackTrace();
    }

%>
<html>
<head>
    <%@include file="./includes/head.jsp"%>
    <title>SQUID Game Store</title>
</head>
<body>
<%@include file="includes/navBar.jsp"%>
<div class="container">
    <div class="card-header my-3">All Games</div>
    <div class="row">
        <%
            if (!productList.isEmpty()) {
                for (Product p : productList) {
        %>
        <div class="col-md-3 my-3">
            <div class="card w-100">
                <img class="card-img-top" src="product-image/<%=p.getImgName()%>"
                     alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title"><%=p.getProductName() %></h5>
                    <h6 class="price">Price: $<%=p.getProductPrice() %></h6>
                    <h6 class="category">Category: <%=p.getProductCategory() %></h6>
                    <div class="mt-3 d-flex justify-content-between">
                        <a class="btn btn-dark" href="add-to-cart?id=<%=p.getProductId()%>">Add to Cart</a> <a
                            class="btn btn-primary" href="#">Buy Now</a>
                    </div>
                </div>
            </div>
        </div>
        <%
                }
            } else {
                out.println("There is no proucts");
            }
        %>

    </div>
</div>
<%@include file="includes/footer.jsp"%>
</body>
</html>
