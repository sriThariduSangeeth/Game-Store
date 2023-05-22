<%@ page import="com.store.game.models.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.store.game.models.Product" %>
<%@ page import="org.apache.http.client.methods.HttpGet" %>
<%@ page import="java.net.URI" %>
<%@ page import="org.apache.http.impl.client.CloseableHttpClient" %>
<%@ page import="org.apache.http.client.methods.CloseableHttpResponse" %>
<%@ page import="org.apache.http.impl.client.HttpClients" %>
<%@ page import="org.apache.http.HttpEntity" %>
<%@ page import="com.store.game.dao.ProductsDao" %>
<%@ page import="org.apache.http.util.EntityUtils" %>
<%@ page import="java.net.URISyntaxException" %>
<%@ page import="java.io.IOException" %>
<%@ page import="org.apache.http.client.utils.URIBuilder" %>
<%@ page import="com.store.game.models.User" %><%--
  Created by IntelliJ IDEA.
  User: dtsangeeth
  Date: 5/22/23
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%
    List<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    User user = (User) session.getAttribute("loguser");
    if (user == null) {
        user = new User(425, "minura@gmail.com", "Minura", "Hasantha", "0771122334", "No:1, Temple Road, walpitamulla.", "Veyangoda", "10033");
        session.setAttribute("loguser", user);
    }
    List<Product> productList = new ArrayList<>();
    if (cart_list != null && !cart_list.isEmpty()) {
        for (Cart cart : cart_list) {
            try {
                HttpGet req = new HttpGet("http://localhost:8081");
                URI uri = new URIBuilder(req.getURI())
                        .setPath("/game/store/" + cart.productId + "/product")
                        .build();
                req.setURI(uri);
                try (CloseableHttpClient httpClient = HttpClients.createDefault();
                     CloseableHttpResponse res = httpClient.execute(req)) {
                    HttpEntity entity = res.getEntity();
                    if (entity != null) {
                        // return it as a String
                        Product pro = new ProductsDao().getProduct(EntityUtils.toString(entity));
                        pro.setQuantity(cart.getQuantity());
                        productList.add(pro);
                    }
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    session.setAttribute("cart-list",productList);
    double total = new ProductsDao().getTotalCartPrice(productList);

%>
<html>
<head>
    <%@include file="./includes/head.jsp" %>
    <title>SQUID Game Store</title>
</head>
<body>
<%@include file="includes/navBar.jsp" %>
<div class="container">
    <div class="card-header my-3">All Check List</div>
    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">No.</th>
            <th scope="col">Name</th>
            <th scope="col">Category</th>
            <th scope="col">Quantity</th>
            <th scope="col">Price</th>
            <th scope="col">Remove</th>
        </tr>
        </thead>
        <tbody>

        <%
            if (cart_list != null) {
                int x = 1;
                for (Product o : productList) {%>
        <tr>
            <td><%=x++ %>
            </td>
            <td><%=o.getProductName() %>
            </td>
            <td><%=o.getProductCategory() %>
            </td>
            <td><%=o.getQuantity() %>
            </td>
            <td><%=o.getProductPrice() %>
            </td>
            <td><a class="btn btn-sm btn-danger" href="#">Remove Item</a></td>
        </tr>
        <%
                }
            } else {
                out.println("There is no proucts Selected for your cart");
            }
        %>

        </tbody>
    </table>
    <div class="card-header my-3">User Details</div>
    <table class="table table-light">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Mobile</th>
            <th scope="col">Address</th>
            <th scope="col">Email</th>
            <th scope="col">city</th>
            <th scope="col">PostalCode</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><%=user.getFname() %>
            </td>
            <td><%=user.getLname() %>
            </td>
            <td><%=user.getMobile() %>
            </td>
            <td><%=user.getAddress() %>
            </td>
            <td><%=user.getEmail() %>
            </td>
            <td><%=user.getCity() %>
            </td>
            <td><%=user.getPostalCode() %>
            </td>
        </tr>


        </tbody>
    </table>

    <div class="card-header d-flex py-3"><h3>Total Price: $ <%= total %>
    </h3></div>
    </br></br>
    <div class="card text-center">
        <div class="card-header">
            <ul class="nav nav-tabs card-header-tabs">
                <li class="nav-item">
                    <a class="nav-link" href="#card" data-toggle="tab">Card</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#paypal" data-toggle="tab">PayPal</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#bank" data-toggle="tab">Bank Deposit</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#cash" data-toggle="tab">Cash On Delivery</a>
                </li>
            </ul>
        </div>
        <div class="card-body">
            <div class="tab-content">
                <div class="tab-pane active" id="card">
                    <h5 class="card-title">Card Payment</h5>
                    <%@include file="payments/card.jsp" %>
                </div>
                <div class="tab-pane" id="paypal">
                    <h5 class="card-title">PayPal Payment</h5>
                    <%@include file="payments/paypal.jsp" %>
                </div>
                <div class="tab-pane" id="bank">
                    <h5 class="card-title">Bak Deposit</h5>
                    <%@include file="payments/bank.jsp" %>
                </div>
                <div class="tab-pane" id="cash">
                    <h5 class="card-title">Cash On Delivery</h5>
                    <%@include file="payments/cash.jsp" %>
                </div>
            </div>

        </div>
    </div>
</div>


<%@include file="includes/footer.jsp" %>
</body>
</html>
